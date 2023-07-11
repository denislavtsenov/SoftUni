package bg.softuni.exercisespringdataintro.service.impl;

import bg.softuni.exercisespringdataintro.repository.BookRepository;
import bg.softuni.exercisespringdataintro.service.BookService;

public class BookServiceImpl implements BookService {

    private final static String BOOKS_FILE_PATH = "files/books.txt";
    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public void seedBooks() {

    }
}
