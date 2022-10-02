package streamsFilesAndDirectories;

import java.io.*;

public class P05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("resources/input.txt"));
        PrintWriter printWriter = new PrintWriter(new FileOutputStream("resources/output-write-every-third-line.txt"));

        int counter = 1;
        String line = bufferedReader.readLine();

        while (line != null) {
            if (counter % 3 == 0) {
                printWriter.println(line);
            }
            counter++;
            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        printWriter.close();
    }
}
