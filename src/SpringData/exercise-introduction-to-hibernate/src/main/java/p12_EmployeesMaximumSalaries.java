import entities.Employee;

import javax.persistence.EntityManager;

public class p12_EmployeesMaximumSalaries {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery(
                        "SELECT MAX(salary), department.name FROM Employee AS e " +
                                "GROUP BY department.name " +
                                "HAVING MAX(salary) NOT BETWEEN 30000 AND 70000", Object[].class)
                .getResultList()
                .forEach(o -> System.out.printf("%s %s%n", o[0], o[1]));

    }
}
