package Arrays.Lab;

import java.util.Scanner;

public class P01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[] days = new String[]{"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int input = Integer.parseInt(scan.nextLine());

        if (input >= 1 && input <= 7) {
            System.out.println(days[input - 1]);
        } else {
            System.out.println("Invalid day!");
        }

    }
}

