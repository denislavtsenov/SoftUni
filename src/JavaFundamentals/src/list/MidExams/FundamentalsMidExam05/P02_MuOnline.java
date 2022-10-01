package List.MidExams.FundamentalsMidExam05;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P02_MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initHealth = 100;
        int initBitcoins = 0;

        String[] rooms = scanner.nextLine().split("\\|");
        int countRooms = 0;
        for (int i = 0; i < rooms.length; i++) {
            countRooms++;
            List<String> currentRoom = Collections.singletonList(rooms[i]);

            String[] commands = currentRoom.get(0).split(" ");

            String command = commands[0];
            int number = Integer.parseInt(commands[1]);

            switch (command) {
                case "potion":

                    if (initHealth + number > 100) {
                        number = 100 - initHealth;
                    }
                    initHealth = initHealth + number;
                    if (initHealth > 100) {
                        initHealth = 100;
                    }



                    System.out.printf("You healed for %d hp.%n", number);
                    System.out.printf("Current health: %d hp.%n", initHealth);
                    break;
                case "chest":
                    initBitcoins += number;
                    System.out.printf("You found %d bitcoins.%n", number);
                    break;
                default:
                    initHealth = initHealth - number;
                    if (initHealth > 0) {
                        System.out.printf("You slayed %s.%n", command);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", command);
                        System.out.printf("Best room: %d%n", countRooms);
                    }
                    break;
            }
            if (initHealth <= 0) {
                break;
            }
        }

        if (initHealth > 0) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", initBitcoins);
            System.out.printf("Health: %d%n", initHealth);
        }
    }
}

