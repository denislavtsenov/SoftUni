package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Locale;
import java.util.Scanner;

public class P08FuelTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String fuel = scan.nextLine();
        double litres = Double.parseDouble(scan.nextLine());


        if (fuel.equals("Diesel")) {
            if (litres >= 25) {
                System.out.printf("You have enough %s.", fuel.toLowerCase() );
            } else {
                System.out.printf("Fill your tank with %s!", fuel.toLowerCase());
            }

        } else if (fuel.equals("Gasoline")) {
            if (litres >= 25) {
                System.out.printf("You have enough %s.", fuel.toLowerCase() );
            } else {
                System.out.printf("Fill your tank with %s!", fuel.toLowerCase());
            }

        } else if (fuel.equals("Gas")) {
            if (litres >= 25) {
                System.out.printf("You have enough %s.", fuel.toLowerCase() );
            } else {
                System.out.printf("Fill your tank with %s!", fuel.toLowerCase());
            }

        } else {
            System.out.println("Invalid fuel!");
        }
    }
}
