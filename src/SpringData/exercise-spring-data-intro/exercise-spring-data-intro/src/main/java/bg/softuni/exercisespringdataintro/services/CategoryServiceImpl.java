package bg.softuni.exercisespringdataintro.services;

import bg.softuni.exercisespringdataintro.models.Category;
import bg.softuni.exercisespringdataintro.repositories.CategoryRepository;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;

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
}
