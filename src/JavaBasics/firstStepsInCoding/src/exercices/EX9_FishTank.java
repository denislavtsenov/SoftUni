package Excerices;

import java.util.Scanner;

public class EX9_FishTank {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lenght = Integer.parseInt(scan.nextLine());
        int widht = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        double percent = Double.parseDouble(scan.nextLine());

        double aquariumVolume = lenght * widht * height;
        double volumeInLitres = aquariumVolume / 1000;
        double busy = percent / 100;
        double needLitres = volumeInLitres * (1 - busy);

        System.out.println(needLitres);

    }
}
