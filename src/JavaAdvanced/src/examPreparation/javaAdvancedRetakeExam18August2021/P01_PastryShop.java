package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam18August2021;

import java.util.*;

public class P01_PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();

        int[] inputLiquids = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < inputLiquids.length; i++) {
            liquidsQueue.offer(inputLiquids[i]);
        }

        int[] inputIngredients = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < inputIngredients.length; i++) {
            ingredientStack.push(inputIngredients[i]);
        }

        Map<Integer, String> foodNeeded = new LinkedHashMap<>();
        foodNeeded.put(25, "Biscuit");
        foodNeeded.put(50, "Cake");
        foodNeeded.put(100, "Pie");
        foodNeeded.put(75, "Pastry");

        Map<String, Integer> cookedFood = new LinkedHashMap<>();
        cookedFood.put("Biscuit", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pie", 0);
        cookedFood.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int firstValue = liquidsQueue.peek();
            int secondValue = ingredientStack.peek();
            int sum = firstValue + secondValue;

            if (foodNeeded.containsKey(sum)) {
                String currentFood = foodNeeded.get(sum);

                int currentValue = cookedFood.get(currentFood);
                cookedFood.put(currentFood, currentValue + 1);

                liquidsQueue.poll();
                ingredientStack.pop();
            } else {
                liquidsQueue.poll();
                ingredientStack.pop();
                int newValue = secondValue + 3;
                ingredientStack.push(newValue);
            }
        }
       boolean isSucceeded = true;

        for (Map.Entry<String, Integer> entry : cookedFood.entrySet()) {
            if (entry.getValue() < 1) {
                isSucceeded = false;
            }
        }

        if (isSucceeded) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        if (liquidsQueue.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            List<String> leftLiquids = new ArrayList<>();
            while (!liquidsQueue.isEmpty()) {
                leftLiquids.add(String.valueOf(liquidsQueue.poll()));
            }

            System.out.print("Liquids left: ");
            System.out.print(String.join(", ", leftLiquids));
            System.out.println();
        }

        if (ingredientStack.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            List<String> leftIngredients = new ArrayList<>();
            while (!ingredientStack.isEmpty()) {
                leftIngredients.add(String.valueOf(ingredientStack.pop()));
            }

            System.out.print("Ingredients left: ");
            System.out.print(String.join(", ", leftIngredients));
            System.out.println();
        }


        for (Map.Entry<String, Integer> entry : cookedFood.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }


    }
}


