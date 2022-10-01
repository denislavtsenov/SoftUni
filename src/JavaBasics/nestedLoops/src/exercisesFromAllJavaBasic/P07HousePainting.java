package ExercisesFromAllJavaBasic;

import java.util.Scanner;

public class P07HousePainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double x = Double.parseDouble(scan.nextLine());
        double y = Double.parseDouble(scan.nextLine());
        double h = Double.parseDouble(scan.nextLine());

        double side = (x * y) - 2.25;
        double totalSide = 2 * side;

        double backSide = x * x;
        double frontSide = (x * x) - (1.2 * 2);
        double backAndFront = backSide + frontSide;
        double totalArea = totalSide + backAndFront;
        double green = totalArea / 3.4;

        double rectRoof = 2 * x * y;
        double triangleRoof = 2 * ((x * h) / 2);
        double totalRoof = rectRoof + triangleRoof;
        double red = totalRoof / 4.3;

        System.out.printf("%.2f%n", green);
        System.out.printf("%.2f%n", red);
    }
}
