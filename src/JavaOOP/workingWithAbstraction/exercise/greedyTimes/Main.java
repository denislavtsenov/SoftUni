
package JavaOOP.workingWithAbstraction.exercise.greedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacityOfTheBag = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < safe.length; i += 2) {
            String currentItem = safe[i];
            long amount = Long.parseLong(safe[i + 1]);

            String itemType = checkItemType(currentItem);

            if (itemType.equals("")) {
                continue;
            } else if (capacityOfTheBag < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount) {
                continue;
            }

            switch (itemType) {
                case "Gem":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemType)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemType).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemType)) {
                bag.put((itemType), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(itemType).containsKey(currentItem)) {
                bag.get(itemType).put(currentItem, 0L);
            }

            bag.get(itemType).put(currentItem, bag.get(itemType).get(currentItem) + amount);
            if (itemType.equals("Gold")) {
                gold += amount;
            } else if (itemType.equals("Gem")) {
                gems += amount;
            } else if (itemType.equals("Cash")) {
                cash += amount;
            }
        }

        printBag(bag);
    }

    private static void printBag(Map<String, LinkedHashMap<String, Long>> bag) {
        for (Map.Entry<String, LinkedHashMap<String, Long>> entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();
            System.out.println(String.format("<%s> $%s", entry.getKey(), sumValues));
            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).
                    forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));
        }
    }

    private static String checkItemType(String currentItem) {
        String itemType = "";

        if (currentItem.length() == 3) {
            itemType = "Cash";
        } else if (currentItem.toLowerCase().endsWith("gem")) {
            itemType = "Gem";
        } else if (currentItem.toLowerCase().equals("gold")) {
            itemType = "Gold";
        }
        return itemType;
    }
}