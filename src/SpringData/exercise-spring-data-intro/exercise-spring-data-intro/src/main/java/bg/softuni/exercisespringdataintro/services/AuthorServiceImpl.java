package bg.softuni.exercisespringdataintro.services;

import bg.softuni.exercisespringdataintro.models.Author;
import bg.softuni.exercisespringdataintro.repositories.AuthorRepository;

import java.util.Random;

public class AuthorServiceImpl implements AuthorService {
    private AuthorRepository authorRepository;
    @Override
    public Author getRandomAuthor() {
        Random random = new Random();

        long count = authorRepository.count();

        long randomId = random.nextInt((int) count);

        Author author = authorRepository.findById(randomId).orElseThrow();

        return author;
    }
}
