package bg.softuni.exercisespringdataintro.services;

import bg.softuni.exercisespringdataintro.models.Category;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface CategoryService {
    Set<Category> getRandomCategories();
}
