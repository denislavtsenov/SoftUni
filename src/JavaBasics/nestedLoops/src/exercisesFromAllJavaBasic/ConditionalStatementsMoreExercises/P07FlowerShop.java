package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P07FlowerShop {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countMagnolias = Integer.parseInt(scan.nextLine());
        int countHyacinth = Integer.parseInt(scan.nextLine());
        int countRoses = Integer.parseInt(scan.nextLine());
        int countCactus = Integer.parseInt(scan.nextLine());
        double priceGift = Double.parseDouble(scan.nextLine());



        double totalSum = (countMagnolias * 3.25) + (countHyacinth * 4) + (countRoses * 3.50) + (countCactus * 8);
        double totalSumWithTax = totalSum * 0.95;
        double diff = Math.abs(priceGift - totalSumWithTax);

        if (totalSumWithTax >= priceGift) {
            System.out.printf("She is left with %.0f leva.", Math.floor(diff));
        } else {
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(diff));

        }
    }
}
