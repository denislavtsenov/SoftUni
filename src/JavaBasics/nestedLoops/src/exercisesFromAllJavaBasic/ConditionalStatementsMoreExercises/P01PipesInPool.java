package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P01PipesInPool {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int v = Integer.parseInt(scan.nextLine());
        int p1 = Integer.parseInt(scan.nextLine());
        int p2 = Integer.parseInt(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double totalLitresP1 = p1 * h;
        double totalLitresP2 = p2 * h;
        double totalLitres = totalLitresP1 + totalLitresP2;

        double totalPercent = totalLitres / v * 100;
        double p1InPercent = totalLitresP1 / totalLitres * 100;
        double p2InPercent = totalLitresP2 / totalLitres * 100;

        double diff = Math.abs(v - totalLitres);

        if (totalLitres > v) {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", h, diff );
        } else {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", totalPercent, p1InPercent, p2InPercent );
        }

    }
}
