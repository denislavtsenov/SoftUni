package ProgrammingFundamentalsFinalExam04042020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        String regex = "@#+(?<barcode>[A-Z][A-Za-z0-9]{4,}[A-Z])@#+";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            Matcher matcher = pattern.matcher(inputLine);

            if (matcher.find()) {
                int count = 0;
                StringBuilder barcodeDigits = new StringBuilder();

                for (int j = 0; j < inputLine.length(); j++) {
                    char currentSymbol = inputLine.charAt(j);
                    if (Character.isDigit(currentSymbol)) {
                        count++;
                        barcodeDigits.append(currentSymbol);
                    }
                }
                if (count > 0) {
                    System.out.println("Product group: " + barcodeDigits);
                } else {
                    System.out.println("Product group: 00");
                }

            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}