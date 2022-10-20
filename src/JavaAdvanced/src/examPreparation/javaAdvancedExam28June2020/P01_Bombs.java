package JavaAdvanced.src.examPreparation.javaAdvancedExam28June2020;

import java.util.*;

public class P01_Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBombEffectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> secondBombCasingStack = new ArrayDeque<>();

        int[] bombEffect = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < bombEffect.length; i++) {
            firstBombEffectQueue.offer(bombEffect[i]);
        }

        int[] bombCasing = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < bombCasing.length; i++) {
            secondBombCasingStack.push(bombCasing[i]);
        }


        Map<String, Integer> bombs = new TreeMap<>();
        bombs.put("Datura Bombs", 0);
        bombs.put("Cherry Bombs", 0);
        bombs.put("Smoke Decoy Bombs", 0);


        boolean isFilled = true;
        while (!firstBombEffectQueue.isEmpty() && !secondBombCasingStack.isEmpty()) {
            isFilled = true;
            for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
                int current = entry.getValue();

                if (current < 3) {
                    isFilled = false;
                    break;
                }
            }

            if (isFilled) {
                break;
            }

            int firstBomb = firstBombEffectQueue.peek();
            int secondBomb = secondBombCasingStack.peek();
            int sum = firstBomb + secondBomb;

            if (sum == 40) {
                Integer currentValue = bombs.get("Datura Bombs");
                bombs.put("Datura Bombs", currentValue + 1);

                firstBombEffectQueue.poll();
                secondBombCasingStack.pop();

            } else if (sum == 60) {
                Integer currentValue = bombs.get("Cherry Bombs");
                bombs.put("Cherry Bombs", currentValue + 1);

                firstBombEffectQueue.poll();
                secondBombCasingStack.pop();

            } else if (sum == 120) {
                Integer currentValue = bombs.get("Smoke Decoy Bombs");
                bombs.put("Smoke Decoy Bombs", currentValue + 1);

                firstBombEffectQueue.poll();
                secondBombCasingStack.pop();
            } else {
                int currentElement = secondBombCasingStack.pop();
                secondBombCasingStack.push(currentElement - 5);
            }

        }


        if (isFilled) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (firstBombEffectQueue.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            List<String> bombList = new ArrayList<>();
            for (Integer bomb : firstBombEffectQueue) {
                bombList.add(bomb.toString());
            }
            System.out.print(String.join(", ", bombList));
            System.out.println();
        }

        if (secondBombCasingStack.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            List<String> bombList = new ArrayList<>();
            for (Integer bomb : secondBombCasingStack) {
                bombList.add(bomb.toString());
            }
            System.out.print(String.join(", ", bombList));
            System.out.println();
        }

        for (Map.Entry<String, Integer> entry : bombs.entrySet()) {
            System.out.printf("%s: %d%n", entry.getKey(), entry.getValue());
        }
    }
}
