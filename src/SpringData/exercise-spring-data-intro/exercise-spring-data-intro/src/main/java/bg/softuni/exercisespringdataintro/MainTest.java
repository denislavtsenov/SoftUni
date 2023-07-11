package bg.softuni.exercisespringdataintro;

import java.nio.file.Path;
import java.nio.file.Paths;

public class MainTest {
    public static void main(String[] args) {

        String filename="categories.txt";
        Path pathToFile = Paths.get(filename);
        System.out.println(pathToFile.toAbsolutePath());
    }
}
