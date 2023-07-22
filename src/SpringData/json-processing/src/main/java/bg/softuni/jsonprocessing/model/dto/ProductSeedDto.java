package bg.softuni.jsonprocessing.model.dto;

import bg.softuni.jsonprocessing.model.entity.Category;
import bg.softuni.jsonprocessing.model.entity.User;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Set;

public class ProductSeedDto {

    @Size(min = 3)
    private String name;

    private BigDecimal price;

    private User buyer;
    private User seller;
    private Set<Category> categories;

    public ProductSeedDto() {
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

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
