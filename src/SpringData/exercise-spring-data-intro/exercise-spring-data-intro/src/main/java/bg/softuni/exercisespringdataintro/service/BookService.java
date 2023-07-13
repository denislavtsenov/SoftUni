package bg.softuni.exercisespringdataintro.service;

import bg.softuni.exercisespringdataintro.models.Book;

import java.io.IOException;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<Book> findAllAuthorsNamesWithBooksBeforeYear(int year);

    List<String> findAllBooksByAuthorNameOrderByReleaseDateDescTitleAsc(String authorName);

    List<String> findAllBooksWithAgeRestriction(String ageRestriction);

    List<String> findAllBookTitlesByEditionTypeWithLessThan5000Copies(String editionType);


    List<String> findAllBookTitlesWithPriceLowerThan5AndHigherThan40();

    List<String> findAllBookTitlesNotReleasedInYear(int year);

    List<String> findAllBooksReleasedBeforeDate(String date);

    List<String> findAllBooksTitlesThatContainsGivenString(String input);

    List<String> findAllBooksWithAuthorLastNameStartsWithGivenString(String inputString);

    Long findAllBooksTitlesWithLengthMoreThanGivenNumber(int number);

    String findBookByTitle(String title);
}
