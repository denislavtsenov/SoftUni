package Exercise;

import java.util.Scanner;

public class P07Moving {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int width = Integer.parseInt(scan.nextLine());
        int length = Integer.parseInt(scan.nextLine());
        int height = Integer.parseInt(scan.nextLine());
        int totalFreeSpace = width * length * height;

        int freeSpace = totalFreeSpace;
        int boxSpace = 0;

        String command = scan.nextLine();

        while (!command.equals("Done")) {
            int countBoxes = Integer.parseInt(command);
            boxSpace = boxSpace + countBoxes;

            freeSpace = freeSpace - countBoxes;
            if (freeSpace <= 0) {
                break;
            }
            command = scan.nextLine();
        }
        int diff = Math.abs(totalFreeSpace - boxSpace);
        if (freeSpace <= 0) {
            System.out.printf("No more free space! You need %d Cubic meters more.", diff);
        } else {
            System.out.printf("%d Cubic meters left.", diff);
        }
    }
}
