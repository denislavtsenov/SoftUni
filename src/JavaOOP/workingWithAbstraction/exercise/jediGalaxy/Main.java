package JavaOOP.workingWithAbstraction.exercise.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        int value = 0;
        readGalaxy(rows, cols, galaxy, value);

        String command = scanner.nextLine();
        long stars = 0;
        while (!command.equals("Let the Force be with you")) {
            int[] peterCoordinates = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int[] evilCoordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

            moveEvil(galaxy, evilCoordinates);

            stars = movePeter(galaxy, stars, peterCoordinates);

            command = scanner.nextLine();
        }
        System.out.println(stars);
    }

    private static long movePeter(int[][] galaxy, long stars, int[] peterCoordinates) {
        int peterRow = peterCoordinates[0];
        int peterCol = peterCoordinates[1];

        while (peterRow >= 0 && peterCol < galaxy[1].length) {
            if (peterRow >= 0 && peterRow < galaxy.length && peterCol >= 0 && peterCol < galaxy[0].length) {
                stars += galaxy[peterRow][peterCol];
            }

            peterCol++;
            peterRow--;
        }
        return stars;
    }

    private static void moveEvil(int[][] galaxy, int[] evilCoordinates) {
        int evilRow = evilCoordinates[0];
        int evilCol = evilCoordinates[1];

        while (evilRow >= 0 && evilCol >= 0) {
            if (evilRow < galaxy.length && evilCol < galaxy[0].length) {
                galaxy[evilRow][evilCol] = 0;
            }
            evilRow--;
            evilCol--;
        }
    }

    private static void readGalaxy(int rows, int cols, int[][] galaxy, int value) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                galaxy[i][j] = value++;
            }
        }
    }
}
