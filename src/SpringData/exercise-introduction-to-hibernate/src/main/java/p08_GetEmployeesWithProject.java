import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p08_GetEmployeesWithProject {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        int employeeId = Integer.parseInt(scanner.nextLine());

        List<Employee> employeesList = getEmployeeById(entityManager, employeeId);

        printEmployeeInfo(employeesList);
    }

    private static List<Employee> getEmployeeById(EntityManager entityManager, int employeeId) {
        List<Employee> employeesList = entityManager.createQuery(
                        "SELECT e FROM Employee AS e " +
                                "WHERE e.id = :id ", Employee.class)
                .setParameter("id", employeeId)
                .getResultList();
        return employeesList;
    }

    private static void printEmployeeInfo(List<Employee> employeesList) {
        for (Employee employee : employeesList) {
            System.out.printf("%s %s - %s%n",
                    employee.getFirstName(), employee.getLastName(), employee.getJobTitle());

            String allProjects = employee.getProjects()
                    .stream()
                    .map(Project::getName)
                    .sorted()
                    .collect(Collectors.joining(System.lineSeparator()));

            System.out.println(allProjects);
        }
    }
}
