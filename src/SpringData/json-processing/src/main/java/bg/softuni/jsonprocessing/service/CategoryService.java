package bg.softuni.jsonprocessing.service;

import bg.softuni.jsonprocessing.model.dto.AllCategoriesDto;
import bg.softuni.jsonprocessing.model.entity.Category;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws IOException;

    Set<Category> getRandomCategories();

    List<AllCategoriesDto> findAllCategoriesOrderByNumberOfProducts();
}
