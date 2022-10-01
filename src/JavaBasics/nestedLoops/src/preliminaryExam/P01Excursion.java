package PreliminaryExam;

import java.util.Scanner;

public class P01Excursion {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countPeople = Integer.parseInt(scan.nextLine());
        int countNights = Integer.parseInt(scan.nextLine());
        int cards = Integer.parseInt(scan.nextLine());
        int tickets = Integer.parseInt(scan.nextLine());

        int sumNights = countNights * 20;
        double sumCards = cards * 1.60;
        double sumTickets = tickets * 6;

        double sumPerPerson = sumNights + sumCards + sumTickets;

        double totalSum = sumPerPerson * countPeople;

        double sumWithUnexpectedCosts = totalSum * 1.25;

        System.out.printf("%.2f", sumWithUnexpectedCosts);

    }
}
