package JavaAdvanced.src.examPreparation.javaAdvancedExam22October2022;

import java.util.Scanner;

public class P02_RallyRacing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startRow = 0;
        int startCol = 0;

        int size = Integer.parseInt(scanner.nextLine());
        String racingNumber = scanner.nextLine();

        char[][] matrix = new char[size][size];

        for (int row = 0; row < matrix.length; row++) {
            char[] inputRow = scanner.nextLine().replace(" ", "").toCharArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = inputRow[col];
            }
        }
        matrix[startRow][startCol] = 'C';
        int distance = 0;
        boolean isFinished = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {

            if (command.equals("left")) {
                if (startCol - 1 >= 0) {
                    matrix[startRow][startCol] = '.';
                    startCol--;
                }
            } else if (command.equals("right")) {
                if (startCol + 1 < matrix.length) {
                    matrix[startRow][startCol] = '.';
                    startCol++;
                }
            } else if (command.equals("up")) {
                if (startRow - 1 >= 0) {
                    matrix[startRow][startCol] = '.';
                    startRow--;
                }
            } else if (command.equals("down")) {
                if (startRow + 1 < matrix.length) {
                    matrix[startRow][startCol] = '.';
                    startRow++;
                }
            }

            if (matrix[startRow][startCol] == 'T') {
                matrix[startRow][startCol] = '.';
                boolean isFoundT = false;
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (matrix[row][col] == 'T') {
                            startRow = row;
                            startCol = col;
                            isFoundT = true;
                            break;
                        }
                    }
                    if (isFoundT) {
                        break;
                    }
                }
                distance += 30;
                matrix[startRow][startCol] = 'C';
                command = scanner.nextLine();

            } else if (matrix[startRow][startCol] == 'F') {
                matrix[startRow][startCol] = 'C';
                distance += 10;
                isFinished = true;
                break;
            } else {
                distance += 10;
                matrix[startRow][startCol] = 'C';
                command = scanner.nextLine();
            }
        }

        if (isFinished) {
            System.out.printf("Racing car %s finished the stage!%n", racingNumber);
        } else {
            System.out.printf("Racing car %s DNF.%n", racingNumber);
        }

        System.out.printf("Distance covered %d km.%n", distance);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
