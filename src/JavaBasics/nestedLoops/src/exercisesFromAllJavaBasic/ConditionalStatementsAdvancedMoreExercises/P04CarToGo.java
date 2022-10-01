package ExercisesFromAllJavaBasic.ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class P04CarToGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double budget = Double.parseDouble(scan.nextLine());
        String season = scan.nextLine();

        String classCar = "";
        String typeCar = "";
        double sum = 0;

        switch (season) {
            case "Summer":
                typeCar = "Cabrio";
                if (budget <= 100) {
                    classCar = "Economy class";
                    sum = budget * 0.35;
                } else if (budget <= 500) {
                    classCar = "Compact class";
                    sum = budget * 0.45;
                } else if (budget > 500) {
                    classCar = "Luxury class";
                    typeCar = "Jeep";
                    sum = budget * 0.90;
                }
                break;
            case "Winter":
                typeCar = "Jeep";
                if (budget <= 100) {
                    classCar = "Economy class";
                    sum = budget * 0.65;
                } else if (budget <= 500) {
                    classCar = "Compact class";
                    sum = budget * 0.80;
                } else if (budget > 500) {
                    classCar = "Luxury class";
                    typeCar = "Jeep";
                    sum = budget * 0.90;
                }
        }
        System.out.println(classCar);
        System.out.printf("%s - %.2f", typeCar, sum);
    }
}
