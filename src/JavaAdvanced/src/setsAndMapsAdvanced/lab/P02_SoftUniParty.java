package setsAndMapsAdvanced.lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!inputLine.equals("PARTY")) {

            char firstSymbol = inputLine.charAt(0);

            if (Character.isDigit(firstSymbol)) {
                vip.add(inputLine);
            } else {
                regular.add(inputLine);
            }

            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();

        while (!inputLine.equals("END")) {

            if (vip.contains(inputLine)) {
                vip.remove(inputLine);
            } else {
                regular.remove(inputLine);
            }
            inputLine = scanner.nextLine();
        }

        System.out.println(vip.size() + regular.size());
        for (String s : vip) {
            System.out.println(s);
        }

        for (String s : regular) {
            System.out.println(s);
        }
    }
}
