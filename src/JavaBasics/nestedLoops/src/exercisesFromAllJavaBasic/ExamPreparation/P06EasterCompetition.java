package ExercisesFromAllJavaBasic.ExamPreparation;

import java.util.Scanner;

public class P06EasterCompetition {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int easterBread = Integer.parseInt(scan.nextLine());
        int totalPoints = 0;
        int maxPoints = 0;
        String champion = "";

        for (int i = 1; i <= easterBread; i++) {
            String name = scan.nextLine();


            totalPoints = 0;

            String input = scan.nextLine();
            while (!input.equals("Stop")) {
                int grade = Integer.parseInt(input);
                totalPoints = totalPoints + grade;

                input = scan.nextLine();
                if (input.equals("Stop")) {
                    System.out.printf("%s has %d points.%n", name, totalPoints);
                    if (totalPoints > maxPoints) {
                        maxPoints = totalPoints;
                        champion = name;

                        System.out.printf("%s is the new number 1!%n", champion);
                    }
                }
            }

        }
            System.out.printf("%s won competition with %d points!", champion, maxPoints);
        }

    }


