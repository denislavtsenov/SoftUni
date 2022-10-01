package ProgrammingFundamentalsFinalExam04042020;

import java.util.*;

public class P03_HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Integer>> heroesMap = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] heroesToken = scanner.nextLine().split(" ");
            String heroName = heroesToken[0];
            int heroHp = Integer.parseInt(heroesToken[1]);
            int heroMp = Integer.parseInt(heroesToken[2]);

            heroesMap.putIfAbsent(heroName, new ArrayList<>());
            heroesMap.get(heroName).add(0, heroHp);
            heroesMap.get(heroName).add(1, heroMp);

        }
        String inputLine = scanner.nextLine();
        while (!inputLine.equals("End")) {

            String[] commands = inputLine.split(" - ");
            String command = commands[0];
            String heroName = commands[1];

            int heroHp = heroesMap.get(heroName).get(0);
            int heroMp = heroesMap.get(heroName).get(1);

            switch (command) {

                case "CastSpell":
                    int neededMp = Integer.parseInt(commands[2]);
                    String spellName = commands[3];

                    if (heroMp >= neededMp) {
                        heroesMap.get(heroName).set(1, heroMp - neededMp);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, heroMp - neededMp);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }

                    break;

                case "TakeDamage":
                    int damage = Integer.parseInt(commands[2]);
                    String attackerName = commands[3];

                    int reducedHp = heroHp - damage;
                    heroesMap.get(heroName).set(0, reducedHp);

                    if (reducedHp > 0) {
                        System.out.printf("%s was hit for %d HP by %s and now has %s HP left!%n", heroName, damage, attackerName, reducedHp);
                    } else {
                        heroesMap.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attackerName);
                    }
                    break;

                case "Recharge":
                    int amount = Integer.parseInt(commands[2]);
                    int increasedMp = heroMp + amount;
                    int diff = amount;

                    if (increasedMp > 200) {
                        increasedMp = 200;
                        diff = 200 - heroMp;
                    }

                    heroesMap.get(heroName).set(1, increasedMp);
                    System.out.printf("%s recharged for %d MP!%n", heroName, diff);

                    break;

                case "Heal":
                    int healAmount = Integer.parseInt(commands[2]);
                    int increasedHp = heroHp + healAmount;
                    int diffAmount = healAmount;

                    if (increasedHp > 100) {
                        increasedHp = 100;
                        diffAmount = 100 - heroHp;
                    }

                    heroesMap.get(heroName).set(0, increasedHp);
                    System.out.printf("%s healed for %d HP!%n", heroName, diffAmount);


                    break;
            }


            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, List<Integer>> entry : heroesMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("  HP: " + entry.getValue().get(0));
            System.out.println("  MP: " + entry.getValue().get(1));
        }

    }
}
