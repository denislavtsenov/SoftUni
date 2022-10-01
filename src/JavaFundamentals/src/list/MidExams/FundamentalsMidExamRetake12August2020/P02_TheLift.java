package List.MidExams.FundamentalsMidExamRetake12August2020;

import java.util.Arrays;
import java.util.Scanner;

public class P02_TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int waitingForLift = Integer.parseInt(scanner.nextLine());
        int[] lift = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int maxPeople = 4;
        for (int i = 0; i < lift.length; i++) {
            int currentWagon = lift[i];

            if (currentWagon >= maxPeople) {
                continue;
            } else {
                int spacesAvailable = maxPeople - currentWagon;
                if (waitingForLift < spacesAvailable) {
                    spacesAvailable = waitingForLift;
                }
                currentWagon += spacesAvailable;
                lift[i] = currentWagon;

                waitingForLift = waitingForLift - spacesAvailable;
                if (waitingForLift <= 0) {
                    break;
                }
            }
        }
        boolean isEmpty = false;
        for (int i = 0; i < lift.length; i++) {
            if (lift[i] < 4) {
                isEmpty = true;
            }
        }
        String[] liftStringArray = Arrays.stream(lift)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        if (waitingForLift == 0 && isEmpty) {
            System.out.println("The lift has empty spots!");
            System.out.println(String.join(" ", liftStringArray));
        } else if (waitingForLift == 0 && !isEmpty) {
            System.out.println(String.join(" ", liftStringArray));
        } else {
            System.out.printf("There isn't enough space! %d people in a queue!%n", waitingForLift);
            System.out.println(String.join(" ", liftStringArray));



        }

    }
}
