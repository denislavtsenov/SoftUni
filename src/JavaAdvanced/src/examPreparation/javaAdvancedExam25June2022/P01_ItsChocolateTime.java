package JavaAdvanced.src.examPreparation.javaAdvancedExam25June2022;

import java.util.*;

public class P01_ItsChocolateTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayDeque<Double> milkValuesQueue = new ArrayDeque<>();
        ArrayDeque<Double> cacaoPowderStack = new ArrayDeque<>();

        double[] milkInputValues = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        double[] cacaoPowder = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();


        for (int i = 0; i < milkInputValues.length; i++) {
            double current = milkInputValues[i];
            milkValuesQueue.offer(current);
        }

        for (int i = 0; i < cacaoPowder.length; i++) {
            double current = cacaoPowder[i];
            cacaoPowderStack.push(current);
        }

        Map<Double, String> chocolateTypes = new HashMap<>();
        chocolateTypes.put(30.0, "Milk Chocolate");
        chocolateTypes.put(50.0, "Dark Chocolate");
        chocolateTypes.put(100.0, "Baking Chocolate");

        Map<String, Integer> preparedChocolates = new TreeMap<>();

        while (!milkValuesQueue.isEmpty() && !cacaoPowderStack.isEmpty()) {
            double firstValue = milkValuesQueue.peek();
            double secondValue = cacaoPowderStack.peek();
            double cacaoPercentage = secondValue / (firstValue + secondValue) * 100;

            if (chocolateTypes.containsKey(cacaoPercentage)) {
                String current = chocolateTypes.get(cacaoPercentage);
                if (!preparedChocolates.containsKey(current)) {
                    preparedChocolates.put(current, 1);
                } else {
                    int currentValue = preparedChocolates.get(current);
                    preparedChocolates.put(current, currentValue + 1);
                }
                milkValuesQueue.poll();
                cacaoPowderStack.pop();

            } else {
                cacaoPowderStack.pop();
                double currentMilkValue = milkValuesQueue.poll();
                double increasedValue = currentMilkValue + 10;
                milkValuesQueue.offer(increasedValue);
            }
        }


        if (preparedChocolates.size() == chocolateTypes.size()) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : preparedChocolates.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.printf("# %s --> %d%n", entry.getKey(), entry.getValue());
            }
        }


    }
}
