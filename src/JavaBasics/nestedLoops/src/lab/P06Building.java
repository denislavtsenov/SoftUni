package LAB;

import java.util.Scanner;

public class P06Building {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int floors = Integer.parseInt(scan.nextLine());
        int rooms = Integer.parseInt(scan.nextLine());

        for (int floor = floors; floor > 0 ; floor--) {
            for (int room = 0; room < rooms ; room++) {

                if (floor == floors) {
                    System.out.print("L" + floor + room + " ");
                } else if(floor % 2 == 0) {
                    System.out.print("O" + floor + room + " ");
                } else {
                    System.out.print("A" + floor + room + " ");
                }

            }
            System.out.println("");
        }
    }
}
