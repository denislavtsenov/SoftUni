package BasicSyntaxConditionalStatementsAndLoops.LAB.Exercise;

import java.util.Scanner;

public class P03_Vacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int group = Integer.parseInt(scan.nextLine());
        String type = scan.nextLine();
        String day = scan.nextLine();

        double price = 0;
        if (type.equals("Students")) {
            if (day.equals("Friday")) {
                price = 8.45;
            } else if (day.equals("Saturday")) {
                price = 9.80;
            } else if (day.equals("Sunday")) {
                price = 10.46;
            }
            if (group >= 30) {
                price = price * 0.85;
            }
        } else if (type.equals("Business")) {
            if (day.equals("Friday")) {
                price = 10.90;
            } else if (day.equals("Saturday")) {
                price = 15.60;
            } else if (day.equals("Sunday")) {
                price = 16;
            }
            if (group >= 100) {
                group = group - 10;
            }

        } else if (type.equals("Regular")) {
            if (day.equals("Friday")) {
                price = 15;
            } else if (day.equals("Saturday")) {
                price = 20;
            } else if (day.equals("Sunday")) {
                price = 22.50;
            }
            if (group >= 10 && group <= 20) {
                price = price * 0.95;
            }
        }
        double sum = group * price;
        System.out.printf("Total price: %.2f", sum);
        }
    }

