package List.MidExams.FundamentalsMidExam06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P02_TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChests = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Yohoho!")) {
            List<String> commands = Arrays.stream(input.split(" ")).collect(Collectors.toList());

            String command = commands.get(0);

            switch (command) {
                case "Loot":
                    for (int i = 1; i < commands.size(); i++) {
                        String currentLoot = commands.get(i);
                        if (!treasureChests.contains(currentLoot)) {
                            treasureChests.add(0, currentLoot);
                        }
                    }
                    break;

                case "Drop":
                    int index = Integer.parseInt(commands.get(1));
                    if (index >= 0 && index < treasureChests.size()) {
                        String removedItem = treasureChests.get(index);
                        treasureChests.remove(treasureChests.get(index));
                        treasureChests.add(removedItem);
                    }
                    break;
                case "Steal":
                    List<String> stealItems = new ArrayList<>();
                    int count = Integer.parseInt(commands.get(1));
                    if (count < treasureChests.size()) {
                        for (int i = treasureChests.size() - count; i < treasureChests.size(); i++) {
                            stealItems.add(treasureChests.get(i));
                            treasureChests.remove(treasureChests.get(i));
                        }
                    }
                    if (stealItems.size() > 0) {
                        for (int j = 0; j < stealItems.size(); j++) {
                            if (j == stealItems.size() - 1) {
                                System.out.print(stealItems.get(j));
                            } else {
                                System.out.print(stealItems.get(j) + ", ");
                            }
                        }
                        System.out.println();

                        int sum = 0;
                        count = 0;
                        for (int i = 0; i < treasureChests.size(); i++) {
                            count++;
                            String currentItem = treasureChests.get(i);
                            int currentLength = currentItem.length();
                            sum += currentLength;
                        }
                        double treasureGain = sum * 1.0/ count;
                        System.out.printf("Average treasure gain: %.2f pirate credits.", treasureGain);

                    } else {
                        for (int j = 0; j < treasureChests.size(); j++) {
                            if (j == treasureChests.size() - 1) {
                                System.out.print(treasureChests.get(j));
                            } else {
                                System.out.print(treasureChests.get(j) + ", ");
                            }
                        }
                        System.out.println();
                        System.out.println("Failed treasure hunt.");
                    }
                    break;
            }
            input = scanner.nextLine();
        }
    }
}