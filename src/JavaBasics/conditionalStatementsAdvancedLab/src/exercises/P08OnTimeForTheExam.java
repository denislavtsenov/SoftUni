package EXERCISES;

import java.util.Scanner;

public class P08OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int hourExam = Integer.parseInt(scan.nextLine());
        int minExam = Integer.parseInt(scan.nextLine());
        int hourArrive = Integer.parseInt(scan.nextLine());
        int minArrive = Integer.parseInt(scan.nextLine());

        int examTime = (hourExam * 60) + minExam;
        int arrivalTime = (hourArrive * 60) + minArrive;
        int diff = Math.abs(examTime - arrivalTime);

        if (examTime < arrivalTime) {
            System.out.println("Late");
            if (diff >= 60) {
                int hour = diff / 60;
                int min = diff % 60;
                System.out.printf("%d:%02d hours after the start", hour, min);
            } else {
                System.out.printf("%d minutes after the start", diff);
            }
        } else if (examTime == arrivalTime || diff <= 30) {
            System.out.println("On time");
            if (diff >= 1 && diff <=30) {
                System.out.printf("%d minutes before the start", diff);
            }
        } else if (diff > 30) {
                System.out.println("Early");
                if (diff >= 60) {
                    int hour = diff / 60;
                    int min = diff % 60;
                    System.out.printf("%d:%02d hours before the start", hour, min);
                } else {
                    System.out.printf("%d minutes before the start", diff);
                }
                }
        }
    }

