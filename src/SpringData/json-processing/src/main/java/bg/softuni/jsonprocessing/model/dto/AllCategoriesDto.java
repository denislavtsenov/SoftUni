package bg.softuni.jsonprocessing.model.dto;

import bg.softuni.jsonprocessing.model.entity.Category;

import java.math.BigDecimal;

public class AllCategoriesDto {

    private String categoryName;
    private Integer productsCount;
    private BigDecimal averagePrice;
    private BigDecimal totalRevenue;

    public AllCategoriesDto() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getProductsCount() {
        return productsCount;
    }

    public void setProductsCount(Integer productsCount) {
        this.productsCount = productsCount;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        this.averagePrice = averagePrice;
    }

    public BigDecimal getTotalRevenue() {
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        this.totalRevenue = totalRevenue;
    }
}
