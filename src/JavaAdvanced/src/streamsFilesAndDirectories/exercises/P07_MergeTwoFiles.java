package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.*;

public class P07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        BufferedReader firstInput = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/inputOne.txt"));

        BufferedReader secondInput = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/inputTwo.txt"));
        PrintWriter output = new PrintWriter(new FileWriter("src/JavaAdvanced/resources/exercises/output-merge-files.txt", true));

        String firstInputLine = firstInput.readLine();
        while (firstInputLine != null) {
            output.println(firstInputLine);

            firstInputLine = firstInput.readLine();
        }

        String secondInputLine = secondInput.readLine();
        while (secondInputLine != null) {

            output.println(secondInputLine);

            secondInputLine = secondInput.readLine();
        }

        firstInput.close();
        secondInput.close();
        output.close();
    }
}
