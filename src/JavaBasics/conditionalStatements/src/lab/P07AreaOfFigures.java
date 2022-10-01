package Lab;

import java.util.Scanner;

public class P07AreaOfFigures {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String type = scan.nextLine();

        if (type.equals("square")) {
            double a = Double.parseDouble(scan.nextLine());
            System.out.println(a * a);
        } else if (type.equals("rectangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            System.out.println(a * b);
        } else if(type.equals("circle")) {
            double a = Double.parseDouble(scan.nextLine());
            System.out.println(Math.PI * a * a );
        } else if (type.equals("triangle")) {
            double a = Double.parseDouble(scan.nextLine());
            double b = Double.parseDouble(scan.nextLine());
            System.out.println((a * b) / 2);
        }
    }
}
