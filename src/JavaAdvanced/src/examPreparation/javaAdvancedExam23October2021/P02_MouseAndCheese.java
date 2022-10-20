package JavaAdvanced.src.examPreparation.javaAdvancedExam23October2021;

import java.util.Scanner;

public class P02_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] mouseTerritory = new char[size][size];

        int mouseRow = -1;
        int mouseCol = -1;


        for (int row = 0; row < mouseTerritory.length; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < mouseTerritory[row].length; col++) {

                mouseTerritory[row][col] = inputRow[col];

                if (mouseTerritory[row][col] == 'M') {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }


        boolean isOutOfBounds = false;
        int eatenCheese = 0;

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            if (command.equals("up")) {
                if (mouseRow - 1 >= 0) {
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    mouseRow--;
                } else {
                    isOutOfBounds = true;
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    break;
                }
            } else if (command.equals("down")) {
                if (mouseRow + 1 < mouseTerritory.length) {
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    mouseRow++;
                } else {
                    isOutOfBounds = true;
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    break;
                }
            } else if (command.equals("left")) {
                if (mouseCol - 1 >= 0) {
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    mouseCol--;
                } else {
                    isOutOfBounds = true;
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    break;
                }

            } else if (command.equals("right")) {
                if (mouseCol + 1 < mouseTerritory.length) {
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    mouseCol++;
                } else {
                    isOutOfBounds = true;
                    mouseTerritory[mouseRow][mouseCol] = '-';
                    break;
                }
            }

            if (mouseTerritory[mouseRow][mouseCol] == 'B') {
                mouseTerritory[mouseRow][mouseCol] = '-';
                continue;
            } else if (mouseTerritory[mouseRow][mouseCol] == 'c') {
                mouseTerritory[mouseRow][mouseCol] = 'M';
                eatenCheese++;
            }
            mouseTerritory[mouseRow][mouseCol] = 'M';
            command = scanner.nextLine();
        }

        if (isOutOfBounds) {
            System.out.println("Where is the mouse?");
        }

        if (eatenCheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", eatenCheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - eatenCheese);
        }

        printMatrix(mouseTerritory, mouseRow, mouseCol);
    }

    private static void printMatrix(char[][] mouseTerritory, int mouseRow, int mouseCol) {
        for (int row = 0; row < mouseTerritory.length; row++) {
            for (int col = 0; col < mouseTerritory[row].length; col++) {
                System.out.print(mouseTerritory[row][col]);
            }
            System.out.println();
        }
    }
}
