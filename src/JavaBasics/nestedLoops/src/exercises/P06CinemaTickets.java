package EXERCISE;

import java.util.Scanner;

public class P06CinemaTickets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String command = scan.nextLine();
        int totalTickets = 0;
        int totalStudent = 0;
        int totalStandart = 0;
        int totalKid = 0;

        while (!command.equals("Finish")) {
            int freeSpaces = Integer.parseInt(scan.nextLine());

            int ticketsForMovie = 0;
            int student = 0;
            int standard = 0;
            int kid = 0;

            String typeTickets = scan.nextLine();
            while (!typeTickets.equals("End")) {
                totalTickets++;
                ticketsForMovie++;

                switch (typeTickets) {
                    case "student":
                        student++;
                        totalStudent++;
                        break;
                    case "standard":
                        standard++;
                        totalStandart++;
                        break;
                    case "kid":
                        kid++;
                        totalKid++;
                        break;
                }
                if (ticketsForMovie >= freeSpaces) {
                    break;
                }
                typeTickets = scan.nextLine();
            }
            System.out.printf("%s - %.2f%% full.%n", command, ticketsForMovie * 1.0 / freeSpaces * 100);
            command = scan.nextLine();
        }

        System.out.printf("Total tickets: %d%n", totalTickets);
        System.out.printf("%.2f%% student tickets.%n", totalStudent * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% standard tickets.%n", totalStandart * 1.0 / totalTickets * 100);
        System.out.printf("%.2f%% kids tickets.%n", totalKid * 1.0 / totalTickets * 100);

    }
}
