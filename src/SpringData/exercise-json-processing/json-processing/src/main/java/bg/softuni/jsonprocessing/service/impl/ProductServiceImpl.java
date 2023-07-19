package bg.softuni.jsonprocessing.service.impl;

import bg.softuni.jsonprocessing.model.dto.ProductSeedDto;
import bg.softuni.jsonprocessing.model.entity.Category;
import bg.softuni.jsonprocessing.model.entity.Product;
import bg.softuni.jsonprocessing.model.entity.User;
import bg.softuni.jsonprocessing.repository.ProductRepository;
import bg.softuni.jsonprocessing.service.CategoryService;
import bg.softuni.jsonprocessing.service.ProductService;
import bg.softuni.jsonprocessing.service.UserService;
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
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_PATH = "files/products.json";

    private final ProductRepository productRepository;
    private final UserService userService;
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService, CategoryService categoryService, ModelMapper modelMapper, ValidationUtil validationUtil, Gson gson) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }

    @Override
    public void seedProducts() throws IOException {

        if (productRepository.count() > 0) {
            return;
        }

        File resource = new ClassPathResource(PRODUCTS_FILE_PATH).getFile();

        String fileContent = Files
                .readString(Path.of(resource.toURI()));

        ProductSeedDto[] productSeedDtos = gson.fromJson(fileContent, ProductSeedDto[].class);

        for (ProductSeedDto productSeedDto : productSeedDtos) {

            if (productRepository.count() % 10 == 0) {
                productSeedDto.setBuyer(null);
            } else {
                productSeedDto.setBuyer(userService.getRandomUser());
            }

            productSeedDto.setSeller(userService.getRandomUser());
            productSeedDto.setCategories(categoryService.getRandomCategories());

            if (validationUtil.isValid(productSeedDto)) {
                Product product = modelMapper.map(productSeedDto, Product.class);
                productRepository.save(product);
            }
        }
    }
}
