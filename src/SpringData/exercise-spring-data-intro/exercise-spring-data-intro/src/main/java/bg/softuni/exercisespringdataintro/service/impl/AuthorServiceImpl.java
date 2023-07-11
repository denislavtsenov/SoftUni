package bg.softuni.exercisespringdataintro.service.impl;

import bg.softuni.exercisespringdataintro.models.Author;
import bg.softuni.exercisespringdataintro.repository.AuthorRepository;
import bg.softuni.exercisespringdataintro.service.AuthorService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class AuthorServiceImpl implements AuthorService {

    private static final String AUTHORS_FILE_PATH = "files/authors.txt";
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void seedAuthors() throws IOException {

        if (authorRepository.count() > 0) {
            return;
        }

        File resource = new ClassPathResource(AUTHORS_FILE_PATH).getFile();

        Files.readAllLines(Path.of(resource.toURI()))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {

                    String firstName = row.split(" ")[0];
                    String lastName = row.split(" ")[1];

                    Author author = new Author(firstName, lastName);

                    authorRepository.save(author);
                });
    }

    @Override
    public Author getRandomAuthor() {
        return null;
    }
}
