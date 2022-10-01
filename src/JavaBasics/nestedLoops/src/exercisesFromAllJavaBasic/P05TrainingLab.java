package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P05TrainingLab {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double h = Double.parseDouble(scan.nextLine());
        double w = Double.parseDouble(scan.nextLine());

        double hInCm = (w * 100) - 100;
        double wInCm = h * 100;



        double totalInRowW = Math.floor(hInCm / 70);
        double totalInRowH = Math.floor(wInCm / 120);

        double total = (totalInRowH * totalInRowW) - 3;
        System.out.printf("%.0f", total);

    }
}
