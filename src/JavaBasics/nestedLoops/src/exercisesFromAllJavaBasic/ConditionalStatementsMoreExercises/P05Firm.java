package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P05Firm {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int neededHours = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());
        int workers = Integer.parseInt(scan.nextLine());

        double totalWorkHours = days * 0.9 * 8;
        double overtimeWork = workers * 2 * days;
        double totalHours = totalWorkHours + overtimeWork;

        double diff = Math.abs(neededHours - totalHours);


        if (neededHours <= totalHours) {
            System.out.printf("Yes!%.0f hours left.", Math.floor(diff));
        } else {
            System.out.printf("Not enough time!%.0f hours needed.", Math.ceil(diff));
        }
    }
}
