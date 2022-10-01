package DataTypesAndVariables.Exercise;

import java.util.Scanner;

public class P10_PokeMon {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int pokePower = Integer.parseInt(scan.nextLine());
        int initPokePower = pokePower;
        int distance = Integer.parseInt(scan.nextLine());
        int exhaustionFactor = Integer.parseInt(scan.nextLine());

        int pokeCount = 0;
        while (pokePower >= distance) {
            pokePower -= distance;
            pokeCount++;

            if (pokePower == initPokePower / 2) {
                if (exhaustionFactor > 0) {
                    pokePower = pokePower / exhaustionFactor;
                }
            }
        }
        System.out.println(pokePower);
        System.out.println(pokeCount);
    }
}
