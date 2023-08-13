package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.BookImportDto;
import softuni.exam.models.entity.Book;
import softuni.exam.repository.BookRepository;
import softuni.exam.service.BookService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.models.entity.Constants.*;

@Service
public class BookServiceImpl implements BookService {

    private static String BOOKS_FILE_PATH = "src/main/resources/files/json/books.json";

    private BookRepository bookRepository;
    private ModelMapper modelMapper;
    private Gson gson;
    private ValidationUtil validationUtil;


    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return bookRepository.count() > 0;
    }

    @Override
    public String readBooksFromFile() throws IOException {
        return Files.readString(Path.of(BOOKS_FILE_PATH));
    }

    @Override
    public String importBooks() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        List<BookImportDto> books = Arrays.stream(gson.fromJson(readBooksFromFile(), BookImportDto[].class))
                .collect(Collectors.toList());

        for (BookImportDto book : books) {
            stringBuilder.append(System.lineSeparator());

            if (this.bookRepository.findByTitle(book.getTitle()).isPresent()
            || !validationUtil.isValid(book)) {

                stringBuilder.append(String.format(INVALID_FORMAT, BOOK));
                continue;
            }

            this.bookRepository.save(this.modelMapper.map(book, Book.class));

            stringBuilder.append(String.format(SUCCESSFUL_FORMAT_BOOK,
                    book.getAuthor(),
                    book.getTitle()));
        }

        return stringBuilder.toString().trim();
    }
}
