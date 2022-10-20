package JavaAdvanced.src.examPreparation.javaAdvancedExam25June2022;

import java.util.Scanner;

public class P02_StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dillingerRow = 0;
        int dillingerCol = 0;

        int size = Integer.parseInt(scanner.nextLine());
        String[] commandsLine = scanner.nextLine().split(",");

        char[][] field = new char[size][size];

        for (int row = 0; row < field.length; row++) {
            char[] currentRow = scanner.nextLine().replace(" ", "").toCharArray();
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = currentRow[col];

                if (field[row][col] == 'D') {
                    dillingerRow = row;
                    dillingerCol = col;
                }
            }
        }

        int totalSum = 0;
        boolean isCaught = false;

        for (int i = 0; i < commandsLine.length; i++) {
            int currentSum = 0;
            String currentCommand = commandsLine[i];
            int prevRow = dillingerRow;
            int prevCol = dillingerCol;

            if (currentCommand.equals("up")) {
                if (dillingerRow - 1 >= 0) {
                    field[dillingerRow][dillingerCol] = '+';
                    dillingerRow--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (currentCommand.equals("down")) {
                if (dillingerRow + 1 < field.length) {
                    field[dillingerRow][dillingerCol] = '+';
                    dillingerRow++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }

            } else if (currentCommand.equals("left")) {
                if (dillingerCol - 1 >= 0) {
                    field[dillingerRow][dillingerCol] = '+';
                    dillingerCol--;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            } else if (currentCommand.equals("right")) {
                if (dillingerCol + 1 < field.length) {
                    field[dillingerRow][dillingerCol] = '+';
                    dillingerCol++;
                } else {
                    System.out.println("You cannot leave the town, there is police outside!");
                }
            }


            if (field[dillingerRow][dillingerCol] == '$') {
                currentSum = dillingerRow * dillingerCol;
                totalSum += currentSum;
                System.out.printf("You successfully stole %d$.%n", currentSum);
            } else if (field[dillingerRow][dillingerCol] == 'P') {
                System.out.printf("You got caught with %d$, and you are going to jail.%n", totalSum);
                field[prevRow][prevCol] = '+';
                field[dillingerRow][dillingerCol] = '#';
                isCaught = true;
                break;
            }

            field[dillingerRow][dillingerCol] = 'D';
        }


        if (!isCaught) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalSum);
        }

        printMatrix(field);

    }

    private static void printMatrix(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col] + " ");
            }
            System.out.println();
        }
    }

}

