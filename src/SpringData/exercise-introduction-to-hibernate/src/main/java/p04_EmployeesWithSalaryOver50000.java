import entities.Employee;

import javax.persistence.EntityManager;

public class p04_EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery(
                        "SELECT e FROM Employee AS e " +
                                "WHERE e.salary > 50000", Employee.class)
                .getResultList()
                .forEach(e -> System.out.println(e.getFirstName()));
    }
}
