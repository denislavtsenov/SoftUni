package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P11_Snowballs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        double maxSnowballValue = Double.MIN_VALUE;
        int snow = 0;
        int time = 0;
        int quality = 0;
        for (int i = 0; i < n; i++) {
            int snowballSnow = Integer.parseInt(scan.nextLine());
            int snowballTime = Integer.parseInt(scan.nextLine());
            int snowballQuality = Integer.parseInt(scan.nextLine());

            double snowballValue = Math.pow(snowballSnow / snowballTime, snowballQuality);

            if (snowballValue > maxSnowballValue) {
                maxSnowballValue = snowballValue;
                snow = snowballSnow;
                time = snowballTime;
                quality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", snow, time, maxSnowballValue, quality);
    }
}
