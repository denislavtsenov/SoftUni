package org.softuni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer extends BaseEntity {

    @Column(name = "names")
    private String name;

    @Column(name = "emails")
    private String email;

    @Column(name = "credit_card_number")
    private String creditCardNumber;

    @OneToMany
    private Set<Sale> sales;
}
