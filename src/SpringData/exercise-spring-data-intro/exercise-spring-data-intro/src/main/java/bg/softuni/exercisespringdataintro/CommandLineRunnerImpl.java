package bg.softuni.exercisespringdataintro;

import bg.softuni.exercisespringdataintro.models.Book;
import bg.softuni.exercisespringdataintro.service.AuthorService;
import bg.softuni.exercisespringdataintro.service.BookService;
import bg.softuni.exercisespringdataintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Scanner;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;

    private final BookService bookService;

    private final Scanner scanner;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {

        seedData();

        //Exercises: Spring Data Intro

//      printAllBooksAfterYear(2000);

//      printAuthorsNamesWithBooksBeforeYear(1990);

//      printAllAuthorsOrderedByBooksCountDesc();

//      printAllBooksFromAuthorOrderByReleaseDateDescAndBookTitleAsc("George Powell");

        //Exercises: Spring Data Advanced Querying

        System.out.println("Choose a task:");
        int taskNum = Integer.parseInt(scanner.nextLine());

        selectTaskNumber(taskNum);
    }

    private void selectTaskNumber(int taskNum) {
        switch (taskNum) {
            case 1:
                System.out.println("Choose age restriction (minor, teen or adult):");
                String ageRestriction = scanner.nextLine();

                printAllBooksTitlesByAgeRestriction(ageRestriction);
                break;
            case 2:
                System.out.println("Write edition type (normal, promo or gold):");
                String editionType = scanner.nextLine();

                printAllBookTitlesByEditionTypeWithLessThan5000Copies(editionType);
                break;
            case 3:
                printAllBookTitlesAndPricesWithPriceLowerThan5AndHigherThan40();
                break;
            case 4:
                System.out.println("Write year of release to ignore:");
                int year = Integer.parseInt(scanner.nextLine());

                printAllBookTitlesNotReleasedInYear(year);
                break;
            case 5:
                System.out.println("Write date in format dd-mm-yyyy");
                String date = scanner.nextLine();

                printAllBooksTitleEditionTypePriceReleasedBeforeDate(date);
                break;
            case 6:
                System.out.println("Write ending string");
                String endingString = scanner.nextLine();

                printAllAuthorsNamesWhoseFirstNameEndsWithString(endingString);
                break;
            case 7:
                System.out.println("Write a string to search for a book:");
                String input = scanner.nextLine();

                printAllBooksTitlesWhichContainGivenString(input);
                break;
            case 8:
                System.out.println("Write a string to search for an author lastname");
                String inputString = scanner.nextLine();

                printAllBooksTitlesWithAuthorLastNameStartsWithGivenString(inputString);
                break;
            case 9:
                System.out.println("Write number to check books with longer title:");
                int number = Integer.parseInt(scanner.nextLine());

                printAllBooksTitlesWhichHaveLengthMoreThanGivenNumber(number);

        }
    }

    private void printAllBooksTitlesWhichHaveLengthMoreThanGivenNumber(int number) {
        Long countOfBooks = bookService.findAllBooksTitlesWithLengthMoreThanGivenNumber(number);
        System.out.println(countOfBooks);
    }

    private void printAllBooksTitlesWithAuthorLastNameStartsWithGivenString(String inputString) {
        bookService.findAllBooksWithAuthorLastNameStartsWithGivenString(inputString)
                .forEach(System.out::println);
    }

    private void printAllBooksTitlesWhichContainGivenString(String input) {
        bookService.findAllBooksTitlesThatContainsGivenString(input)
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWhoseFirstNameEndsWithString(String endingString) {
        authorService.findAllAuthorsNamesWithFirstNamesEndingWith(endingString)
                .forEach(System.out::println);
    }

    private void printAllBooksTitleEditionTypePriceReleasedBeforeDate(String date) {
        bookService.findAllBooksReleasedBeforeDate(date)
                .forEach(System.out::println);
    }

    private void printAllBookTitlesNotReleasedInYear(int year) {
        bookService.findAllBookTitlesNotReleasedInYear(year)
                .forEach(System.out::println);
    }

    private void printAllBookTitlesAndPricesWithPriceLowerThan5AndHigherThan40() {
        bookService.findAllBookTitlesWithPriceLowerThan5AndHigherThan40()
                .forEach(System.out::println);
    }

    private void printAllBookTitlesByEditionTypeWithLessThan5000Copies(String editionType) {
        bookService.findAllBookTitlesByEditionTypeWithLessThan5000Copies(editionType)
                .forEach(System.out::println);
    }

    private void printAllBooksTitlesByAgeRestriction(String ageRestriction) {
        bookService.findAllBooksWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void printAllBooksFromAuthorOrderByReleaseDateDescAndBookTitleAsc(String authorName) {
        bookService.findAllBooksByAuthorNameOrderByReleaseDateDescTitleAsc(authorName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsOrderedByBooksCountDesc() {
        authorService.findAllAuthorsOrderedByBooksCountDesc()
                .stream()
                .forEach(System.out::println);
    }

    private void printAuthorsNamesWithBooksBeforeYear(int year) {
        bookService
                .findAllAuthorsNamesWithBooksBeforeYear(year)
                .stream()
                .forEach(book -> {
                    String authorFirstName = book.getAuthor().getFirstName();
                    String authorLastName = book.getAuthor().getLastName();

                    System.out.printf("%s %s%n", authorFirstName, authorLastName);
                });
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
