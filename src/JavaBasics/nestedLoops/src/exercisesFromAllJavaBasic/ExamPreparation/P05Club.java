package ExercisesFromAllJavaBasic.ExamPreparation;

import java.util.Scanner;

public class P05Club {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double neededProfit = Double.parseDouble(scan.nextLine());

        double sum = 0;

        String input = scan.nextLine();
        while (!input.equals("Party!")) {
            String cocktailName = (input);
            int countCocktail = Integer.parseInt(scan.nextLine());

            double cocktailPrice = cocktailName.length();
            double totalCocktailPrice = countCocktail * cocktailPrice;

            if (totalCocktailPrice % 2 != 0) {
                totalCocktailPrice = totalCocktailPrice * 0.75;
            }
            sum = sum + totalCocktailPrice;



            if (sum >= neededProfit) {
                System.out.println("Target acquired.");
                break;
            }

            input = scan.nextLine();
        }
        double diff = Math.abs(neededProfit - sum);

        if (input.equals("Party!")) {
            System.out.printf("We need %.2f leva more.%n", diff);
        }
        System.out.printf("Club income - %.2f leva.", sum);

    }
}
