package JavaAdvanced.src.definingClasses.pokemonTrainer;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();

        while (!inputLine.equals("Tournament")) {
            String[] inputInfo = inputLine.split("\\s+");
            String trainerName = inputInfo[0];
            String pokemonName = inputInfo[1];
            String pokemonElement = inputInfo[2];
            int pokemonHealth = Integer.parseInt(inputInfo[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            trainers.putIfAbsent(trainerName, new Trainer());
            trainers.get(trainerName).addPokemon(pokemon);

            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();

        while (!inputLine.equals("End")) {

            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                if (entry.getValue().pokeCollectionSize() > 0) {
                    boolean havePokemon = false;

                    for (Pokemon pokemon : entry.getValue().getPokemons()) {
                        if (pokemon.getElement().equals(inputLine)) {
                            havePokemon = true;
                            entry.getValue().setNumOfBadges();
                            break;
                        }
                    }

                    if (!havePokemon) {
                        entry.getValue().missingPokemonPenalty();
                    }
                }
            }

            inputLine = scanner.nextLine();
        }

        trainers.entrySet().stream()
                .sorted((b1, b2) -> Integer.compare(b2.getValue().getNumbersOfBadges(), b1.getValue().getNumbersOfBadges()))
                .forEach(t -> {
                    System.out.println(String.format("%s %s %s", t.getKey(),
                            t.getValue().getNumbersOfBadges(),
                            t.getValue().pokeCollectionSize()));
                });
    }
}
