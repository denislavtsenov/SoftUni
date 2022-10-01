package Exercise;

import java.util.Scanner;

public class P06Cake {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lenght = Integer.parseInt(scan.nextLine());
        int width = Integer.parseInt(scan.nextLine());
        int totalCake = lenght * width;
        int countCake = totalCake;

        String input = scan.nextLine();

        while (!input.equals("STOP")) {
            int piece = Integer.parseInt(input);
            countCake = countCake - piece;

            if (countCake <= 0) {
                break;
            }
            input = scan.nextLine();
        }



        if (countCake <= 0) {
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(countCake));
        } else {
            System.out.printf("%d pieces are left.", Math.abs(countCake));
        }
    }
}

