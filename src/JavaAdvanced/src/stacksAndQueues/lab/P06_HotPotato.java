package stacksAndQueues.lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] kids = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> kidsQueue = new ArrayDeque<>();

        Collections.addAll(kidsQueue, kids);

        while (kidsQueue.size() > 1) {
            for (int i = 1; i < n; i++) {
                kidsQueue.offer(kidsQueue.poll());
            }
            System.out.println("Removed " + kidsQueue.poll());
        }
        System.out.println("Last is " + kidsQueue.poll());
    }
}
