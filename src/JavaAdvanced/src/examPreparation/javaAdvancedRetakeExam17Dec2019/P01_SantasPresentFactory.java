package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam17Dec2019;

import java.util.*;

public class P01_SantasPresentFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numOfMaterials = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> materialsStack = new ArrayDeque<>();
        for (int i = 0; i < numOfMaterials.length; i++) {
            materialsStack.push(numOfMaterials[i]);
        }

        int[] magicLevel = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> magicQueue = new ArrayDeque<>();
        for (int i = 0; i < magicLevel.length; i++) {
            magicQueue.offer(magicLevel[i]);
        }

        Map<Integer, String> presents = new HashMap<>();
        presents.put(150, "Doll");
        presents.put(250, "Wooden train");
        presents.put(300, "Teddy bear");
        presents.put(400, "Bicycle");

        Map<String, Integer> craftedPresents = new TreeMap<>();

        while (materialsStack.size() > 0 && magicQueue.size() > 0) {

            if (materialsStack.peek() == 0 || magicQueue.peek() == 0){
                if (materialsStack.peek() == 0) {
                    materialsStack.pop();
                }

                if (magicQueue.peek() == 0) {
                    magicQueue.poll();
                }
                continue;
            }

            int currentPoints = materialsStack.peek() * magicQueue.peek();
            if (presents.containsKey(currentPoints)) {
                String currentPresent = presents.get(currentPoints);

                if (!craftedPresents.containsKey(currentPresent)) {
                    craftedPresents.put(currentPresent, 1);
                } else {
                    int currentValue = craftedPresents.get(currentPresent);
                    craftedPresents.put(currentPresent, currentValue + 1);
                }

                materialsStack.pop();
                magicQueue.poll();

            } else if (currentPoints < 0) {
                int sumValues = materialsStack.peek() + magicQueue.peek();
                materialsStack.pop();
                magicQueue.poll();
                if (sumValues != 0) {
                    materialsStack.push(sumValues);
                }
            } else if (currentPoints > 0) {
                magicQueue.poll();
                int currentStackValue = materialsStack.pop();
                int newValue = currentStackValue + 15;
                materialsStack.push(newValue);
            }
        }

        if (craftedPresents.containsKey("Teddy bear") && craftedPresents.containsKey("Bicycle")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else if (craftedPresents.containsKey("Doll") && craftedPresents.containsKey("Wooden train")) {
            System.out.println("The presents are crafted! Merry Christmas!");
        } else {
            System.out.println("No presents this Christmas!");
        }

        if (materialsStack.size() > 0) {
            List<String> list = new ArrayList<>();
            while (materialsStack.size() > 0) {
                list.add(String.valueOf(materialsStack.pop()));
            }
            System.out.println("Materials left: " + String.join(", ", list));
        }

        if (magicQueue.size() > 0) {
            List<String> list = new ArrayList<>();
            while (magicQueue.size() > 0) {
                list.add(String.valueOf(magicQueue.poll()));
            }
            System.out.println("Magic left: " + String.join(", ", list));
        }

        if (!craftedPresents.isEmpty()) {
            for (Map.Entry<String, Integer> entry : craftedPresents.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
}