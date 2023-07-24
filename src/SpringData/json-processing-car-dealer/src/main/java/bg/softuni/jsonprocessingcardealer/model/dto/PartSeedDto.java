package bg.softuni.jsonprocessingcardealer.model.dto;

import java.math.BigDecimal;

public class PartSeedDto {

    private String name;
    private BigDecimal price;
    private Integer quantity;


    public PartSeedDto() {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}
