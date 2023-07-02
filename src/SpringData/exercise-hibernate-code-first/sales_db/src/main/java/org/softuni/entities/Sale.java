package org.softuni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {

    @Column(name = "product_id")
    private int productId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "store_location_id")
    private int storeLocationId;

    @Column(name = "date")
    private Date date;
}
