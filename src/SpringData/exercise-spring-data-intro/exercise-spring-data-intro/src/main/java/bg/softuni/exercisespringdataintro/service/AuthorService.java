package bg.softuni.exercisespringdataintro.service;

import bg.softuni.exercisespringdataintro.models.Author;

import java.io.IOException;

public interface AuthorService {
    void seedAuthors() throws IOException;

    Author getRandomAuthor();
}
