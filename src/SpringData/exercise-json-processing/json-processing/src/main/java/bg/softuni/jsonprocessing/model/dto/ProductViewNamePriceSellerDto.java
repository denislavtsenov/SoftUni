package bg.softuni.jsonprocessing.model.dto;

import bg.softuni.jsonprocessing.model.entity.User;

import java.math.BigDecimal;

public class ProductViewNamePriceSellerDto {

    private String name;
    private BigDecimal price;
    private String seller;

    public ProductViewNamePriceSellerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
