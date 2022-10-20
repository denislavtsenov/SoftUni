package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam13April2022;

import java.util.*;

public class P01_Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> steelQueue = new ArrayDeque<>();
        ArrayDeque<Integer> carbonStack = new ArrayDeque<>();

        int[] steel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < steel.length; i++) {
            steelQueue.offer(steel[i]);
        }

        int[] carbon = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < carbon.length; i++) {
            carbonStack.push(carbon[i]);
        }

        Map<String, Integer> craftedSwords = new TreeMap<>();

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int firstElement = steelQueue.peek();
            int secondElement = carbonStack.peek();
            int sum = firstElement + secondElement;

            if (sum == 70) {
                if (!craftedSwords.containsKey("Gladius")) {
                    craftedSwords.put("Gladius", 1);
                } else {
                    int currentValue = craftedSwords.get("Gladius");
                    craftedSwords.put("Gladius", currentValue + 1);
                }
                steelQueue.poll();
                carbonStack.pop();
            } else if (sum == 80) {

                if (!craftedSwords.containsKey("Shamshir")) {
                    craftedSwords.put("Shamshir", 1);
                } else {
                    int currentValue = craftedSwords.get("Shamshir");
                    craftedSwords.put("Shamshir", currentValue + 1);
                }
                steelQueue.poll();
                carbonStack.pop();

            } else if (sum == 90) {
                if (!craftedSwords.containsKey("Katana")) {
                    craftedSwords.put("Katana", 1);
                } else {
                    int currentValue = craftedSwords.get("Katana");
                    craftedSwords.put("Katana", currentValue + 1);
                }
                steelQueue.poll();
                carbonStack.pop();

            } else if (sum == 110) {
                if (!craftedSwords.containsKey("Sabre")) {
                    craftedSwords.put("Sabre", 1);
                } else {
                    int currentValue = craftedSwords.get("Sabre");
                    craftedSwords.put("Sabre", currentValue + 1);
                }

                steelQueue.poll();
                carbonStack.pop();
            } else {
                steelQueue.poll();
                int current = carbonStack.pop();
                int newValue = current + 5;
                carbonStack.push(newValue);

            }
        }

        if (craftedSwords.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            int totalCraftedSwords = 0;
            for (Map.Entry<String, Integer> entry : craftedSwords.entrySet()) {
                totalCraftedSwords += entry.getValue();
            }

            System.out.printf("You have forged %d swords.%n", totalCraftedSwords);
        }

        if (steelQueue.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            List<String> steelLeft = new ArrayList<>();
            while (!steelQueue.isEmpty()){
                int current = steelQueue.poll();
                steelLeft.add(String.valueOf(current));
            }
            System.out.print("Steel left: ");
            System.out.print(String.join(steelLeft.toString()));
            System.out.println();
        }

        if (carbonStack.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            List<String> carbonLeft = new ArrayList<>();
            while (!carbonStack.isEmpty()){
                int current = carbonStack.pop();
                carbonLeft.add(String.valueOf(current));
            }
            System.out.print("Carbon left: ");
            System.out.print(String.join(", ", carbonLeft));
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : craftedSwords.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }

    }
}

