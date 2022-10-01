package ProgrammingFundamentalsFinalExam09082020;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P02_DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputLine = scanner.nextLine();
        int totalPoints = 0;
        List<String> destinationsList = new ArrayList<>();

        String regex = "(=|\\/)(?<destination>[A-Z][A-Za-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            String destination = matcher.group("destination");
            int currentPoints = destination.length();

            destinationsList.add(destination);
            totalPoints += currentPoints;
        }
        System.out.println("Destinations: " + String.join(", ", destinationsList));
        System.out.println("Travel Points: " + totalPoints);
    }
}
