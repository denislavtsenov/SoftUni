package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P08CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double r = Double.parseDouble(scan.nextLine());

        double S = r * r * Math.PI;
        double P = 2 * r * Math.PI;

        System.out.printf("%.2f%n", S);
        System.out.printf("%.2f", P);
    }
}
