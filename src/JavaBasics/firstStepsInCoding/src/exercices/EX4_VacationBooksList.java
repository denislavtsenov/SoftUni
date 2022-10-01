package Excerices;

import java.util.Scanner;

public class EX4_VacationBooksList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pages = Integer.parseInt(scan.nextLine());
        int pagesPerHour = Integer.parseInt(scan.nextLine());
        int days = Integer.parseInt(scan.nextLine());

        int totalTime = pages / pagesPerHour;
        int totalPerDay = totalTime / days;

        System.out.println(totalPerDay);

    }
}
