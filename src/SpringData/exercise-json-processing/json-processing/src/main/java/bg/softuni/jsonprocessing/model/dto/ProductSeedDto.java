package bg.softuni.jsonprocessing.model.dto;

import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductSeedDto {

    @Size(min = 3)
    private String name;

    private BigDecimal price;
}
