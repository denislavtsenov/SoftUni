import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class p11_FindEmployeesByFirstName {
    public static void main(String[] args) {
        EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<Employee> resultList = getEmployees(entityManager, input);

        printEmployees(resultList);

    }

    private static List<Employee> getEmployees(EntityManager entityManager, String input) {
        List<Employee> resultList = entityManager.createQuery(
                        "SELECT e FROM Employee AS e " +
                                "WHERE e.firstName LIKE CONCAT(:pattern, '%')", Employee.class)
                .setParameter("pattern", input)
                .getResultList();
        return resultList;
    }

    private static void printEmployees(List<Employee> resultList) {
        resultList.forEach(e -> System.out.printf("%s %s - %s - (%.2f)%n",
                e.getFirstName(), e.getLastName(), e.getJobTitle(), e.getSalary()));
    }
}
