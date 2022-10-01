package Exercises;

import java.util.Scanner;

public class P03TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hour = Integer.parseInt(scan.nextLine());
        int min = Integer.parseInt(scan.nextLine());

        int initHour = hour * 60;
        int totalTime = initHour + min + 15;

        int totalHour = totalTime / 60;
        int totalMin = totalTime % 60;

        if (totalHour > 23) {
            totalHour = 0;
        }
        if (totalMin > 59) {
            totalMin = hour + 1;
        }

        System.out.printf("%d:%02d", totalHour, totalMin);
    }
}
