package Exercises;

import java.util.Scanner;

public class P01SumSeconds {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstTime = Integer.parseInt(scan.nextLine());
        int secondTime = Integer.parseInt(scan.nextLine());
        int thirdTime = Integer.parseInt(scan.nextLine());

        int totalTime = firstTime + secondTime + thirdTime;
        int totalMin = totalTime / 60;
        int totalSec = totalTime % 60;

        if (totalSec < 10) {

            System.out.printf("%d:%02d", totalMin, totalSec);
        } else
            System.out.printf("%d:%d", totalMin, totalSec);



    }
}
