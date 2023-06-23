import entities.Employee;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;

public class p03_ContainsEmployee {
    public static void main(String[] args) {

        EntityManager entityManager = Utils.createEntityManager();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write first and last name:");
        String fullName = scanner.nextLine();

        List<Employee> employees = entityManager.createQuery("SELECT e FROM Employee AS e " +
                        "WHERE CONCAT(e.firstName, ' ', e.lastName) = :name", Employee.class)
                .setParameter("name", fullName)
                .getResultList();

        String message = employees.size() > 0
                ? "Yes"
                : "No";

        System.out.println(message);

    }
}
