package JavaOOP.encapsulation.exercise.classBoxDataValidation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());

        try {
            Box box = new Box(length, width, height);
            System.out.println("Surface Area - " + box.calculateSurfaceArea());
            System.out.println("Lateral Surface Area - " + box.calculateLateralSurfaceArea());
            System.out.println("Volume – " + box.calculateVolume());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
