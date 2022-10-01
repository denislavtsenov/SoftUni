package Exercise;

import java.util.Scanner;

public class P02ExamPreparation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lowGrade = Integer.parseInt(scan.nextLine());


        int countLowGrade = 0;
        double sumGrade = 0;
        int countGrade = 0;
        int grade = 0;
        boolean isFailed = true;
        String lastProblem = "";
        String command = "";


        while (lowGrade > countLowGrade) {
            command = scan.nextLine();
            if (command.equals("Enough")) {
                isFailed = false;
                break;
            }
            grade = Integer.parseInt(scan.nextLine());
            sumGrade = sumGrade + grade;
            if (grade <= 4) {
                countLowGrade++;
            }


            countGrade++;
            lastProblem = command;


        }

        if (command.equals("Enough")) {

            System.out.printf("Average score: %.2f%n", sumGrade / countGrade);
            System.out.printf("Number of problems: %d%n", countGrade);
            System.out.printf("Last problem: %s", lastProblem);
        } else {
            System.out.printf("You need a break, %d poor grades.", countLowGrade);
        }
    }
}
