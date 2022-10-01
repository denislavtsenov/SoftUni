package Methods.Exercise;

import java.util.Locale;
import java.util.Scanner;

public class P02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String toLowerCase = input.toLowerCase(Locale.ROOT);
        String[] inputArr = toLowerCase.split("");
        System.out.println(printCountVowels(inputArr));

    }

    public static int printCountVowels(String[] input) {
        int countVowels = 0;
        for (int i = 0; i < input.length; i++) {
            String current = input[i];
            switch (current) {
                case "a":
                case "o":
                case "i":
                case "e":
                case "u":
                    countVowels++;
                    break;
            }

        }
        return countVowels;
    }
}