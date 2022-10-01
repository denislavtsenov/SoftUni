package EXERCISES;

import java.util.Scanner;

public class P07HotelRoom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String month = scan.nextLine();
        int countNight = Integer.parseInt(scan.nextLine());
        double priceNightStudio = 0;
        double priceNightApartment = 0;

        switch (month) {
            case "May":
            case "October":
                priceNightStudio = 50;
                priceNightApartment = 65;
                if (countNight > 7 && countNight <= 14) {
                    priceNightApartment = priceNightApartment * countNight;
                    priceNightStudio = priceNightStudio * countNight * 0.95;
                } else if (countNight > 14) {
                    priceNightApartment = priceNightApartment * countNight * 0.9;
                    priceNightStudio = priceNightStudio * countNight * 0.7;
                } else {
                    priceNightApartment = priceNightApartment * countNight;
                    priceNightStudio = priceNightStudio * countNight;
                }
                break;
            case "June":
            case "September":
                priceNightStudio = 75.20;
                priceNightApartment = 68.70;
                if (countNight > 14) {
                    priceNightApartment = priceNightApartment * countNight * 0.9;
                    priceNightStudio = priceNightStudio * countNight * 0.8;
                } else {
                    priceNightApartment = priceNightApartment * countNight;
                    priceNightStudio = priceNightStudio * countNight;
                }
                break;
            case "July":
            case "August":
                priceNightStudio = 76;
                priceNightApartment = 77;
                priceNightStudio = priceNightStudio * countNight;
                if(countNight > 14) {
                    priceNightApartment = priceNightApartment * countNight * 0.9;
                } else {
                    priceNightApartment = priceNightApartment * countNight;
                }
                break;
        }
        System.out.printf("Apartment: %.2f lv. %n", priceNightApartment);
        System.out.printf("Studio: %.2f lv. %n", priceNightStudio);
    }
}
