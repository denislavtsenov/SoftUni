package bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto;

import jakarta.xml.bind.annotation.*;

import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductRootViewNamePriceSellerDto {

    @XmlElement(name = "product")
    List<ProductViewNamePriceSellerDto> products;

    public List<ProductViewNamePriceSellerDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductViewNamePriceSellerDto> products) {
        this.products = products;
    }
}
