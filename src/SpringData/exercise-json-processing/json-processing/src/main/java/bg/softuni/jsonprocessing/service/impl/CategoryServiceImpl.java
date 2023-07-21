package bg.softuni.jsonprocessing.service.impl;

import bg.softuni.jsonprocessing.model.dto.AllCategoriesDto;
import bg.softuni.jsonprocessing.model.dto.CategorySeedDto;
import bg.softuni.jsonprocessing.model.entity.Category;
import bg.softuni.jsonprocessing.model.entity.Product;
import bg.softuni.jsonprocessing.repository.CategoryRepository;
import bg.softuni.jsonprocessing.service.CategoryService;
import bg.softuni.jsonprocessing.utils.ValidationUtil;
import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

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

    @Override
    public List<AllCategoriesDto> findAllCategoriesOrderByNumberOfProducts() {

        return categoryRepository
                .findAll()
                .stream()
                .map(category -> {

                    AllCategoriesDto allCategoriesDto = modelMapper.map(category, AllCategoriesDto.class);
                    allCategoriesDto.setProductsCount(category.getProducts().size());

                    allCategoriesDto.setAveragePrice(BigDecimal.valueOf(getAveragePrice(category)));

                    allCategoriesDto.setTotalRevenue(BigDecimal.valueOf(getTotalRevenue(category)));

                    return allCategoriesDto;
                })
                .sorted((a, b) -> b.getProductsCount().compareTo(a.getProductsCount()))
                .collect(Collectors.toList());
    }

    private static double getTotalRevenue(Category category) {
        double totalSum = 0.0;

        for (Product product : category.getProducts()) {
            double sum = Double.parseDouble(String.valueOf(product.getPrice()));
            totalSum += sum;
        }

        return totalSum;
    }

    private static double getAveragePrice(Category category) {
        double totalPrice = 0.0;
        int count = 0;
        for (Product product : category.getProducts()) {
            count++;
            double price = Double.parseDouble(String.valueOf(product.getPrice()));
            totalPrice += price;
        }

        double avgPrice = totalPrice / count;

        return avgPrice;
    }


}
