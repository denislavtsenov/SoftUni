package EXERCISES;

import java.util.Scanner;

public class P03NewHouse {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String flowers = scan.nextLine();
        int countFlowers = Integer.parseInt(scan.nextLine());
        int budget = Integer.parseInt(scan.nextLine());

        double totalPrice = 0;

        switch (flowers) {
            case "Roses":
                totalPrice = countFlowers * 5.00;
                if (countFlowers > 80) {
                    totalPrice = totalPrice * 0.90;
                }
                break;

            case "Dahlias":
                totalPrice = countFlowers * 3.80;
                if (countFlowers > 90) {
                    totalPrice = totalPrice * 0.85;
                }
                break;

            case "Tulips":
                totalPrice = countFlowers * 2.80;
                if (countFlowers > 80) {
                    totalPrice = totalPrice * 0.85;
                }
                break;

            case "Narcissus":
                totalPrice = countFlowers * 3.00;
                if (countFlowers < 120) {
                    totalPrice = totalPrice * 1.15;
                }
                break;

            case "Gladiolus":
                totalPrice = countFlowers * 2.50;
                if (countFlowers < 80) {
                    totalPrice = totalPrice * 1.20;
                }
                break;
        }
                double diff = Math.abs(budget - totalPrice);

                    if (budget >= totalPrice) {
                        System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", countFlowers, flowers, diff );
                    } else {
                        System.out.printf("Not enough money, you need %.2f leva more.", diff);
                    }
        }
        }


