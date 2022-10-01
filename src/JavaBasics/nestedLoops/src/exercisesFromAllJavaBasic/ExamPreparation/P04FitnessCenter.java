package ExercisesFromAllJavaBasic.ExamPreparation;

import java.util.Scanner;

public class P04FitnessCenter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int countPeople = Integer.parseInt(scan.nextLine());

        double countBack = 0;
        double countChest = 0;
        double countLegs = 0;
        double countAbs = 0;
        double countProteinShake = 0;
        double countProteinBar = 0;
        double countTraining = 0;
        double countBuying = 0;

        for (int i = 1; i <= countPeople ; i++) {
            String move = scan.nextLine();

            switch (move) {
                case "Back":
                    countBack++;
                    countTraining++;
                    break;
                case "Chest":
                    countChest++;
                    countTraining++;
                    break;
                case "Legs":
                    countLegs++;
                    countTraining++;
                    break;
                case "Abs":
                    countAbs++;
                    countTraining++;
                    break;
                case "Protein shake":
                    countProteinShake++;
                    countBuying++;
                    break;
                case "Protein bar":
                    countProteinBar++;
                    countBuying++;
                    break;
            }
        }
            System.out.printf("%.0f - back%n", countBack);
            System.out.printf("%.0f - chest%n", countChest);
            System.out.printf("%.0f - legs%n", countLegs);
            System.out.printf("%.0f - abs%n", countAbs);
            System.out.printf("%.0f - protein shake%n", countProteinShake);
            System.out.printf("%.0f - protein bar%n", countProteinBar);
            System.out.printf("%.2f%% - work out%n", countTraining / countPeople * 100);
            System.out.printf("%.2f%% - protein%n", countBuying / countPeople * 100);
        }
    }

