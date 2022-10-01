package List.MidExams.FundamentalsMidExam2662022;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_SchoolLibrary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shelfBooks = Arrays.stream(scanner.nextLine().split("&")).collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Done")) {

            String[] commands = input.split("\\|");
            String command = commands[0].trim();
            String bookName = commands[1].trim();

            switch (command) {
                case "Add Book":
                    if (!shelfBooks.contains(bookName)) {
                        shelfBooks.add(0, bookName);
                    }

                    break;

                case "Take Book":

                    if (shelfBooks.contains(bookName)) {
                        shelfBooks.remove(bookName);
                    }

                    break;

                case "Swap Books":
                    String firstBook = commands[1].trim();
                    String secondBook = commands[2].trim();

                    if (shelfBooks.contains(firstBook) && shelfBooks.contains(secondBook)) {
                        int indexFirstBook = shelfBooks.indexOf(firstBook);
                        int indexSecondBook = shelfBooks.indexOf(secondBook);

                        shelfBooks.set(indexFirstBook, secondBook);
                        shelfBooks.set(indexSecondBook, firstBook);

                    }

                    break;

                case "Insert Book":

                    if (!shelfBooks.contains(bookName)) {
                        shelfBooks.add(bookName);
                    }

                    break;

                case "Check Book":
                    int checkIndex = Integer.parseInt(commands[1].trim());
                    if (checkIndex >= 0 && checkIndex < shelfBooks.size()) {
                        String nameOfBook = shelfBooks.get(checkIndex);
                        System.out.println(nameOfBook);
                    }
                    break;
            }
            input = scanner.nextLine();
        }

        System.out.println(String.join(", ", shelfBooks));
    }
}
