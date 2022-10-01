package PreliminaryExam;

import java.util.Scanner;

public class P04Workout {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

//•	На първия ред – N – брой дни, в които г-жа Иванова тренира  – цяло число в интервала [1...50]
//•	На втория ред – M – километрите, които е избягала първия ден – реално число в интервала [1.00…500.00]
//•	За всеки един ден на отделен ред :
//	Процентите, с които се увеличава дневната си норма – цяло число в интервала [1…100]

        int countDays = Integer.parseInt(scan.nextLine());
        double initKm = Double.parseDouble(scan.nextLine());

        double totalKmPerDay = initKm;
        double totalRunKm = 0;
        for (int day = 1; day <= countDays; day++) {
            int percent = Integer.parseInt(scan.nextLine());

            totalKmPerDay = totalKmPerDay + (totalKmPerDay * (percent * 1.0 / 100));
            totalRunKm = totalRunKm + totalKmPerDay;
        }
        double totalKm = totalRunKm + initKm;

        double diff = Math.abs(1000 - totalKm);

        if (totalKm >= 1000) {
            System.out.printf("You've done a great job running %.0f more kilometers!", Math.ceil(diff));
        } else {
            System.out.printf("Sorry Mrs. Ivanova, you need to run %.0f more kilometers", Math.ceil(diff));
        }

    }
}
