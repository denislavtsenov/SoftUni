package bg.softuni.exercisespringdataintro.service;

import bg.softuni.exercisespringdataintro.models.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Category getRandomCategory();

    Set<Category> getRandomCategories();
}
