import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;

public class p05_EmployeesFromDepartment {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        entityManager.createQuery(
                        "SELECT e FROM Employee AS e " +
                                "WHERE e.department.name = :name " +
                                "ORDER BY e.salary, e.id", Employee.class)
                .setParameter("name", "Research and Development")
                .getResultList()
                .forEach(e -> System.out.printf("%s %s from %s - %.2f%n",
                        e.getFirstName(), e.getLastName(), e.getDepartment().getName(), e.getSalary()));
    }
}
