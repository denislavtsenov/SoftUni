package JavaAdvanced.src.examPreparation.javaAdvancedExam22Feb2020;

import java.util.Scanner;

public class P02_ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        int playerRow = 0;
        int playerCol = 0;
        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = currentRow[col];

                if (matrix[row][col] == 'f') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean isFinished = false;

        int commandsCounter = 0;
        String command = scanner.nextLine();
        for (int i = 0; i < numberOfCommands; i++) {
            commandsCounter++;
            int previousRow = playerRow;
            int previousCol = playerCol;

            if (matrix[playerRow][playerCol] != 'B') {
                matrix[previousRow][previousCol] = '-';
            }

            switch (command) {

                case "up":
                    playerRow--;
                    if (isOutOfBounds(matrix, playerRow, playerCol)) {
                        playerRow = matrix.length - 1;
                    }
                    break;
                case "down":
                    playerRow++;
                    if (isOutOfBounds(matrix, playerRow, playerCol)) {
                        playerRow = 0;
                    }
                    break;
                case "left":
                    playerCol--;
                    if (isOutOfBounds(matrix, playerRow, playerCol)) {
                        playerCol = matrix[playerRow].length - 1;
                    }
                    break;
                case "right":
                    playerCol++;
                    if (isOutOfBounds(matrix, playerRow, playerCol)) {
                        playerCol = 0;
                    }
                    break;
            }


            if (matrix[playerRow][playerCol] == 'F') {
                isFinished = true;
                matrix[playerRow][playerCol] = 'f';
                break;
            } else if (matrix[playerRow][playerCol] == 'B') {
                continue;


            } else if (matrix[playerRow][playerCol] == 'T') {
                playerRow = previousRow;
                playerCol = previousCol;
            }


            matrix[playerRow][playerCol] = 'f';

            if (commandsCounter == numberOfCommands) {
                break;
            }

            command = scanner.nextLine();
        }

        if (isFinished) {
            System.out.println("Player won!");
            printMatrix(matrix);
        } else {
            System.out.println("Player lost!");
            printMatrix(matrix);
        }


    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        boolean isOutOfBounds = false;
        if (row < 0 || row > matrix.length || col < 0 || col > matrix.length) {
            return true;
        }
        return false;
    }
}
