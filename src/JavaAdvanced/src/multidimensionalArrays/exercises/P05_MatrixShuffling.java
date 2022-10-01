package multidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P05_MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = new String[rows][cols];

        readMatrix(scanner, rows, matrix);

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("END")) {
            String[] commands = inputLine.split("\\s+");

            if (commands[0].equals("swap") && commands.length == 5) {

                int firstRow = Integer.parseInt(commands[1]);
                int firstCol = Integer.parseInt(commands[2]);
                int secondRow = Integer.parseInt(commands[3]);
                int secondCol = Integer.parseInt(commands[4]);

                boolean isCoordinatesExist = isCoordinatesExist(matrix, firstRow, firstCol, secondRow, secondCol);

                if (!isCoordinatesExist) {
                    System.out.println("Invalid input!");
                    inputLine = scanner.nextLine();
                    continue;
                } else {
                    shuffleMatrix(matrix, firstRow, firstCol, secondRow, secondCol);

                    printMatrix(matrix);
                }

            } else {
                System.out.println("Invalid input!");
                inputLine = scanner.nextLine();
                continue;
            }
            inputLine = scanner.nextLine();
        }
    }

    private static void shuffleMatrix(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        String oldValues = matrix[firstRow][firstCol];
        matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
        matrix[secondRow][secondCol] = oldValues;
    }

    private static void readMatrix(Scanner scanner, int rows, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] inputRow = scanner.nextLine().split("\\s+");

            matrix[row] = inputRow;
        }
    }

    private static boolean isCoordinatesExist(String[][] matrix, int firstRow, int firstCol, int secondRow, int secondCol) {
        boolean isCoordinatesExist = false;

        if (firstRow >= 0 && firstRow < matrix.length
                && firstCol >= 0 && firstCol < matrix[firstRow].length
                && secondRow >= 0 && secondRow < matrix.length
                && secondCol >= 0 && secondCol < matrix[secondRow].length) {

            isCoordinatesExist = true;
        }
        return isCoordinatesExist;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}