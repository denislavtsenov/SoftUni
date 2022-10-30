package JavaAdvanced.src.examPreparation.javaAdvancedExam26June2021;

import java.util.*;

public class P01_OS_Planing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasksStack = new ArrayDeque<>();
        ArrayDeque<Integer> threadsQueue = new ArrayDeque<>();

        int[] tasksInput = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < tasksInput.length; i++) {
            tasksStack.push(tasksInput[i]);
        }

        int[] threadsInput = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < threadsInput.length; i++) {
            threadsQueue.offer(threadsInput[i]);
        }

        int killTask = Integer.parseInt(scanner.nextLine());

        int firstValue = tasksStack.peek();
        int secondValue = threadsQueue.peek();

        while (firstValue != killTask) {

            if (secondValue >= firstValue) {
                tasksStack.pop();
                threadsQueue.poll();
            } else {
                threadsQueue.poll();
            }

            firstValue = tasksStack.peek();
            secondValue = threadsQueue.peek();
        }

        System.out.printf("Thread with value %d killed task %d%n", secondValue, killTask );

        List<String> leftThreads = new ArrayList<>();
        while (!threadsQueue.isEmpty()) {
            leftThreads.add(threadsQueue.poll().toString());
        }

        System.out.print(String.join(" ", leftThreads));
    }
}
