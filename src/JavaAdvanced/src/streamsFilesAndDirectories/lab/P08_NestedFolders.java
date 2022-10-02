package JavaAdvanced.src.streamsFilesAndDirectories.lab;

import java.io.File;
import java.util.ArrayDeque;

public class P08_NestedFolders {
    public static void main(String[] args) {

        File folder = new File("src/JavaAdvanced/resources/Files-and-Streams");


        ArrayDeque<File> directories = new ArrayDeque<>();
        directories.offer(folder);

        int counter = 0;

        while (!directories.isEmpty()) {
            File current = directories.poll();
            File[] folders = current.listFiles();

            for (File file : folders) {
                if (file.isDirectory()) {
                    directories.offer(file);
                    System.out.println(file.getName());
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
