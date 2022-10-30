package JavaAdvanced.src.examPreparation.javaAdvancedExam22October2022;

import java.util.*;

public class P01_EnergyDrinks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> caffeinеStack = new ArrayDeque<>();
        ArrayDeque<Integer> energyDrinksQueue = new ArrayDeque<>();

        int[] caffeineInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < caffeineInput.length; i++) {
            caffeinеStack.push(caffeineInput[i]);
        }

        int[] energyDrinksInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < energyDrinksInput.length; i++) {
            energyDrinksQueue.offer(energyDrinksInput[i]);
        }

        int maxCaffeine = 300;
        int initCaffeine = 0;

        while (!caffeinеStack.isEmpty() && !energyDrinksQueue.isEmpty()) {
            int caffeineValue = caffeinеStack.peek();
            int drinkValue = energyDrinksQueue.peek();
            int currentCaffeine = caffeineValue * drinkValue;

            if (currentCaffeine <= maxCaffeine) {
                caffeinеStack.pop();
                energyDrinksQueue.poll();
                initCaffeine += currentCaffeine;
                maxCaffeine -= currentCaffeine;
            } else {
                caffeinеStack.pop();
                energyDrinksQueue.poll();
                energyDrinksQueue.offer(drinkValue);

                maxCaffeine += 30;
                if (maxCaffeine > 300) {
                    maxCaffeine = 300;
                }

                initCaffeine -= 30;
                if (initCaffeine < 0) {
                    initCaffeine = 0;
                }
            }
        }

        if (energyDrinksQueue.isEmpty()) {
            System.out.println("At least Stamat wasn't exceeding the maximum caffeine.");
        } else {
            List<String> leftDrinks = new ArrayList<>();

            while (!energyDrinksQueue.isEmpty()) {
                leftDrinks.add(String.valueOf(energyDrinksQueue.poll()));
            }
            System.out.print("Drinks left: ");
            System.out.print(String.join(", ", leftDrinks));
            System.out.println();
        }

        System.out.printf("Stamat is going to sleep with %d mg caffeine.", initCaffeine);
    }
}
