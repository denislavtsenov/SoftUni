package bg.softuni.exercisexmlprocessingproductshop.service;

import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.ProductRootViewNamePriceSellerDto;
import bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto.ProductViewNamePriceSellerDto;
import jakarta.xml.bind.JAXBException;

import java.io.FileNotFoundException;
import java.util.List;

public interface ProductService {
    void seedProducts() throws JAXBException, FileNotFoundException;

    ProductRootViewNamePriceSellerDto findAllProductsInRangeWithoutBuyer();

}
