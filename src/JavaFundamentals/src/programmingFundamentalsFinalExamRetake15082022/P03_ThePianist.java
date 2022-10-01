package ProgrammingFundamentalsFinalExamRetake15082020;

import java.util.*;

public class P03_ThePianist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> pieces = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            String piece = inputLine.split("\\|")[0];
            String composer = inputLine.split("\\|")[1];
            String tone = inputLine.split("\\|")[2];

            pieces.put(piece, new ArrayList<>());
            pieces.get(piece).add(0, composer);
            pieces.get(piece).add(1, tone);


        }

        String commands = scanner.nextLine();
        while (!commands.equals("Stop")) {
            String command = commands.split("\\|")[0];
            String piece = commands.split("\\|")[1];

            switch (command) {

                case "Add":
                    String composer = commands.split("\\|")[2];
                    String tone = commands.split("\\|")[3];

                    if (!pieces.containsKey(piece)) {
                        pieces.put(piece, new ArrayList<>());
                        pieces.get(piece).add(0, composer);
                        pieces.get(piece).add(1, tone);

                        System.out.printf("%s by %s in %s added to the collection!%n", piece, composer, tone);
                    } else {
                        System.out.println(piece + " is already in the collection!");
                    }
                    break;

                case "Remove":
                    if (pieces.containsKey(piece)) {
                        pieces.remove(piece);
                        System.out.printf("Successfully removed %s!%n", piece);
                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

                case "ChangeKey":
                    String newTone = commands.split("\\|")[2];

                    if (pieces.containsKey(piece)) {
                        pieces.get(piece).remove(1);
                        pieces.get(piece).add(1, newTone);

                        System.out.printf("Changed the key of %s to %s!%n", piece, newTone);

                    } else {
                        System.out.printf("Invalid operation! %s does not exist in the collection.%n", piece);
                    }
                    break;

            }
            commands = scanner.nextLine();
        }


        for (Map.Entry<String, List<String>> entry : pieces.entrySet()) {
            System.out.printf("%s -> Composer: %s, Key: %s%n", entry.getKey(), entry.getValue().get(0), entry.getValue().get(1));
        }

    }
}
