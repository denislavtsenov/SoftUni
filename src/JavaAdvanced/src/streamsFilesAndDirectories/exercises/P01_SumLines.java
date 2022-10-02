package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class P01_SumLines {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/input.txt"));

        String line = reader.readLine();

        while (line != null) {
            int sum = 0;
            for (char c : line.toCharArray()) {
                sum += c;
            }
            System.out.println(sum);
            line = reader.readLine();
        }

    }
}

