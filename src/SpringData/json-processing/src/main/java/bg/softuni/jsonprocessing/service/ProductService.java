package bg.softuni.jsonprocessing.service;

import bg.softuni.jsonprocessing.model.dto.ProductViewNamePriceSellerDto;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void seedProducts() throws IOException;

    List<ProductViewNamePriceSellerDto> findAllProductsInPriceRangeWithoutBuyer(BigDecimal lower, BigDecimal upper);


}
