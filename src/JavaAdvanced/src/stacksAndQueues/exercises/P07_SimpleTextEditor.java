package stacksAndQueues.exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07_SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split("\\s+");
            String previousText = null;
            switch (commands[0]) {

                case "1":
                    stack.push(text.toString());
                    String newText = commands[1];
                    text.append(newText);
                    break;

                case "2":
                    stack.push(text.toString());
                    int count = Integer.parseInt(commands[1]);
                    for (int j = 0; j < count; j++) {
                        text.deleteCharAt(text.length() - 1);
                    }
                    break;

                case "3":
                    int index = Integer.parseInt(commands[1]);
                    System.out.println(text.charAt(index - 1));
                    break;

                case "4":
                    String textFromStack = stack.pop();
                    text = new StringBuilder(textFromStack);
                    break;

            }
        }
    }
}
