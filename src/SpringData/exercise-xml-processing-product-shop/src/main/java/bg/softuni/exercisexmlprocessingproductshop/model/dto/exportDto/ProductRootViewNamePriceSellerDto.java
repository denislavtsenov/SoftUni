package bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

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
