package ProgrammingFundamentalsFinalExam07082022;

import java.util.*;

public class P03_HeroRecruitment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> heroesMap = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("End")) {
            String[] commands = inputLine.split(" ");
            String command = commands[0];
            String heroName = commands[1];
            String spellName = "";

            switch (command) {

                case "Enroll":
                    if (!heroesMap.containsKey(heroName)) {
                        heroesMap.put(heroName, new ArrayList<>());
                    } else {
                        System.out.printf("%s is already enrolled.%n", heroName);
                    }
                    break;

                case "Learn":
                    spellName = commands[2];

                    if (!heroesMap.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else {
                        List<String> currentHeroSpellBook = heroesMap.get(heroName);

                        if (currentHeroSpellBook.contains(spellName)) {
                            System.out.printf("%s has already learnt %s.%n", heroName, spellName);
                        } else {
                            heroesMap.get(heroName).add(spellName);
                        }
                    }
                    break;

                case "Unlearn":
                    spellName = commands[2];
                    if (!heroesMap.containsKey(heroName)) {
                        System.out.printf("%s doesn't exist.%n", heroName);
                    } else {
                        List<String> currentHeroSpellBook = heroesMap.get(heroName);
                        if (currentHeroSpellBook.contains(spellName)) {
                            heroesMap.get(heroName).remove(spellName);
                        } else {
                            System.out.printf("%s doesn't know %s.%n",heroName, spellName);
                        }
                    }
                    break;


            }
            inputLine = scanner.nextLine();
        }

        System.out.println("Heroes:");
        for (Map.Entry<String, List<String>> entry : heroesMap.entrySet()) {
            System.out.printf("== %s: %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }

    }
}
