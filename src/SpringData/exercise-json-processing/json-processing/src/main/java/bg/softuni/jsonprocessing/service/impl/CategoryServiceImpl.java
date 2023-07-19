package bg.softuni.jsonprocessing.service.impl;

import bg.softuni.jsonprocessing.model.dto.CategorySeedDto;
import bg.softuni.jsonprocessing.model.entity.Category;
import bg.softuni.jsonprocessing.repository.CategoryRepository;
import bg.softuni.jsonprocessing.service.CategoryService;
import bg.softuni.jsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "files/categories.json";

    private final Gson gson;
    private final ValidationUtil validationUtil;
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(Gson gson, ValidationUtil validationUtil, CategoryRepository categoryRepository, ModelMapper modelMapper) {
        this.gson = gson;
        this.validationUtil = validationUtil;
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedCategories() throws IOException {

        if (categoryRepository.count() > 0) {
            return;
        }

        File resource = new ClassPathResource(CATEGORIES_FILE_PATH).getFile();

        String fileContent = Files
                .readString(Path.of(resource.toURI()));

        CategorySeedDto[] categorySeedDtos = gson.fromJson(fileContent, CategorySeedDto[].class);

        Arrays.stream(categorySeedDtos)
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {

        int categoryCount = ThreadLocalRandom.current().nextInt(1, 3);

        long repositoryCount = categoryRepository.count();
        Set<Category> randomCategories = new HashSet<>();

        for (int i = 0; i < categoryCount; i++) {

            Long randomId = ThreadLocalRandom.current().nextLong(1, repositoryCount + 1);
            randomCategories.add(categoryRepository.findById(randomId).orElse(null));
        }

        return randomCategories;
    }


}
