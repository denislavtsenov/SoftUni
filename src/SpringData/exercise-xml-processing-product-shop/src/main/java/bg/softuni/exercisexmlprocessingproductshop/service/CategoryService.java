package bg.softuni.exercisexmlprocessingproductshop.service;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.CategoryViewRootDto;
import bg.softuni.exercisexmlprocessingproductshop.model.entity.Category;
import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.util.Set;

public interface CategoryService {
    void seedCategories() throws JAXBException, FileNotFoundException;

    Set<Category> getRandomCategories();

    CategoryViewRootDto findAllCategoriesSortByProductCount();
}
