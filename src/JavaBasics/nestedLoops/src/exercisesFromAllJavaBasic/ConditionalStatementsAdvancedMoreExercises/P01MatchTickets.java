package ExercisesFromAllJavaBasic.ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class P01MatchTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String category = scan.nextLine();
        int countPeople = Integer.parseInt(scan.nextLine());

        double pricePerTicket = 0;
        double priceForTransport = 0;

        if (countPeople >= 1 && countPeople <= 4) {
            priceForTransport = budget * 0.75;
        } else if (countPeople <= 9) {
            priceForTransport = budget * 0.6;
        } else if (countPeople <= 24) {
            pricePerTicket = budget * 0.5;
        } else if (countPeople <= 49) {
            priceForTransport = budget * 0.4;
        } else if (countPeople >= 50) {
            priceForTransport = budget * 0.25;
        }

        if (category.equals("Normal")) {
            pricePerTicket = 249.99;

        } else if (category.equals("VIP")) {
            pricePerTicket = 499.99;

        }
        double totalTicketSum = countPeople * pricePerTicket;
        double totalLeftMoney = budget - priceForTransport;


        double diff = Math.abs(totalLeftMoney - totalTicketSum);

        if (totalLeftMoney >= totalTicketSum) {
            System.out.printf("Yes! You have %.2f leva left.", diff);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }
    }
}

