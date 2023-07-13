package bg.softuni.exercisespringdataintro.service.impl;

import bg.softuni.exercisespringdataintro.models.Author;
import bg.softuni.exercisespringdataintro.models.Book;
import bg.softuni.exercisespringdataintro.repository.AuthorRepository;
import bg.softuni.exercisespringdataintro.service.AuthorService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

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
        final long count = this.authorRepository.count();

        if (count != 0) {
            long randomId = new Random().nextLong(1L, count) + 1L;
            return this.authorRepository.findById(randomId).orElseThrow(NoSuchElementException::new);
        }

        throw new RuntimeException();
    }

    @Override
    public List<String> findAllAuthorsOrderedByBooksCountDesc() {
        return authorRepository
                .findAllByBooksSizeOrderDesc()
                .stream()
                .map(author -> String.format("%s %s %d",
                        author.getFirstName(), author.getLastName(), author.getBooks().size()))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> findAllAuthorsNamesWithFirstNamesEndingWith(String endingString) {
        return authorRepository
                .findAllByFirstNameEndingWith(endingString)
                .stream()
                .map(author -> String.format("%s %s",
                        author.getFirstName(), author.getLastName()))
                .collect(Collectors.toList());
    }
}
