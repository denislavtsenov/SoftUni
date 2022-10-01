package List.MidExams.FundamentalsMidExam06;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> warShip = Arrays.stream(scanner.nextLine().split(">"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxHealthCapacity = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        while (!input.equals("Retire")) {
            List<String> commands = Arrays.stream(input.split(" ")).collect(Collectors.toList());
            String command = commands.get(0);

            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(commands.get(1));
                    int damage = Integer.parseInt(commands.get(2));

                    if (index >= 0 && index < warShip.size()) {
                        int currentHealthWarship = warShip.get(index) - damage;
                        warShip.set(index, currentHealthWarship);
                        if (currentHealthWarship <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }

                    }
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(commands.get(1));
                    int endIndex = Integer.parseInt(commands.get(2));
                    int damageDefend = Integer.parseInt(commands.get(3));

                    if (startIndex >= 0 && startIndex < pirateShip.size()
                            && endIndex >= 0 && endIndex < pirateShip.size()) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int currentHealthPirateShip = pirateShip.get(i) - damageDefend;
                            pirateShip.set(i, currentHealthPirateShip);
                            if (currentHealthPirateShip <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;

                case "Repair":
                    int repairIndex = Integer.parseInt(commands.get(1));
                    int health = Integer.parseInt(commands.get(2));

                    if (repairIndex >= 0 && repairIndex < pirateShip.size()) {
                        int currentHealthPirate = pirateShip.get(repairIndex);
                        int repairing = health + currentHealthPirate;

                        if (repairing > maxHealthCapacity) {
                            repairing = maxHealthCapacity;
                        }
                        pirateShip.set(repairIndex, repairing);
                    }
                    break;

                case "Status":
                    int count = 0;
                    for (int i = 0; i < pirateShip.size(); i++) {
                        int currentSection = pirateShip.get(i);
                        double needsRepair = maxHealthCapacity * 0.2;
                        if (currentSection < needsRepair) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);

                    break;
            }
            input = scanner.nextLine();
        }

        int pirateSum = 0;
        for (int i = 0; i < pirateShip.size(); i++) {
            int num = pirateShip.get(i);
            pirateSum += num;
        }

        int warSum = 0;
        for (int i = 0; i < warShip.size(); i++) {
            int num = warShip.get(i);
           warSum += num;
        }

        System.out.printf("Pirate ship status: %d%n", pirateSum);
        System.out.printf("Warship status: %d%n", warSum);
    }
}