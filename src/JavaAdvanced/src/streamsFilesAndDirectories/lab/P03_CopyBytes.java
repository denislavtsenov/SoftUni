package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class P03_CopyBytes {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("resources/input.txt");
        FileOutputStream fos = new FileOutputStream("resources/output-copy-bytes.txt");
        int oneByte = fis.read();

        while (oneByte >= 0) {

            if (oneByte == 10 || oneByte == 32) {
                fos.write((char) oneByte);
            } else {
                String digits = String.valueOf(oneByte);
                for (int i = 0; i < digits.length(); i++) {
                    fos.write(digits.charAt(i));
                }
            }

            oneByte = fis.read();
        }
    }
}
