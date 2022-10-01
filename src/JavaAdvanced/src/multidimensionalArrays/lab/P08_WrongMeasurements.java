package multidimensionalArrays.lab;

import java.util.Arrays;
import java.util.Scanner;

public class P08_WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] wrongMeasurements = new int[size][];


        readMatrix(scanner, wrongMeasurements);

        int[] wrongValue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongNum = wrongMeasurements[wrongValue[0]][wrongValue[1]];


        for (int row = 0; row < wrongMeasurements.length; row++) {
            for (int col = 0; col < wrongMeasurements[row].length; col++) {
                int currentNum = wrongMeasurements[row][col];

                if (currentNum == wrongNum) {

                    int nearestSum = getNearestSum(wrongMeasurements, row, col, wrongNum);

                    System.out.print(nearestSum + " ");

                } else {
                    System.out.print(wrongMeasurements[row][col] + " ");

                }
            }
            System.out.println();
        }


    }

    private static void readMatrix(Scanner scanner, int[][] wrongMeasurements) {
        for (int row = 0; row < wrongMeasurements.length; row++) {
            int[] inputRow = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            wrongMeasurements[row] = inputRow;
        }
    }

    private static int getNearestSum(int[][] wrongMeasurements, int row, int col, int wrongNum) {
        int nearestSum = 0;

        if (col - 1 >= 0 && col - 1 < wrongMeasurements[row].length && wrongMeasurements[row][col - 1] != wrongNum) {
            nearestSum += wrongMeasurements[row][col - 1];
        }

        if (col + 1 >= 0 && col + 1 < wrongMeasurements[row].length && wrongMeasurements[row][col + 1] != wrongNum) {
            nearestSum += wrongMeasurements[row][col + 1];
        }

        if (row - 1 >= 0 && row - 1 < wrongMeasurements.length && wrongMeasurements[row - 1][col] != wrongNum) {
            nearestSum += wrongMeasurements[row - 1][col];
        }

        if (row + 1 >= 0 && row + 1 < wrongMeasurements.length && wrongMeasurements[row + 1][col] != wrongNum) {
            nearestSum += wrongMeasurements[row + 1][col];
        }
        return nearestSum;
    }
}
