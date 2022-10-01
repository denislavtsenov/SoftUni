package RegularyExam;

import java.util.Scanner;

public class P02Spaceship {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double width = Double.parseDouble(scan.nextLine());
        double height = Double.parseDouble(scan.nextLine());
        double high = Double.parseDouble(scan.nextLine());
        double highAstronaut = Double.parseDouble(scan.nextLine());

        double rocketVolume = width * height * high;
        double roomVolume = 2 * 2 * (highAstronaut + 0.40);

        double totalAstronautSpace = Math.floor(rocketVolume / roomVolume);

        if (totalAstronautSpace >= 3 && totalAstronautSpace <= 10) {
            System.out.printf("The spacecraft holds %.0f astronauts.", totalAstronautSpace);
        } else if (totalAstronautSpace < 3) {
            System.out.println("The spacecraft is too small.");
        } else {
            System.out.println("The spacecraft is too big.");
        }
    }
}
