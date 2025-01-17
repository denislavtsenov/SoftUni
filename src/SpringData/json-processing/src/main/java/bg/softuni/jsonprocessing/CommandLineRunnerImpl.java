package bg.softuni.jsonprocessing;

import bg.softuni.jsonprocessing.model.dto.AllCategoriesDto;
import bg.softuni.jsonprocessing.model.dto.ProductViewNamePriceSellerDto;
import bg.softuni.jsonprocessing.model.dto.UserSoldDto;
import bg.softuni.jsonprocessing.service.CategoryService;
import bg.softuni.jsonprocessing.service.ProductService;
import bg.softuni.jsonprocessing.service.UserService;
import com.google.gson.Gson;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final static String OUTPUT_PATH = "src/main/resources/files/output/";
    private final static String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.json";
    private final static String SOLD_PRODUCTS_FILE_NAME = "sold-products.json";
    private final static String ALL_CATEGORIES_FILE_NAME = "all-categories.json";
    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final BufferedReader bufferedReader;
    private final Gson gson;

    public CommandLineRunnerImpl(UserService userService, ProductService productService, CategoryService categoryService, Gson gson) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.gson = gson;
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Choose exercise number:");
        int exNum = Integer.parseInt(bufferedReader.readLine());

        switch (exNum) {
            case 1:
                productsInRange();
                break;
            case 2:
                soldProducts();
                break;
            case 3:
                categoriesByProductCount();
                break;
        }
    }

    private void categoriesByProductCount() throws IOException {

        List<AllCategoriesDto> allCategoriesDtos = categoryService
                .findAllCategoriesOrderByNumberOfProducts();

        String content = gson.toJson(allCategoriesDtos);

        writeToFile(OUTPUT_PATH + ALL_CATEGORIES_FILE_NAME, content);
    }

    private void soldProducts() throws IOException {
        List<UserSoldDto> userSoldDtos = userService.findAllUsersWithAtLeastOneSoldProduct();

        String content = gson.toJson(userSoldDtos);

        writeToFile(OUTPUT_PATH + SOLD_PRODUCTS_FILE_NAME, content);
    }

    private void productsInRange() throws IOException {
        List<ProductViewNamePriceSellerDto> allProductsInPriceRangeWithoutBuyer = productService
                .findAllProductsInPriceRangeWithoutBuyer(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L));

        String content = gson.toJson(allProductsInPriceRangeWithoutBuyer);

        writeToFile(OUTPUT_PATH + PRODUCTS_IN_RANGE_FILE_NAME, content);
    }

    private void writeToFile(String filePath, String content) throws IOException {
        Files
                .write(Path.of(filePath),
                        Collections.singleton(content));
    }

    private void seedData() throws IOException {
        userService.seedUsers();
        categoryService.seedCategories();
        productService.seedProducts();
    }
}
