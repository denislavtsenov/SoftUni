package BasicSyntaxConditionalStatementsAndLoops.LAB.Exercise;

import java.util.Scanner;

public class P06_StrongNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = Integer.parseInt(scan.nextLine());
        int startNum = num;
        int sumFact = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            int fact = 1;
            for (int i = 1; i <= lastDigit; i++) {
                fact = fact * i;
            }
            sumFact += fact;
            num = num / 10;
        }
        if (startNum == sumFact) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
