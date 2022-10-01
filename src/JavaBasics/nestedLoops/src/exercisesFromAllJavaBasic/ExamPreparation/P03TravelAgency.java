package ExercisesFromAllJavaBasic.ExamPreparation;

import java.util.Scanner;

public class P03TravelAgency {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String town = scan.nextLine();
        String typePacked = scan.nextLine();
        String vip = scan.nextLine();
        int days = Integer.parseInt(scan.nextLine());

        double sum = 0;

        switch (town) {
            case "Bansko":
            case "Borovets":
                if (typePacked.equals("withEquipment")) {
                    sum = 100;
                    if (vip.equals("yes")) {
                        sum = sum * 0.90;
                    }

                } else if (typePacked.equals("noEquipment")) {
                    sum = 80;
                    if (vip.equals("yes")) {
                        sum = sum * 0.95;
                    }
                }

                break;
            case "Varna":
            case "Burgas":
                if (typePacked.equals("withBreakfast")) {
                    sum = 130;
                    if (vip.equals("yes")) {
                        sum = sum * 0.88;
                    }

                } else if (typePacked.equals("noBreakfast")) {
                    sum = 100;
                    if (vip.equals("yes")) {
                        sum = sum * 0.93;
                    }
                }
                break;
        }
        if (days > 7) {
            days = days - 1;
        }
        double totalSum = sum * days;


        if (days <= 0) {
            System.out.println("Days must be positive number!");
        } else if (((town.equals("Varna")) || (town.equals("Burgas")) || (town.equals("Bansko")) || (town.equals("Borovets"))) && ((typePacked.equals("withBreakfast")) || (typePacked.equals("noBreakfast")) || (typePacked.equals("withEquipment")) || (typePacked.equals("noEquipment")))) {
            System.out.printf("The price is %.2flv! Have a nice time!", totalSum);
        } else {
            System.out.println("Invalid input!");

        }
    }
}


