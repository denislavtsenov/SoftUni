package bg.softuni.exercisespringdataintro;

import bg.softuni.exercisespringdataintro.models.*;
import bg.softuni.exercisespringdataintro.repositories.BookRepository;
import bg.softuni.exercisespringdataintro.services.AuthorService;
import bg.softuni.exercisespringdataintro.services.CategoryService;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class ConsoleRunner implements Runnable {

    private final String RESOURCE_PATH = "bg/softuni/exercisespringdataintro/files/";
    private final String BOOKS_FILE_NAME = "books.txt";

    private AuthorService authorService;
    private CategoryService categoryService;
    private BookRepository bookRepository;

    private EntityManager entityManager;

    @Override
    public void run() {

        entityManager.getTransaction().begin();
        try {
            Files.readAllLines(Path.of(RESOURCE_PATH + BOOKS_FILE_NAME))
                    .forEach(row -> {
                        String[] data = row.split("\\s+");
                        Author author = authorService.getRandomAuthor();
                        EditionType editionType =
                                EditionType.values()[Integer.parseInt(data[0])];
                        LocalDate releaseDate = LocalDate.parse(data[1],
                                DateTimeFormatter.ofPattern("d/M/yyyy"));

                        int copies = Integer.parseInt(data[2]);

                        BigDecimal price = new BigDecimal(data[3]);

                        AgeRestriction ageRestriction = AgeRestriction
                                .values()[Integer.parseInt(data[4])];

                        String title = Arrays.stream(data)
                                .skip(5)
                                .collect(Collectors.joining(" "));

                        Set<Category> categories = categoryService.getRandomCategories();

                        Book book = new Book(title, editionType, price, releaseDate,
                                ageRestriction, author, categories, copies);
                        bookRepository.save(book);
                    });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
