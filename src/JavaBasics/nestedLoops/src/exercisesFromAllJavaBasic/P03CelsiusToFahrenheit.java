package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P03CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double celsius = Double.parseDouble(scan.nextLine());

        double farenheit =celsius * 1.8000 + 32.00;

        System.out.printf("%.2f", farenheit);
    }
}
