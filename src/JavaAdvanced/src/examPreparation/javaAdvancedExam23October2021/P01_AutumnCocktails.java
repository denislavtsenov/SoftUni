package JavaAdvanced.src.examPreparation.javaAdvancedExam23October2021;

import java.util.*;

public class P01_AutumnCocktails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bucketOfIngredientsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> freshnessLevelStack = new ArrayDeque<>();

        int[] bucketInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < bucketInput.length; i++) {
            bucketOfIngredientsQueue.offer(bucketInput[i]);
        }

        int[] freshnessInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < freshnessInput.length; i++) {
            freshnessLevelStack.push(freshnessInput[i]);
        }

        Map<Integer, String> cocktailsInput = new HashMap<>();
        cocktailsInput.put(150, "Pear Sour");
        cocktailsInput.put(250, "The Harvest");
        cocktailsInput.put(300, "Apple Hinny");
        cocktailsInput.put(400, "High Fashion");

        Map<String, Integer> mixedCocktails = new TreeMap<>();

        while (!bucketOfIngredientsQueue.isEmpty() && !freshnessLevelStack.isEmpty()) {
            int firstValue = bucketOfIngredientsQueue.peek();
            int secondValue = freshnessLevelStack.peek();
            int totalValue = firstValue * secondValue;

            if (firstValue == 0) {
                bucketOfIngredientsQueue.poll();
                continue;
            }

            if (cocktailsInput.containsKey(totalValue)) {
                String currentCocktail = cocktailsInput.get(totalValue);
                if (!mixedCocktails.containsKey(currentCocktail)) {
                    mixedCocktails.put(currentCocktail, 1);
                } else {
                    int currentValue = mixedCocktails.get(currentCocktail);
                    mixedCocktails.put(currentCocktail, currentValue + 1);
                }

                bucketOfIngredientsQueue.poll();
                freshnessLevelStack.pop();

            } else {
                freshnessLevelStack.pop();
                int newValue = firstValue + 5;
                bucketOfIngredientsQueue.poll();
                bucketOfIngredientsQueue.offer(newValue);
            }
        }

        if (mixedCocktails.size() == 4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!bucketOfIngredientsQueue.isEmpty()) {
            int sum = 0;
            while (!bucketOfIngredientsQueue.isEmpty()){
                sum += bucketOfIngredientsQueue.poll();
            }
            System.out.printf("Ingredients left: %d%n", sum);
        }

        for (Map.Entry<String, Integer> entry : mixedCocktails.entrySet()) {
            System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
        }

    }
}
