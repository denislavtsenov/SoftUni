package setsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("END")) {
            String command = inputLine.split(", ")[0];
            String car = inputLine.split(", ")[1];

            if (command.equals("IN")) {
                parkingLot.add(car);
            } else if (command.equals("OUT")) {
                parkingLot.remove(car);
            }
            inputLine = scanner.nextLine();
        }
        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.println(String.join(System.lineSeparator(), parkingLot));
        }
    }
}
