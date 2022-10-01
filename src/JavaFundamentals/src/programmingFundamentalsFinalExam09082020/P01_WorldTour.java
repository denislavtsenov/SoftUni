package ProgrammingFundamentalsFinalExam09082020;

import java.util.Scanner;

public class P01_WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("Travel")) {
            String command = inputLine.split(":")[0];

            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(inputLine.split(":")[1]);
                    String newString = inputLine.split(":")[2];

                    if (index >= 0 && index < stops.length()) {
                        StringBuilder inputBuilder = new StringBuilder(stops);
                        inputBuilder.insert(index, newString);
                        stops = inputBuilder.toString();
                    }

                    System.out.println(stops);
                    break;

                case "Remove Stop":
                    int startIndex = Integer.parseInt(inputLine.split(":")[1]);
                    int endIndex = Integer.parseInt(inputLine.split(":")[2]);

                    if (startIndex >= 0 && endIndex < stops.length()) {
                        StringBuilder inputBuilder = new StringBuilder(stops);
                        inputBuilder.delete(startIndex, endIndex+1);
                        stops = inputBuilder.toString();
                    }

                    System.out.println(stops);
                    break;

                case "Switch":
                    String oldString = inputLine.split(":")[1];
                    String replaceString = inputLine.split(":")[2];

                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, replaceString);
                    }

                    System.out.println(stops);
                    break;
            }
            inputLine = scanner.nextLine();
        }

        System.out.println("Ready for world tour! Planned stops: " + stops);
    }
}
