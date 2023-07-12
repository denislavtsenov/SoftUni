package bg.softuni.exercisespringdataintro.service;

import bg.softuni.exercisespringdataintro.models.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<Book> findAllAuthorsNamesWithBooksBeforeYear(int year);
}
