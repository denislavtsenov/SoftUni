package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P02SleepyTomCat {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int restingDays = Integer.parseInt(scan.nextLine());

        int workingDays = 365 - restingDays;
        int realPlayTime = (workingDays * 63) + (restingDays * 127);
        int diff = 30000 - realPlayTime;
        int diffInHours = Math.abs(diff / 60);
        int diffInMinutes = Math.abs(diff % 60);

        if (30000 >= realPlayTime) {
            System.out.printf("Tom sleeps well%n");
            System.out.printf("%d hours and %d minutes less for play", diffInHours, diffInMinutes);
        } else {
            System.out.printf("Tom will run away%n");
            System.out.printf("%d hours and %d minutes more for play", diffInHours, diffInMinutes );

        }

    }
}
