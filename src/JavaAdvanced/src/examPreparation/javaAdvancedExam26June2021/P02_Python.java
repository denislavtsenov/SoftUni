package JavaAdvanced.src.examPreparation.javaAdvancedExam26June2021;

import java.util.Scanner;

public class P02_Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snakeRow = -1;
        int snakeCol = -1;
        int foodCounter = 0;

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");

        char[][] screen = new char[size][size];

        for (int row = 0; row < screen.length; row++) {
            char[] currentRow = scanner.nextLine().replace(" ", "").toCharArray();
            for (int col = 0; col < screen[row].length; col++) {
                screen[row][col] = currentRow[col];

                if (screen[row][col] == 's') {
                    snakeRow = row;
                    snakeCol = col;
                } else if (screen[row][col] == 'f') {
                    foodCounter++;
                }
            }
        }

        boolean isKilled = false;
        boolean isWin = false;
        int snakeLength = 1;

        for (int i = 0; i < commands.length; i++) {
            String currentCommand = commands[i];
            screen[snakeRow][snakeCol] = '*';

            if (currentCommand.equals("up")) {
                if (snakeRow - 1 >= 0) {
                    snakeRow--;
                } else {
                    snakeRow = screen.length - 1;
                }
            } else if (currentCommand.equals("down")) {
                if (snakeRow + 1 < screen.length) {
                    snakeRow++;
                } else {
                    snakeRow = 0;
                }
            } else if (currentCommand.equals("left")) {
                if (snakeCol - 1 >= 0) {
                    snakeCol--;
                } else {
                    snakeCol = screen.length - 1;
                }
            } else if (currentCommand.equals("right")) {
                if (snakeCol + 1 < screen.length ) {
                    snakeCol++;
                } else {
                    snakeCol = 0;
                }
            }

            if (screen[snakeRow][snakeCol] == 'f') {
                foodCounter--;
                snakeLength++;

                if (foodCounter == 0) {
                    isWin = true;
                    break;
                }
            } else if (screen[snakeRow][snakeCol] == 'e') {
                isKilled = true;
                break;
            }
            screen[snakeRow][snakeCol] = 's';
        }

        if (isKilled) {
            System.out.println("You lose! Killed by an enemy!");
        } else if (isWin) {
            System.out.printf("You win! Final python length is %d%n", snakeLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", foodCounter);
        }
    }
}
