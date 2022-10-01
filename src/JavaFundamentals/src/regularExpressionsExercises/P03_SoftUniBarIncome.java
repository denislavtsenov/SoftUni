package regularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03_SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<quantity>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Map<String, Double>> shopping = new LinkedHashMap<>();
        double totalSum = 0;

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end of shift")) {
            Matcher matcher = pattern.matcher(inputLine);
            Map<String, Double> currentShoopingList = new LinkedHashMap<>();
            while (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));
                double currentSum = quantity * price;
                currentShoopingList.put(product, currentSum);

                shopping.put(name, currentShoopingList);
                totalSum += currentSum;
                System.out.printf("%s: %s - %.2f%n", name, product, currentSum);
            }
            inputLine = scanner.nextLine();
        }
        System.out.printf("Total income: %.2f", totalSum);
    }
}
