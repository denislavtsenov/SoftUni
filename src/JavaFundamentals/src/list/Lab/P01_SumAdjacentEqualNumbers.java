package List.Lab;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double firstElement = numbers.get(i);
            double secondElement = numbers.get(i + 1);

            if (firstElement == secondElement) {
                numbers.set(i, firstElement + secondElement);
                numbers.remove(numbers.get(i+1));
                i = -1;
            }

        }
        DecimalFormat df = new DecimalFormat("0.####");
        for (double num : numbers) {
            System.out.printf(df.format(num) + " ");
        }
    }
}