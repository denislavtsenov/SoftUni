package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P07_WaterOverflow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int waterTankCapacity = 255;
        int usedQuantities = 0;
        for (int i = 1; i <= n; i++) {
            int quantitiesOfWater = Integer.parseInt(scan.nextLine());
            if (quantitiesOfWater <= waterTankCapacity) {
                usedQuantities += quantitiesOfWater;
                waterTankCapacity -= quantitiesOfWater;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        System.out.println(usedQuantities);
    }
}
