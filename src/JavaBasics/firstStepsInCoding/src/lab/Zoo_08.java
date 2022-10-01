import java.util.Scanner;

public class Zoo_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        int dog = Integer.parseInt(scanner.nextLine());
        int cat = Integer.parseInt(scanner.nextLine());
        double foodprice1 = dog * 2.50;
        double foodprice2 = cat * 4;
        System.out.println(foodprice1 + foodprice2);
    }
}
