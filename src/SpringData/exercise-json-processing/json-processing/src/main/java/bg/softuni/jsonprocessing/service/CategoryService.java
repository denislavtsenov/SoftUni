package bg.softuni.jsonprocessing.service;

import bg.softuni.jsonprocessing.model.entity.Category;

import java.io.IOException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();
}
