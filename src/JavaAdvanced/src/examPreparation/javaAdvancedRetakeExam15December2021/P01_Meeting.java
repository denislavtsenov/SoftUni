package JavaAdvanced.src.examPreparation.javaAdvancedRetakeExam15December2021;

import java.util.*;
import java.util.stream.Collectors;

public class P01_Meeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> mensStack = new ArrayDeque<>();
        ArrayDeque<Integer> womenQueue = new ArrayDeque<>();

        int[] menInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < menInput.length; i++) {
            mensStack.push(menInput[i]);
        }

        int[] womenInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < womenInput.length; i++) {
            womenQueue.offer(womenInput[i]);
        }

        int matches = 0;
        while (!mensStack.isEmpty() && !womenQueue.isEmpty()) {
            int firstValue = mensStack.peek();
            int secondValue = womenQueue.peek();

            if (firstValue <= 0) {
                mensStack.pop();
            } else if (secondValue <= 0) {
                womenQueue.poll();
            } else if (firstValue == secondValue) {
                matches++;

                if (firstValue % 25 == 0) {
                    mensStack.pop();
                    mensStack.pop();
                }
                if (secondValue % 25 == 0) {
                    womenQueue.poll();
                    womenQueue.poll();
                } else {
                    mensStack.pop();
                    womenQueue.poll();
                }
            } else {
                womenQueue.poll();
                int newValue = firstValue - 2;
                mensStack.pop();
                mensStack.push(newValue);
            }




            }


        System.out.printf("Matches: %d%n", matches);

        if (mensStack.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            List<String> menLeft = new ArrayList<>();
            while (!mensStack.isEmpty()){
                menLeft.add(String.valueOf(mensStack.pop()));
            }
            System.out.printf("Males left: ");
            System.out.printf(String.join(", ", menLeft));
            System.out.println();
        }

        if (womenQueue.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            List<String> womenLeft = new ArrayList<>();
            while (!womenQueue.isEmpty()){
                womenLeft.add(String.valueOf(womenQueue.poll()));
            }

            System.out.printf("Females left: ");
            System.out.printf(String.join(", ", womenLeft));
            System.out.println();
        }
    }
}

