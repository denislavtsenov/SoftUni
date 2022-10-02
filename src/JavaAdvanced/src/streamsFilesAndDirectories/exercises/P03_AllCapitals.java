package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class P03_AllCapitals {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/input.txt"));
        PrintWriter out = new PrintWriter("src/JavaAdvanced/resources/exercises/output.txt");

        String line = input.readLine();

        while (line != null) {
            String currentLine = line.toUpperCase();
            out.println(currentLine);

            line = input.readLine();
        }
        input.close();
        out.close();
    }
}
