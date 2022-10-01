import java.util.Scanner;

public class YardGreening_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double yard = Double.parseDouble(scanner.nextLine());
        double price = 7.61 * yard;
        double discount = price * 0.18;
        double total = price - discount;
        System.out.println("The final price is: "  + (total) + " lv.");
        System.out.println("The discount is: " +  (discount) +  " lv.");

    }
}
