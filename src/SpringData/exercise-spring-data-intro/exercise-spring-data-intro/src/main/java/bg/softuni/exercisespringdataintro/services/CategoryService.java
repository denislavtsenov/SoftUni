package bg.softuni.exercisespringdataintro.services;

import bg.softuni.exercisespringdataintro.models.Category;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;


public interface CategoryService {
    Set<Category> getRandomCategories();

    void seedCategories() throws IOException;
}
