package multidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        readMatrix(scanner, matrix);

        int sumOfPrimaryDiagonal = 0;
        for (int row = 0, col = 0; row < matrix.length; row++, col++) {
            sumOfPrimaryDiagonal += matrix[row][col];
        }

        int sumOfSecondaryDiagonal = 0;
        for (int row = matrix.length - 1, col = 0; row >= 0 && col < matrix.length; row--, col++) {
            sumOfSecondaryDiagonal += matrix[row][col];
        }

        int totalDiff = Math.abs(sumOfPrimaryDiagonal - sumOfSecondaryDiagonal);

        System.out.println(totalDiff);


    }

    private static void readMatrix(Scanner scanner, int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] inputRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = inputRow;
        }
    }
}
