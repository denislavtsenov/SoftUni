package org.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private Integer quantity;
    private BigDecimal price;

    @OneToMany(mappedBy = "product")
    private Set<Sale> sales;

    public Product() {
        this.sales = new HashSet<>();
    }

}

