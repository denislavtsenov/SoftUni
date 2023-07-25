package bg.softuni.exercisexmlprocessingproductshop.model.dto.exportDto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "users")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserViewRootDto {

    @XmlElement(name = "user")
    private List<UserWithProductsDto> products;

    public List<UserWithProductsDto> getProducts() {
        return products;
    }

    public void setProducts(List<UserWithProductsDto> products) {
        this.products = products;
    }
}
