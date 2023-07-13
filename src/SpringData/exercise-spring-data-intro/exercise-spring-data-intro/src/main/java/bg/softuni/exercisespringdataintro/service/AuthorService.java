package bg.softuni.exercisespringdataintro.service;

import bg.softuni.exercisespringdataintro.models.Author;
import org.springframework.data.jpa.repository.Query;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> findAllAuthorsOrderedByBooksCountDesc();

    List<String> findAllAuthorsNamesWithFirstNamesEndingWith(String endingString);

    List<String> findAllAuthorsAndTheirTotalCopies();
}
