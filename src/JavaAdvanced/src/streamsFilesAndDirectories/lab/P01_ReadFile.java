package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;

public class P01_ReadFile {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("resources/input.txt");

        int oneByte = fileInputStream.read();

        while (oneByte >= 0) {

            System.out.printf("%s ", Integer.toBinaryString(oneByte));

            oneByte = fileInputStream.read();
        }
    }
}
