import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class p10_IncreaseSalaries {
    private static final List<String> DEPARTMENTS_TO_INCREASE_SALARY =
            List.of("Engineering", "Tool Design", "Marketing", "Information Services");

    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = getEmployees(entityManager);

        employees.forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        printEmployees(employees);

    }

    private static void printEmployees(List<Employee> employees) {
        for (Employee employee : employees) {
            System.out.printf("%s %s (%.2f)%n",
                    employee.getFirstName(), employee.getLastName(), employee.getSalary());
        }
    }

    private static List<Employee> getEmployees(EntityManager entityManager) {
        List<Employee> employees = entityManager.createQuery(
                        "SELECT e FROM Employee AS e " +
                                "WHERE department.name IN (:departments)", Employee.class)
                .setParameter("departments", (DEPARTMENTS_TO_INCREASE_SALARY))
                .getResultList();
        return employees;
    }
}
