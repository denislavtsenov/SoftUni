package com.resellerapp.model.service;

import com.resellerapp.model.entity.ConditionEntity;

import java.math.BigDecimal;

public class OfferServiceModel {

    private Long id;
    private String description;
    private BigDecimal price;
    private ConditionEntity condition;

    public OfferServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ConditionEntity getCondition() {
        return condition;
    }

    public void setCondition(ConditionEntity condition) {
        this.condition = condition;
    }
}
