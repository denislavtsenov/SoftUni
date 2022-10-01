package List.Lab;

import java.util.*;
import java.util.concurrent.locks.Condition;

public class P06_ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<String> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            products.add(i, input);

        }

        Collections.sort(products);
        for (int i = 0; i < products.size(); i++) {
            String currentProduct = products.get(i);
            System.out.printf("%d.%s%n", i + 1, currentProduct);
        }
    }
}

