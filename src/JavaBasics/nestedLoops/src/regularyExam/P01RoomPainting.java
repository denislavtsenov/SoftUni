package RegularyExam;

import java.util.Scanner;

public class P01RoomPainting {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countPaint = Integer.parseInt(scan.nextLine());
        int countWallpapers = Integer.parseInt(scan.nextLine());
        double pricePerGlove = Double.parseDouble(scan.nextLine());
        double pricePerBrush = Double.parseDouble(scan.nextLine());

        double countGloves = Math.ceil(countWallpapers * 0.35);
        double countBrush = Math.floor(countPaint * 0.48);

        double totalPricePaint = countPaint * 21.50;
        double totalPriceWallpapers = countWallpapers * 5.20;
        double totalPriceGloves = pricePerGlove * countGloves;
        double totalPriceBrush = pricePerBrush * countBrush;

        double totalSum = totalPricePaint + totalPriceWallpapers + totalPriceGloves + totalPriceBrush;

        double deliveryPrice = totalSum * (1 * 1.0 / 15);

        System.out.printf("This delivery will cost %.2f lv.", deliveryPrice);


    }
}
