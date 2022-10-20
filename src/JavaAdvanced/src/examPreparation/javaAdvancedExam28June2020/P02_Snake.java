package JavaAdvanced.src.examPreparation.javaAdvancedExam28June2020;

import java.util.Scanner;

public class P02_Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] territory = new char[size][size];

        int snakeRow = 0;
        int snakeCol = 0;

        for (int row = 0; row < territory.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < territory[row].length; col++) {
                territory[row][col] = currentRow[col];

                if (territory[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                }
            }
        }

        int food = 0;
        boolean isOutOfBounds = false;
        while (true) {
            String command = scanner.nextLine();

            territory[snakeRow][snakeCol] = '.';
            switch (command) {
                case "down":
                    snakeRow++;
                    break;

                case "up":
                    snakeRow--;
                    break;

                case "left":
                    snakeCol--;
                    break;

                case "right":
                    snakeCol++;
                    break;
            }

            if (isOutOfBounds(territory, snakeRow, snakeCol)) {
                isOutOfBounds = true;
                break;
            }

            if (territory[snakeRow][snakeCol] == '*') {
                food++;
                if (food == 10) {
                    territory[snakeRow][snakeCol] = 'S';
                    break;
                }
            } else if (territory[snakeRow][snakeCol] == 'B') {
                territory[snakeRow][snakeCol] = '.';

                for (int row = 0; row < territory.length; row++) {
                    for (int col = 0; col < territory[row].length; col++) {
                        if (territory[row][col] == 'B') {
                            snakeRow = row;
                            snakeCol = col;
                        }
                    }
                }
            }

            territory[snakeRow][snakeCol] = 'S';
        }

        if (isOutOfBounds) {
            System.out.println("Game over!");
            System.out.println("Food eaten: " + food);
            printMatrix(territory);

        } else if (food >= 10) {
            System.out.println("You won! You fed the snake.");
            System.out.println("Food eaten: " + food);

            printMatrix(territory);
        }


    }

    private static void printMatrix(char[][] territory) {
        for (int row = 0; row < territory.length; row++) {
            for (int col = 0; col < territory[row].length; col++) {
                System.out.print(territory[row][col]);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(char[][] territory, int snakeRow, int snakeCol) {
        boolean isOutOfBounds = false;
        if (snakeCol < 0 || snakeCol >= territory.length || snakeRow < 0 || snakeRow >= territory.length) {
            isOutOfBounds = true;
            return true;
        }
        return false;
    }
}
