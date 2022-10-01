package ExercisesFromAllJavaBasic.ConditionalStatementsAdvancedMoreExercises;

import java.util.Scanner;

public class P03Flowers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int chrysanthemumsCount = Integer.parseInt(scan.nextLine());
        int rosesCount = Integer.parseInt(scan.nextLine());
        int tulipsCount = Integer.parseInt(scan.nextLine());
        String season = scan.nextLine();
        String holiday = scan.nextLine();

        int totalCount = chrysanthemumsCount + rosesCount + tulipsCount;

        double sum = 0;
        switch (season) {
            case "Spring":
            case "Summer":
                sum = (chrysanthemumsCount * 2) + (rosesCount * 4.10) + (tulipsCount * 2.50);
                break;
            case "Autumn":
            case "Winter":
                sum = (chrysanthemumsCount * 3.75) + (rosesCount * 4.50) + (tulipsCount * 4.15);
                break;
        }
        if (holiday.equals("Y")) {
            sum = sum + (sum * 0.15);
        }
        if (tulipsCount > 7 && season.equals("Spring")) {
            sum = sum - (sum * 0.05);
        }
        if (rosesCount >= 10 && season.equals("Winter")) {
            sum = sum - (sum * 0.1);
        }
        if (totalCount > 20) {
            sum = sum - (sum * 0.2);
        }
        double sumWithArang = sum + 2;
        System.out.printf("%.2f", sumWithArang);


        }

    }

