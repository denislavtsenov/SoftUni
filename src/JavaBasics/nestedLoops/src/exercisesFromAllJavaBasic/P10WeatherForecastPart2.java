package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P10WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double input = Double.parseDouble(scan.nextLine());

        if (input >= 26.00 && input <= 35.00) {
            System.out.println("Hot");
        } else if (input >= 20.1 && input <= 25.9) {
            System.out.println("Warm");
        } else if (input >= 15.00 && input <= 20.00) {
            System.out.println("Mild");
        } else if (input >= 12.00 && input <= 14.9) {
            System.out.println("Cool");
        } else if (input >= 5.00 && input <= 11.9) {
            System.out.println("Cold");
        } else {
            System.out.println("unknown");
        }
    }
}
