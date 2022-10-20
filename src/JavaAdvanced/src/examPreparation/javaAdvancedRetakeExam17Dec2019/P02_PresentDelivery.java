package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam17Dec2019;

import java.util.Scanner;

public class P02_PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int presentsCount = Integer.parseInt(scanner.nextLine());

        int size = Integer.parseInt(scanner.nextLine());

        char[][] neighborhood = new char[size][size];

        int santaRow = 0;
        int santaCol = 0;

        int kids = 0;
        int happyKids = 0;

        for (int row = 0; row < neighborhood.length; row++) {
            char[] inputRow = scanner.nextLine().replaceAll(" ", "").toCharArray();
            for (int col = 0; col < neighborhood[row].length; col++) {
                neighborhood[row][col] = inputRow[col];

                if (neighborhood[row][col] == 'S') {
                    santaRow = row;
                    santaCol = col;
                }

                if (neighborhood[row][col] == 'V') {
                    kids++;
                }
            }
        }

        boolean isOutOfBounds = false;

        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")) {

            neighborhood[santaRow][santaCol] = '-';

            if (command.equals("up")) {
                santaRow--;

                if (santaRow < 0) {
                    isOutOfBounds = true;
                    break;
                }
            } else if (command.equals("down")) {
                santaRow++;

                if (santaRow >= neighborhood.length) {
                    isOutOfBounds = true;
                    break;
                }
            } else if (command.equals("left")) {
                santaCol--;

                if (santaCol < 0) {
                    isOutOfBounds = true;
                    break;
                }
            } else if (command.equals("right")) {
                santaCol++;

                if (santaCol >= neighborhood.length) {
                    isOutOfBounds = true;
                    break;
                }
            }



            if (neighborhood[santaRow][santaCol] == 'V') {
                kids--;
                presentsCount--;
                happyKids++;
            } else if (neighborhood[santaRow][santaCol] == 'C') {

                if (neighborhood[santaRow + 1][santaCol] == 'V') {
                    neighborhood[santaRow + 1][santaCol] = '-';
                    presentsCount--;
                    kids--;
                    happyKids++;
                } else if (neighborhood[santaRow + 1][santaCol] == 'X') {
                    neighborhood[santaRow + 1][santaCol] = '-';
                    presentsCount--;
                    happyKids++;
                } else if (neighborhood[santaRow - 1][santaCol] == 'V') {
                    neighborhood[santaRow - 1][santaCol] = '-';
                    presentsCount--;
                    kids--;
                    happyKids++;
                } else if (neighborhood[santaRow - 1][santaCol] == 'X') {
                    neighborhood[santaRow - 1][santaCol] = '-';
                    presentsCount--;
                    happyKids++;
                } else if (neighborhood[santaRow][santaCol - 1] == 'V') {
                    neighborhood[santaRow][santaCol - 1] = '-';
                    presentsCount--;
                    kids--;
                    happyKids++;
                } else if (neighborhood[santaRow][santaCol - 1] == 'X') {
                    neighborhood[santaRow][santaCol - 1] = '-';
                    presentsCount--;
                    happyKids++;
                } else if (neighborhood[santaRow][santaCol + 1] == 'V') {
                    neighborhood[santaRow][santaCol + 1] = '-';
                    presentsCount--;
                    kids--;
                    happyKids++;
                } else  if (neighborhood[santaRow][santaCol + 1] == 'X') {
                    neighborhood[santaRow][santaCol + 1] = '-';
                    presentsCount--;
                    happyKids++;
                }
            }

            neighborhood[santaRow][santaCol] = 'S';

            if (presentsCount <= 0) {
                break;
            }
            command = scanner.nextLine();
        }

        if (presentsCount <= 0) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix(neighborhood);

        if (kids <= 0) {
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n", happyKids);
        } else {
            System.out.printf("No presents for %d nice kid/s.%n", kids);
        }

    }

    private static void printMatrix(char[][] neighborhood) {
        for (int row = 0; row < neighborhood.length; row++) {
            for (int col = 0; col < neighborhood[row].length; col++) {
                System.out.print(neighborhood[row][col] + " ");
            }
            System.out.println();
        }
    }
}
