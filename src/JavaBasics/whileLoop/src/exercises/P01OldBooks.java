package Exercise;

import java.util.Scanner;

public class P01OldBooks {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String book = scan.nextLine();

        String nextBook = scan.nextLine();
        int countBooks = 0;
        while (!nextBook.equals(book)) {
            nextBook = scan.nextLine();
            countBooks++;
            if (nextBook.equals("No More Books")) {
                break;
            }

        }
        if (nextBook.equals("No More Books")) {
            System.out.printf("The book you search is not here!%n");
            System.out.printf("You checked %d books.", countBooks);
        } else {
            System.out.printf("You checked %d books and found it.", countBooks);

        }

    }
}
