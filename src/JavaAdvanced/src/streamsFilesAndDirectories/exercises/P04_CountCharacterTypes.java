package JavaAdvanced.src.streamsFilesAndDirectories.exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

public class P04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new FileReader("src/JavaAdvanced/resources/exercises/Exercises Resources/input.txt"));
        PrintWriter out = new PrintWriter("src/JavaAdvanced/resources/exercises/Exercises Resources/output-count-character-types.txt");
        String line = input.readLine();

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;


        while (line != null) {

            for (int i = 0; i < line.length(); i++) {
                char[] currentLine = line.toCharArray();
                char currentSymbol = currentLine[i];


                    if (currentSymbol == '.' || currentSymbol == ',' || currentSymbol == '?' || currentSymbol == '!') {
                        punctuation++;
                    } else if (currentSymbol == 'a' || currentSymbol == 'e' || currentSymbol == 'o' || currentSymbol == 'u' || currentSymbol == 'i') {
                        vowels++;
                    } else if (!Character.isWhitespace(currentSymbol)){
                        consonants++;
                    }

            }
            line = input.readLine();
        }
        out.println("Vowels: " + vowels);
        out.println("Consonants: " + consonants);
        out.println("Punctuation: " + punctuation);

        input.close();
        out.close();
    }
}
