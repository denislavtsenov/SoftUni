package JavaAdvanced.src.streamsFilesAndDirectories.lab;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class P06_SortLines {
    public static void main(String[] args) throws IOException {

        String address = "src/JavaAdvanced/resources/input.txt";
        Path path = Paths.get(address);

        List<String> lines = Files.lines(path)
                .sorted()
                .collect(Collectors.toList());


       Files.write(Paths.get("src/JavaAdvanced/resources/output-sort-lines.txt"), lines);

    }
}
