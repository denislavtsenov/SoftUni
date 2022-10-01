package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class P04_ExtractIntegers {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("resources\\input.txt"));

        PrintWriter printWriter = new PrintWriter(new FileOutputStream("resources/output-extract-integers.txt"));

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                printWriter.println(scanner.nextInt());
            }
            scanner.next();
        }

        printWriter.close();
    }
}
