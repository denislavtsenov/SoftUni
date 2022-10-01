package setsAndMapsAdvanced.lab;

import java.util.*;

public class P03_VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] secondPlayerCards = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> firstPlayerDeck = new LinkedHashSet<>();
        Set<Integer> secondPlayerDeck = new LinkedHashSet<>();

        for (int i = 0; i < firstPlayerCards.length; i++) {
            firstPlayerDeck.add(firstPlayerCards[i]);
            secondPlayerDeck.add(secondPlayerCards[i]);
        }

        for (int i = 1; i <= 50; i++) {

            int firstCard = 0;
            if (!firstPlayerDeck.isEmpty()) {
                firstCard = firstPlayerDeck.iterator().next();
                firstPlayerDeck.remove(firstCard);
            } else {
                break;
            }
            int secondCard = 0;
            if (!secondPlayerDeck.isEmpty()) {
                secondCard = secondPlayerDeck.iterator().next();
                secondPlayerDeck.remove(secondCard);
            } else {
                break;
            }

            if (firstCard > secondCard) {
                firstPlayerDeck.add(firstCard);
                firstPlayerDeck.add(secondCard);

            } else if (secondCard > firstCard){
                secondPlayerDeck.add(firstCard);
                secondPlayerDeck.add(secondCard);
            }

        }

        if (firstPlayerDeck.size() < secondPlayerDeck.size()) {
            System.out.println("Second player win!");
        } else if (secondPlayerDeck.size() < firstPlayerDeck.size()) {
            System.out.println("First player win!");
        } else {
            System.out.println("Draw!");
        }
    }
}
