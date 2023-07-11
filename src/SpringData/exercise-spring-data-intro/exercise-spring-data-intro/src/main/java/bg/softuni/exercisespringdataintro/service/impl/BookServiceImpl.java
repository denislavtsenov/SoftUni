package bg.softuni.exercisespringdataintro.service.impl;

import bg.softuni.exercisespringdataintro.models.*;
import bg.softuni.exercisespringdataintro.repository.BookRepository;
import bg.softuni.exercisespringdataintro.service.AuthorService;
import bg.softuni.exercisespringdataintro.service.BookService;
import bg.softuni.exercisespringdataintro.service.CategoryService;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "files/books.txt";

    private final BookRepository bookRepository;
    private final AuthorService authorService;
    private final CategoryService categoryService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService, CategoryService categoryService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
        this.categoryService = categoryService;
    }


    @Override
    public void seedBooks() throws IOException {

        if (bookRepository.count() > 0) {
            return;
        }

        File file = new ClassPathResource(BOOKS_FILE_PATH).getFile();

        Files.readAllLines(Path.of(file.toURI()))
                .stream()
                .filter(row -> !row.isEmpty())
                .forEach(row -> {

                    String[] data = row.split("\\s+");

                    Author author = authorService.getRandomAuthor();

                    EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];

                    LocalDate releaseDate = LocalDate.parse(data[1],
                            DateTimeFormatter.ofPattern("d/M/yyyy"));

                    int copies = Integer.parseInt(data[2]);

                    BigDecimal price = new BigDecimal(data[3]);

                    AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];

                    String title = Arrays.stream(data)
                            .skip(5)
                            .collect(Collectors.joining(" "));

                    Set<Category> categories = categoryService.getRandomCategories();

                    boolean isBookExist = isBookExist(title);

                    if (!isBookExist) {
                        Book book = new Book(title, editionType, price, releaseDate, ageRestriction, author, categories, copies);
                        bookRepository.save(book);
                    }
                });

    }

    private boolean isBookExist(String title) {
        boolean isBookExist = false;
        List<Book> bookList = bookRepository.findAll();

        for (Book book : bookList) {
            if (Objects.equals(book.getTitle(), title)) {
                isBookExist = true;
                break;
            }
        }
        return isBookExist;
    }
}
