package JavaAdvanced.src.examPreparation.javaAdvancedExam19February2022;

import java.util.Scanner;

public class P02_PawnWars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessBoard = new char[8][8];
        int whiteRow = 0;
        int whiteCol = 0;

        int blackRow = 0;
        int blackCol = 0;

        readMatrix(scanner, chessBoard);


        for (int row = 0; row < chessBoard.length; row++)
            for (int col = 0; col < chessBoard[row].length; col++) {

                if (chessBoard[row][col] == 'w') {
                    whiteRow = row;
                    whiteCol = col;
                } else if (chessBoard[row][col] == 'b') {
                    blackRow = row;
                    blackCol = col;
                }
            }

        boolean isHit = false;

        while (whiteRow != 0 && blackRow != 7 && !isHit) {
            if (whitePawHitBlack(whiteRow, whiteCol, blackRow, blackCol)) {

                String coordinates = findCoordinates(blackRow, blackCol);
                System.out.printf("Game over! White capture on %s.", coordinates);
                isHit = true;

            }
            whiteRow -= 1;

            if (blackPawHitWhite(blackRow, blackCol, whiteRow, whiteCol)) {

                String coordinates = findCoordinates(whiteRow, whiteCol);
                System.out.printf("Game over! Black capture on %s.", coordinates);
                isHit = true;

            }
            blackRow += 1;

        }

        if (!isHit) {
            System.out.print(whiteRow == 0
                    ? "Game over! White pawn is promoted to a queen at " + findCoordinates(whiteRow, whiteCol) + "."
                    : "Game over! Black pawn is promoted to a queen at " + findCoordinates(blackRow, blackCol) + "."
            );
        }
    }

    private static void readMatrix(Scanner scanner, char[][] chessBoard) {
        for (int row = 0; row < chessBoard.length; row++) {
            char[] inputRow = scanner.nextLine().toCharArray();
            for (int col = 0; col < chessBoard[row].length; col++) {
                chessBoard[row][col] = inputRow[col];
            }
        }
    }


    private static String findCoordinates(int bRow, int bCol) {
        char[] col = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        char[] row = new char[]{'8', '7', '6', '5', '4', '3', '2', '1'};
        StringBuilder sb = new StringBuilder();
        sb.append(col[bCol]).append(row[bRow]);
        return sb.toString();
    }

    private static boolean blackPawHitWhite(int bRow, int bCol, int wRow, int wCol) {
        if (bRow + 1 == wRow && (bCol + 1 == wCol || bCol - 1 == wCol)) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean whitePawHitBlack(int wRow, int wCol, int bRow, int bCol) {
        if (wRow - 1 == bRow && (wCol + 1 == bCol || wCol - 1 == bCol)) {
            return true;
        } else {
            return false;
        }
    }
}






