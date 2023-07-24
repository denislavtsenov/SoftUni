package bg.softuni.exercisexmlprocessingproductshop.service.impl;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.ProductRootViewNamePriceSellerDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.ProductViewNamePriceSellerDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.importDto.ProductRootSeedDto;
import bg.softuni.exercisexmlprocessingproductshop.model.entity.Product;
import bg.softuni.exercisexmlprocessingproductshop.repository.ProductRepository;
import bg.softuni.exercisexmlprocessingproductshop.service.CategoryService;
import bg.softuni.exercisexmlprocessingproductshop.service.ProductService;
import bg.softuni.exercisexmlprocessingproductshop.service.UserService;
import bg.softuni.exercisexmlprocessingproductshop.utils.ValidationUtil;
import bg.softuni.exercisexmlprocessingproductshop.utils.XmlParser;
import jakarta.xml.bind.JAXBException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private static final String PRODUCTS_FILE_PATH = "src/main/resources/files/products.xml";
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper,
                              ValidationUtil validationUtil, XmlParser xmlParser, CategoryService categoryService,
                              UserService userService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
    }

    @Override
    public void seedProducts() throws JAXBException, FileNotFoundException {

        if (productRepository.count() > 0) {
            return;
        }

        ProductRootSeedDto productRootSeedDto = xmlParser.fromFile(PRODUCTS_FILE_PATH, ProductRootSeedDto.class);

        productRootSeedDto.getProducts()
                .stream()
                .filter(validationUtil::isValid)
                .map(productSeedDto -> {
                    Product product = modelMapper.map(productSeedDto, Product.class);
                    product.setCategories(categoryService.getRandomCategories());
                    product.setSeller(userService.getRandomUser());

                    if (product.getPrice().compareTo(BigDecimal.valueOf(700L)) < 0) {
                        product.setBuyer(userService.getRandomUser());
                    } else {
                        product.setBuyer(null);
                    }

                    return product;
                })
                .forEach(productRepository::save);
    }

    @Override
    public ProductRootViewNamePriceSellerDto findAllProductsInRangeWithoutBuyer() {
        ProductRootViewNamePriceSellerDto productRootViewNamePriceSellerDto = new ProductRootViewNamePriceSellerDto();

        productRootViewNamePriceSellerDto.setProducts(productRepository
                .findAllByPriceBetweenAndBuyerIsNullOrderByPriceAsc(BigDecimal.valueOf(500L), BigDecimal.valueOf(1000L))
                .stream()
                .map(product -> {
                    ProductViewNamePriceSellerDto productViewNamePriceSellerDto = modelMapper.map(product, ProductViewNamePriceSellerDto.class);

                    productViewNamePriceSellerDto.setSeller(String.format("%s %s",
                            product.getSeller().getFirstName(),
                            product.getSeller().getLastName()));

                    return productViewNamePriceSellerDto;

                })
                .collect(Collectors.toList()));
        return productRootViewNamePriceSellerDto;
    }
}
