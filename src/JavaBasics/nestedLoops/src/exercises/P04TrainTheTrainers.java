package EXERCISE;

import java.util.Scanner;

public class P04TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());

        double totalGrade = 0;
        double countGrade = 0;
        String name = scan.nextLine();
        while (!name.equals("Finish")) {

            double sumGrade = 0;
            for (int i = 1; i <= n; i++) {
                countGrade++;
                double grade = Double.parseDouble(scan.nextLine());
                totalGrade = totalGrade + grade;
                sumGrade = sumGrade + grade;

            }
            System.out.printf("%s - %.2f.%n", name, sumGrade / n);

            name = scan.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalGrade / countGrade);
    }
}

