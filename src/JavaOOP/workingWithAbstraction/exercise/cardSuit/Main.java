package JavaOOP.workingWithAbstraction.exercise.cardSuit;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();

        CardSuits[] cardSuits = CardSuits.values();

        System.out.println("Card Suits:");

        for (int i = 0; i < cardSuits.length; i++) {
            CardSuits suit = cardSuits[i];
            System.out.printf("Ordinal value: %s; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
