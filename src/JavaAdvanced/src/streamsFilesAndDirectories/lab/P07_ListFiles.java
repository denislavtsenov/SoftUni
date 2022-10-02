package JavaAdvanced.src.streamsFilesAndDirectories.lab;

import java.io.File;
import java.util.Arrays;

import static java.io.File.listRoots;

public class P07_ListFiles {
    public static void main(String[] args) {

        File directory = new File("src/JavaAdvanced/resources/Files-and-Streams");

        File[] file = directory.listFiles();

        for (int i = 0; i < file.length; i++) {
            System.out.println(file[i].getName() + ": " + "[" + file[i].length() + "]");
        }
    }
}
