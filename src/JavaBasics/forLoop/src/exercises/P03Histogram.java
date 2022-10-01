package EXERCISE;

import java.util.Scanner;

public class P03Histogram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int p4 = 0;
        int p5 = 0;

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scan.nextLine());

            if (num < 200) {
                p1++;
            } else if (num <= 399) {
                p2++;
            } else if (num <= 599) {
                p3++;

            } else if (num <= 799) {
                p4++;

            } else {
                p5++;
            }
        }

        System.out.printf("%.2f%%%n", p1 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p2 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p3 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p4 * 1.0 / n * 100);
        System.out.printf("%.2f%%%n", p5 * 1.0 / n * 100);



        }
    }

