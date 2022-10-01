package EXERCISES;

import java.util.Scanner;

public class P09SkiTrip {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        String room = scan.nextLine();
        String rating = scan.nextLine();
        double pricePerNight = 0;
        double totalPrice = 0;

        switch (room) {
            case "room for one person":
                pricePerNight = 18.00;
                totalPrice = (days - 1) * pricePerNight;
                break;

            case "apartment":
                pricePerNight = 25.00;
                if (days < 10) {
                    totalPrice = (days - 1) * pricePerNight * 0.7;
                } else if (days <= 15) {
                    totalPrice = (days - 1) * pricePerNight * 0.65;
                } else if (days > 15) {
                    totalPrice = (days - 1) * pricePerNight * 0.5;
                }
                break;

            case "president apartment":
                pricePerNight = 35.00;
                if (days < 10) {
                    totalPrice = (days - 1) * pricePerNight * 0.9;
                } else if (days <= 15) {
                    totalPrice = (days - 1) * pricePerNight * 0.85;
                } else if (days > 15) {
                    totalPrice = (days - 1) * pricePerNight * 0.8;
                }
                break;
        }
        if (rating.equals("positive")) {
            totalPrice = totalPrice + (totalPrice * 0.25);
        } else {
            totalPrice = totalPrice - (totalPrice * 0.1);
        }
        System.out.printf("%.02f", totalPrice);

    }
}
