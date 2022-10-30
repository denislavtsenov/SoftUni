package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam18August2021;

import java.util.Scanner;

public class P02_FormulaOne {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int playerRow = 0;
        int playerCol = 0;

        int size = Integer.parseInt(scanner.nextLine());
        int numOfCommands = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[size][size];

        for (int row = 0; row < field.length; row++) {
            char[] currentRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < field[row].length; col++) {
                field[row][col] = currentRow[col];

                if (field[row][col] == 'P') {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean isFinished = false;

        String command = scanner.nextLine();
        while (numOfCommands > 0) {

            int prevRow = playerRow;
            int prevCol = playerCol;

            if (command.equals("up")) {
                if (playerRow - 1 >= 0) {

                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerRow--;
                } else {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerRow = field.length - 1;
                }
            } else if (command.equals("down")) {
                if (playerRow + 1 < field.length) {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerRow++;
                } else {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerRow = 0;
                }
            } else if (command.equals("left")) {
                if (playerCol - 1 >= 0) {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerCol--;
                } else {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerCol = field.length - 1;
                }
            } else if (command.equals("right")) {
                if (playerCol + 1 < field.length) {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerCol++;
                } else {
                    if (field[playerRow][playerCol] != 'B' && field[playerRow][playerCol] != 'T') {
                        field[playerRow][playerCol] = '.';
                    }
                    playerCol = 0;
                }
            }

            if (field[playerRow][playerCol] == 'B') {
                continue;
            } else if (field[playerRow][playerCol] == 'T') {
                playerRow = prevRow;
                playerCol = prevCol;

            } else if (field[playerRow][playerCol] == 'F') {
                field[playerRow][playerCol] = 'P';
                isFinished = true;
                break;
            }

            field[playerRow][playerCol] = 'P';

            numOfCommands--;
            if (numOfCommands == 0) {
                break;
            }

            command = scanner.nextLine();
        }


        if (isFinished) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }

        printField(field);
    }

    private static void printField(char[][] field) {
        for (int row = 0; row < field.length; row++) {
            for (int col = 0; col < field[row].length; col++) {
                System.out.print(field[row][col]);
            }
            System.out.println();
        }
    }
}
