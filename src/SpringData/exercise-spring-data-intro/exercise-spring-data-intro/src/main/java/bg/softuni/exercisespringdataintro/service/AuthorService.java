package bg.softuni.exercisespringdataintro.service;

import bg.softuni.exercisespringdataintro.models.Author;

import java.io.IOException;
import java.util.List;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();

    List<String> findAllAuthorsOrderedByBooksCountDesc();

    List<String> findAllAuthorsNamesWithFirstNamesEndingWith(String endingString);

}
