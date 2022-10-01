package Exercises;

import java.util.Scanner;

public class P06WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double recordInSec = Double.parseDouble(scan.nextLine());
        double distanceInMeters = Double.parseDouble(scan.nextLine());
        double timeInSecForMeter = Double.parseDouble(scan.nextLine());

        double swimmingTime = distanceInMeters * timeInSecForMeter;
        double extraTime = Math.floor(distanceInMeters / 15) * 12.5;

        double totalTime = swimmingTime + extraTime;
        double totalDiff = Math.abs (totalTime - recordInSec);


        if (totalTime < recordInSec) {
            System.out.printf ("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        } else {
            System.out.printf ("No, he failed! He was %.2f seconds slower.", totalDiff);
        }

    }
}
