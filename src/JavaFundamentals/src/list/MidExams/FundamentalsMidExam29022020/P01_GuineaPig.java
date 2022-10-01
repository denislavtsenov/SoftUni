package List.MidExams.FundamentalsMidExam29022020;

import java.util.Scanner;

public class P01_GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double qtyFoodKg = Double.parseDouble(scanner.nextLine());
        double qtyHayKg = Double.parseDouble(scanner.nextLine());
        double qtyCoverKg = Double.parseDouble(scanner.nextLine());
        double pigWeightKg = Double.parseDouble(scanner.nextLine());

        double qtyFoodGr = qtyFoodKg * 1000;
        double qtyHayGr = qtyHayKg * 1000;
        double qtyCoverGr = qtyCoverKg * 1000;
        double pigWeightGr = pigWeightKg * 1000;


        double eatsFoodGr = 0;
        double usedHayGr = 0;
        double usedCoverGr = 0;
        double foodsLeft = qtyFoodGr;
        double hayLeft = qtyHayGr;
        double coverLeft = qtyCoverGr;
        for (int i = 1; i <= 30 ; i++) {
            eatsFoodGr = 300;
            foodsLeft = foodsLeft - eatsFoodGr;

            if (i % 2 == 0) {
              usedHayGr = foodsLeft * 0.05;
                hayLeft = hayLeft - usedHayGr;
            }

            if (i % 3 == 0) {
                usedCoverGr = pigWeightGr / 3;
                coverLeft = coverLeft - usedCoverGr;
            }



            if (foodsLeft <= 0 || hayLeft <= 0 || coverLeft <= 0) {
                System.out.println("Merry must go to the pet store!");
                break;
            }
        }
        double foodsLeftKg = foodsLeft / 1000;
        double hayLeftKg = hayLeft / 1000;
        double coverLeftKg = coverLeft / 1000;

        if (foodsLeft > 0 && hayLeft > 0 &&  coverLeft > 0) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f.", foodsLeftKg, hayLeftKg, coverLeftKg);
        }
    }
}
