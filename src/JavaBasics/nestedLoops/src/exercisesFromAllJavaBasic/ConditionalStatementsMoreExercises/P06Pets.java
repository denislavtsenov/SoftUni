package ExercisesFromAllJavaBasic.ConditionalStatementsMoreExercises;

import java.util.Scanner;

public class P06Pets {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int days = Integer.parseInt(scan.nextLine());
        int kgFood = Integer.parseInt(scan.nextLine());
        double foodForDog = Double.parseDouble(scan.nextLine());
        double foodForCat = Double.parseDouble(scan.nextLine());
        double foodForTurtle = Double.parseDouble(scan.nextLine());

        double neededDogFood = days * foodForDog;
        double neededCatFood = days * foodForCat;
        double neededTurtleFood = (days * foodForTurtle) / 1000;

        double totalNeededFood = neededDogFood + neededCatFood + neededTurtleFood;
        double diff = Math.abs(kgFood - totalNeededFood);

        if (totalNeededFood <= kgFood) {
            System.out.printf("%.0f kilos of food left.", Math.floor(diff) );
        } else {
            System.out.printf("%.0f more kilos of food are needed.", Math.ceil(diff));

        }
    }
}
