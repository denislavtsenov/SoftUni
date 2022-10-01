package Exercise;

import java.util.Scanner;

public class P04Walking {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int goalSteps = 10000;
        String command = scan.nextLine();
        int countSteps = 0;

        while (!command.equals("Going home")) {
            int currentSteps = Integer.parseInt(command);
            countSteps = countSteps + currentSteps;

            if (countSteps >= goalSteps) {
                break;
            }

            command = scan.nextLine();
            }

        if (command.equals("Going home")) {
           int goingHomeSteps = Integer.parseInt(scan.nextLine());
           countSteps = countSteps + goingHomeSteps;
        }

            int diff = Math.abs(countSteps - goalSteps);
            if (countSteps >= goalSteps) {
                System.out.println("Goal reached! Good job!");
                System.out.printf("%d steps over the goal!", diff);
            } else {
                System.out.printf("%d more steps to reach goal.", diff);
            }


        }
    }
