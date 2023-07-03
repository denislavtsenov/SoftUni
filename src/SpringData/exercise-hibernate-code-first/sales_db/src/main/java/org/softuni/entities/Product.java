package org.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(name = "names")
    private String name;

    @Column(name = "quantities")
    private Double quantity;

    @Column(name = "prices")
    private BigDecimal price;

    @OneToMany
    private Set<Sale> sales;
}
