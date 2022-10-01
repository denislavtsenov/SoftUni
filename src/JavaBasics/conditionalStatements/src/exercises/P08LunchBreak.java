package Exercises;

import java.util.Scanner;

public class P08LunchBreak {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String movie = scan.nextLine();
        int ep = Integer.parseInt(scan.nextLine());
        int lunch = Integer.parseInt(scan.nextLine());

        double lunchTime = lunch * 0.125;
        double breakTime = lunch * 0.25;
        double restTime = lunch - lunchTime - breakTime;
        double diff = Math.abs(restTime - ep);
        diff = Math.ceil(diff);

        if (restTime >= ep) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", movie, diff);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", movie, diff);
        }
    }
}
