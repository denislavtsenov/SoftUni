package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P05_PrintPartOfASCIITable {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int startIndex = Integer.parseInt(scan.nextLine());
        int endIndex = Integer.parseInt(scan.nextLine());

        for (int i = startIndex; i <= endIndex ; i++) {
            System.out.print((char)i + " ");
        }
    }
}
