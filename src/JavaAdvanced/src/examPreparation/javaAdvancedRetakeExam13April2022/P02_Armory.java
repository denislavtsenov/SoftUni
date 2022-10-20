package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam13April2022;

import java.util.Scanner;

public class P02_Armory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int armorySize = Integer.parseInt(scanner.nextLine());

        char[][] armory = new char[armorySize][armorySize];

        int officerRow = -1;
        int officerCol = -1;

        for (int row = 0; row < armory.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < armory[row].length; col++) {
                armory[row][col] = currentRow[col];

                if (armory[row][col] == 'A') {
                    officerRow = row;
                    officerCol = col;
                }
            }
        }

        int totalCoins = 0;
        boolean isOutOfBounds = false;
        while (totalCoins < 65) {
            String command = scanner.nextLine();

            if (command.equals("left")) {
                if (officerCol - 1 >= 0) {
                    armory[officerRow][officerCol] = '-';
                    officerCol--;
                } else {
                    isOutOfBounds = true;
                    armory[officerRow][officerCol] = '-';
                    break;
                }
            } else if (command.equals("right")) {
                if (officerCol + 1 < armory.length) {
                    armory[officerRow][officerCol] = '-';
                    officerCol++;
                } else {
                    isOutOfBounds = true;
                    armory[officerRow][officerCol] = '-';
                    break;
                }
            } else if (command.equals("up")) {
                if (officerRow - 1 >= 0) {
                    armory[officerRow][officerCol] = '-';
                    officerRow--;
                } else {
                    isOutOfBounds = true;
                    armory[officerRow][officerCol] = '-';
                    break;
                }
            } else if (command.equals("down")) {
                if (officerRow + 1 < armory.length) {
                    armory[officerRow][officerCol] = '-';
                    officerRow++;
                } else {
                    isOutOfBounds = true;
                    armory[officerRow][officerCol] = '-';
                    break;
                }
            }

            if (Character.isDigit(armory[officerRow][officerCol])) {
                totalCoins += Integer.parseInt(String.valueOf(armory[officerRow][officerCol]));
            } else if (armory[officerRow][officerCol] == 'M') {
                armory[officerRow][officerCol] = '-';
                for (int row = 0; row < armory.length; row++) {
                    for (int col = 0; col < armory[row].length; col++) {

                        if (armory[row][col] == 'M') {
                            officerRow = row;
                            officerCol = col;
                        }
                    }
                }
            }

            armory[officerRow][officerCol] = 'A';

        }

        if (isOutOfBounds) {
            System.out.println("I do not need more swords!");
        } else {
            System.out.println("Very nice swords, I will come back for more!");
        }

        System.out.printf("The king paid %d gold coins.%n", totalCoins);

        printMatrix(armory);
    }

    private static void printMatrix(char[][] armory) {
        for (int row = 0; row < armory.length; row++) {
            for (int col = 0; col < armory[row].length; col++) {
                System.out.print(armory[row][col]);
            }
            System.out.println();
        }
    }
}
