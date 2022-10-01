package multidimensionalArrays.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04_MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        readMatrix(scanner, matrix);

        int[][] subMatrix = new int[3][3];

        int maxSum = getMaxSumOfSubMatrix(matrix, subMatrix);
        System.out.println("Sum = " + maxSum);

        printSubMatrix(subMatrix);
    }

    private static int getMaxSumOfSubMatrix(int[][] matrix, int[][] subMatrix) {
        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > maxSum) {
                    maxSum = currentSum;

                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[0][2] = matrix[row][col + 2];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                    subMatrix[1][2] = matrix[row + 1][col + 2];
                    subMatrix[2][0] = matrix[row + 2][col];
                    subMatrix[2][1] = matrix[row + 2][col + 1];
                    subMatrix[2][2] = matrix[row + 2][col + 2];

                }
            }
        }
        return maxSum;
    }

    private static void printSubMatrix(int[][] subMatrix) {
        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }
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
