package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P09_SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startingYield = Integer.parseInt(scan.nextLine());

        int daysCount = 0;
        int totalSpices = 0;
        while (startingYield >= 100) {
            daysCount++;
            totalSpices = totalSpices + startingYield - 26;
            startingYield -= 10;
        }
        if (totalSpices >= 26) {
            totalSpices -= 26;
        }
        System.out.println(daysCount);
        System.out.println(totalSpices);
    }
}
