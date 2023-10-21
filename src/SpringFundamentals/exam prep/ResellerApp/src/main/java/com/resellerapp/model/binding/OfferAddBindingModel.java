package com.resellerapp.model.binding;

import com.resellerapp.model.enums.ConditionNameEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

public class OfferAddBindingModel {

    @NotNull
    @Length(min = 2, max = 50, message = "Description length must be between 2 and 50 characters")
    private String description;

    @NotNull
    @Positive(message = "The price must be a positive number!")
    private BigDecimal price;

    @NotNull(message = "You must select condition!")
    private ConditionNameEnum conditionName;

    public OfferAddBindingModel() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ConditionNameEnum getConditionName() {
        return conditionName;
    }

    public void setConditionName(ConditionNameEnum conditionName) {
        this.conditionName = conditionName;
    }
}
