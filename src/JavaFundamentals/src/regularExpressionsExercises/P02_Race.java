package regularExpressionsExercises;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P02_Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> participantsList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String regexName = "[A-Za-z]+";
        Pattern patternName = Pattern.compile(regexName);

        String regexNum = "[0-9]+?";
        Pattern patternNum = Pattern.compile(regexNum);

        Map<String, Integer> participantsRun = new LinkedHashMap<>();

        String inputLine = scanner.nextLine();
        while (!inputLine.equals("end of race")) {
            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherName = patternName.matcher(inputLine);
            while (matcherName.find()) {
                String current = matcherName.group();
                nameBuilder.append(current);
            }
            Matcher matcherNum = patternNum.matcher(inputLine);
            int sum = 0;
            while (matcherNum.find()) {
                int currentNum = Integer.parseInt(matcherNum.group());
                sum += currentNum;
            }

            if (participantsList.contains(nameBuilder.toString())) {
                if (!participantsRun.containsKey(nameBuilder.toString())) {
                    participantsRun.put(nameBuilder.toString(), sum);
                } else {
                    int value = participantsRun.get(nameBuilder.toString());
                    participantsRun.put(nameBuilder.toString(), value + sum);
                }
            }

                inputLine = scanner.nextLine();
        }
      List<String> firstThreeList = participantsRun.entrySet().stream()
              .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3)
              .map(entry -> entry.getKey())
              .collect(Collectors.toList());

        System.out.println("1st place: " + firstThreeList.get(0));
        System.out.println("2nd place: " + firstThreeList.get(1));
        System.out.println("3rd place: " + firstThreeList.get(2));
    }
}
