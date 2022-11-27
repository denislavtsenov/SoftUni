package JavaOOP.workingWithAbstraction.exercise.cardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        CardRank[] cardRanks = CardRank.values();

        System.out.println("Card Ranks:");

        for (int i = 0; i < cardRanks.length; i++) {
            CardRank cardRank = cardRanks[i];

            System.out.printf("Ordinal value: %s; Name value: %s%n", cardRank.ordinal(), cardRank.name());
        }
    }
}
