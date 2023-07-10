package bg.softuni.exercisespringdataintro.services;

import bg.softuni.exercisespringdataintro.models.Author;
import org.springframework.stereotype.Service;

@Service
public interface AuthorService {
    Author getRandomAuthor();
}
