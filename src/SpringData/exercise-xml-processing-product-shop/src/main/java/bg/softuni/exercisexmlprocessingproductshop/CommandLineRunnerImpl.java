package bg.softuni.exercisexmlprocessingproductshop;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.CategoryViewRootDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.ProductRootViewNamePriceSellerDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.UserViewRootDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.UserViewRootWithProductsDto;
import bg.softuni.exercisexmlprocessingproductshop.service.CategoryService;
import bg.softuni.exercisexmlprocessingproductshop.service.ProductService;
import bg.softuni.exercisexmlprocessingproductshop.service.UserService;
import bg.softuni.exercisexmlprocessingproductshop.utils.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private static final String OUTPUT_FILE_PATH = "src/main/resources/files/output/";
    private static final String PRODUCTS_IN_RANGE_FILE_NAME = "products-in-range.xml";
    private static final String USERS_WITH_PRODUCTS_FILE_NAME = "users-with-products.xml";
    private static final String ALL_PRODUCTS_FILE_NAME = "all-products.xml";

    private static final String USERS_WITH_SOLD_PRODUCTS_FILE_NAME = "users-with-sold-products.xml";

    private final UserService userService;
    private final ProductService productService;
    private final CategoryService categoryService;
    private final BufferedReader bufferedReader;
    private final XmlParser xmlParser;

    public CommandLineRunnerImpl(UserService userService, ProductService productService, CategoryService categoryService, XmlParser xmlParser) {
        this.userService = userService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.xmlParser = xmlParser;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Choose exercise:");
        int numEx = Integer.parseInt(bufferedReader.readLine());

        switch (numEx) {
            case 1:
                productsInRange();
                break;
            case 2:
                soldProducts();
                break;
            case 3:
                categoriesByProductCount();
                break;
            case 4:
                usersAndProducts();
                break;
        }

    }

    private void usersAndProducts() throws JAXBException {
        UserViewRootWithProductsDto userViewRootWithProductsDto = userService
                .findAllUsersWIthAtLeastOneSoldProductSortByProductsCount();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + USERS_WITH_SOLD_PRODUCTS_FILE_NAME, userViewRootWithProductsDto);
    }

    private void categoriesByProductCount() throws JAXBException {

        CategoryViewRootDto categoryViewRootDto = categoryService
                .findAllCategoriesSortByProductCount();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + ALL_PRODUCTS_FILE_NAME, categoryViewRootDto);
    }

    private void soldProducts() throws JAXBException {
        UserViewRootDto userViewRootDto = userService
                .findAllUsersWithAtLeastOneSoldProduct();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + USERS_WITH_PRODUCTS_FILE_NAME, userViewRootDto);

    }

    private void productsInRange() throws JAXBException {
        ProductRootViewNamePriceSellerDto productRootViewNamePriceSellerDto = productService.findAllProductsInRangeWithoutBuyer();

        xmlParser.writeToFile(OUTPUT_FILE_PATH + PRODUCTS_IN_RANGE_FILE_NAME, productRootViewNamePriceSellerDto);
    }

    private void seedData() throws JAXBException, FileNotFoundException {

        userService.seedUsers();
        categoryService.seedCategories();
        productService.seedProducts();
    }
}
