package List.MidExams.FundamentalsMidExam29022020;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P03_HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> evenIntegers = Arrays.stream(scanner.nextLine().split("@")).collect(Collectors.toList());

        String input = scanner.nextLine();
        int lastPosition = 0;
        while (!input.equals("Love!")) {
            String[] commands = input.split(" ");
            String command = commands[0];
            int length = Integer.parseInt(commands[1]);
            int currentIndex = length + lastPosition;
            if (currentIndex > evenIntegers.size() - 1) {
                currentIndex = 0;
            }
            lastPosition = currentIndex;

            int currentNum = Integer.parseInt(evenIntegers.get(currentIndex));
            if (currentNum == 0) {
                System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
            } else {
                evenIntegers.set(currentIndex, String.valueOf(currentNum - 2));

                currentNum = Integer.parseInt(evenIntegers.get(currentIndex));
                if (currentNum == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            }


            input = scanner.nextLine();
        }
        System.out.printf("Cupid's last position was %d.%n", lastPosition);

        int count = 0;
        for (int i = 0; i < evenIntegers.size(); i++) {
            int eachHouse = Integer.parseInt(evenIntegers.get(i));
            if (eachHouse == 0) {
                count++;
            }
        }
        if (evenIntegers.size() - count == 0) {
            System.out.println("Mission was successful.");
        } else {
            System.out.printf("Cupid has failed %d places.", evenIntegers.size() - count);
        }
    }
}
