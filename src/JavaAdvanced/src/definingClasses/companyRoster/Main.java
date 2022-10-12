package JavaAdvanced.src.definingClasses.companyRoster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Department> departments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] inputInfo = scanner.nextLine().split("\\s+");
            String name = inputInfo[0];
            double salary = Double.parseDouble(inputInfo[1]);
            String position = inputInfo[2];
            String employeeDepartment = inputInfo[3];

            Employee employee = null;

            switch (inputInfo.length) {
                case 4:
                    employee = new Employee(name, salary, position, employeeDepartment);
                    break;
                case 5:
                    if (inputInfo[4].contains("@")) {
                        String email = inputInfo[4];
                        employee = new Employee(name, salary, position, employeeDepartment, email);
                    } else {
                        int age = Integer.parseInt(inputInfo[4]);
                        employee = new Employee(name, salary, position, employeeDepartment, age);
                    }

                    break;
                case 6:
                    String email = inputInfo[4];
                    int age = Integer.parseInt(inputInfo[5]);
                    employee = new Employee(name, salary, position, employeeDepartment, email, age);
                    break;
            }

            boolean isDepartmentExists = departments.stream().anyMatch(department -> department.getName().equals(employeeDepartment));

            if (!isDepartmentExists) {
                Department department = new Department(employeeDepartment);
                departments.add(department);
            }

            Department currentDepartment = departments.stream()
                    .filter(dep -> dep.getName().equals(employeeDepartment)).findFirst().get();

            currentDepartment.getEmployees().add(employee);
        }

        Department highestPaidDepartment = departments
                .stream()
                .max((first, second) -> Double.compare(first.calculateAverageSalary(), second.calculateAverageSalary()))
                .get();

        System.out.printf("Highest Average Salary: %s%n", highestPaidDepartment.getName());

highestPaidDepartment.getEmployees()
        .stream()
        .sorted((first, second) -> Double.compare(second.getSalary(), first.getSalary()))
        .forEach(System.out::println);
    }
}
