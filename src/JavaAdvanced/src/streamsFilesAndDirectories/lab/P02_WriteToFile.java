package streamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class P02_WriteToFile {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("resources/input.txt");
        int oneByte = fis.read();

        FileOutputStream fos = new FileOutputStream("resources/output.txt");

        List<Character> punctuation = new ArrayList<Character>() {
            { add(','); add('.'); add('!'); add('?'); }
    };

        while (oneByte >= 0) {
            if (!punctuation.contains((char) oneByte)) {
                fos.write(oneByte);
            }

            oneByte = fis.read();
        }
    }
}
