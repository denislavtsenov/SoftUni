package JavaOOP.workingWithAbstraction.exercise.cardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputRank = scanner.nextLine();
        String inputSuit = scanner.nextLine();

        int cardRank = Cards.valueOf(inputRank).getPower();
        int cardSuit = Suits.valueOf(inputSuit).getPower();

        int totalValue = cardRank + cardSuit;

        System.out.printf("Card name: %s of %s; Card power: %d",
                Cards.valueOf(inputRank).name(), Suits.valueOf(inputSuit).name(), totalValue );
    }
}
