package Lab;

import java.util.Scanner;

public class P08Graduation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String name = scan.nextLine();

        int group = 1;
        int lowGrade = 0;
        double totalGrade = 0;

        while (group <= 12) {
            if (lowGrade == 2) {
                break;
            }
            double grade = Double.parseDouble(scan.nextLine());


            if (grade < 4) {
                lowGrade++;
                continue;
            }
            group++;
            totalGrade = totalGrade + grade;
        }
        if (group >= 12) {
            System.out.printf("%s graduated. Average grade: %.2f", name, totalGrade / 12);
        } else {
            System.out.printf("%s has been excluded at %d grade",name, group);

        }

    }
}



