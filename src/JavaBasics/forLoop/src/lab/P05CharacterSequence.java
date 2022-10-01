package LAB;

import java.util.Scanner;

public class P05CharacterSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String text = scan.nextLine();

        for(int position = 0; position <= text.length() - 1; position++) {
            char currentSymbol = text.charAt(position);
            System.out.println(currentSymbol);
        }
    }
}
