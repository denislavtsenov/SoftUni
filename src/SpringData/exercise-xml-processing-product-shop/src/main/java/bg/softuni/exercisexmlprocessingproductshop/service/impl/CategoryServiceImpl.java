package bg.softuni.exercisexmlprocessingproductshop.service.impl;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.CategoryViewDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.CategoryViewRootDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.importDto.CategoryRootSeedDto;
import bg.softuni.exercisexmlprocessingproductshop.model.entity.Category;
import bg.softuni.exercisexmlprocessingproductshop.model.entity.Product;
import bg.softuni.exercisexmlprocessingproductshop.repository.CategoryRepository;
import bg.softuni.exercisexmlprocessingproductshop.service.CategoryService;
import bg.softuni.exercisexmlprocessingproductshop.utils.ValidationUtil;
import bg.softuni.exercisexmlprocessingproductshop.utils.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String CATEGORIES_FILE_PATH = "src/main/resources/files/categories.xml";
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;

    private final ValidationUtil validationUtil;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil) {
        this.categoryRepository = categoryRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public void seedCategories() throws JAXBException, FileNotFoundException {
        if (categoryRepository.count() > 0) {
            return;
        }

        CategoryRootSeedDto categoryRootSeedDto = xmlParser.fromFile(CATEGORIES_FILE_PATH, CategoryRootSeedDto.class);

        categoryRootSeedDto.getCategories()
                .stream()
                .filter(validationUtil::isValid)
                .map(categorySeedDto -> modelMapper.map(categorySeedDto, Category.class))
                .forEach(categoryRepository::save);
    }

    @Override
    public Set<Category> getRandomCategories() {

        Set<Category> randomCategories = new HashSet<>();
        long repositoryCount = categoryRepository.count();

        for (int i = 0; i < 1; i++) {

            long randomId = ThreadLocalRandom
                    .current().nextLong(1, repositoryCount + 1);

            randomCategories.add(categoryRepository.findById(randomId).orElse(null));
        }

        return randomCategories;
    }

    @Override
    public CategoryViewRootDto findAllCategoriesSortByProductCount() {

        CategoryViewRootDto categoryViewRootDto = new CategoryViewRootDto();

        categoryViewRootDto.setCategories(
                categoryRepository.findAll()
                        .stream()
                        .map(category -> {
                            CategoryViewDto categoryViewDto = modelMapper.map(category, CategoryViewDto.class);

                            categoryViewDto.setCount(category.getProducts().size());

                            categoryViewDto.setAvgPrice(BigDecimal.valueOf(getAveragePrice(category)));
                            categoryViewDto.setTotalRevenue(BigDecimal.valueOf(getTotalRevenue(category)));

                            return categoryViewDto;
                        })
                        .sorted((a, b) -> b.getCount().compareTo(a.getCount()))
                        .collect(Collectors.toList()));

        return categoryViewRootDto;

    }

    private double getTotalRevenue(Category category) {
        double totalSum = 0.0;

        for (Product product : category.getProducts()) {
            double sum = Double.parseDouble(String.valueOf(product.getPrice()));
            totalSum += sum;
        }

        return totalSum;
    }

    private double getAveragePrice(Category category) {
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
