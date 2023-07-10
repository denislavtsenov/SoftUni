package bg.softuni.exercisespringdataintro.services;

import bg.softuni.exercisespringdataintro.models.Category;
import bg.softuni.exercisespringdataintro.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH =
            "src/SpringData/exercise-spring-data-intro/exercise-spring-data-intro/src/main/resources/files/categories.txt";
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Set<Category> getRandomCategories() {
        Random random = new Random();

        long count = categoryRepository.count();

        Set<Category> categories = new HashSet<>();
        for (int i = 0; i < count; i++) {
            long randomId = random.nextInt((int) count);
            Category category = categoryRepository.findById(randomId).orElseThrow();

            categories.add(category);
        }

        return categories;
    }

    @Override
    public void seedCategories() throws IOException {

        List<String> strings = Files.readAllLines(Path.of(CATEGORIES_FILE_PATH));
    }
}
