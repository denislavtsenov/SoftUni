package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class P05_LineNumbers {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/Exercises Resources/inputLineNumbers.txt"));

        PrintWriter output = new PrintWriter("src/JavaAdvanced/resources/exercises/Exercises Resources/output-inputLineNumbers.txt");

        String line = input.readLine();
        int counter = 0;
        while (line != null) {
            counter++;
            output.println(counter + ". " + line);

            line = input.readLine();
        }
        input.close();
        output.close();
    }
}
