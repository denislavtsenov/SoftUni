package Tasks.excelColumn;

import java.math.BigInteger;
import java.util.Scanner;

public class findExcelColumn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input Number or Letter");
        String input = scanner.nextLine().toUpperCase();

        char firstChar = input.charAt(0);

        if (Character.isDigit(firstChar)) {

            StringBuilder nameOfColumn = new StringBuilder();
            BigInteger inputNum = new BigInteger(input);

            findColumnName(nameOfColumn, inputNum);

            System.out.println(nameOfColumn.reverse());

        } else if (Character.isLetter(firstChar)) {

            BigInteger columnNumber = new BigInteger("0");
            columnNumber = findColumnNumber(input, columnNumber);
            System.out.println(columnNumber);

        } else {
            System.out.println("Wrong input! Try Again.");
        }
    }

    private static void findColumnName(StringBuilder nameOfColumn, BigInteger inputNum) {
        while (inputNum.compareTo(BigInteger.ZERO) > 0) {

            int remainder = inputNum.remainder(BigInteger.valueOf(26)).intValue();
            if (remainder == 0) {
                nameOfColumn.append("Z");
                inputNum = inputNum.divide(BigInteger.valueOf(26)).subtract(BigInteger.ONE);
            } else {
                nameOfColumn.append((char) ((remainder - 1) + 'A'));
                inputNum = inputNum.divide(BigInteger.valueOf(26));
            }
        }
    }

    private static BigInteger findColumnNumber(String input, BigInteger columnNumber) {
        for (int i = 0; i < input.length(); i++) {
            columnNumber = columnNumber.multiply(BigInteger.valueOf(26));
            char ch = input.charAt(i);

            columnNumber = columnNumber.add(BigInteger.valueOf(ch - 'A' + 1));
        }
        return columnNumber;
    }
}
