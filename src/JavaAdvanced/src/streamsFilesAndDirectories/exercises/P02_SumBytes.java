package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P02_SumBytes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/input.txt"));

        String line = reader.readLine();
        int totalSum = 0;
        while (line != null) {
            for (char c : line.toCharArray()) {
                totalSum += c;
            }
            line = reader.readLine();
        }
        System.out.println(totalSum);
    }
}
