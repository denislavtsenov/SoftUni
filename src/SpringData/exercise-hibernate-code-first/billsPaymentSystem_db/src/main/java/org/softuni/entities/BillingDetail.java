package org.softuni.entities;

import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetail extends BaseEntity{

    private String number;
    private String owner;

    @ManyToOne
    private User user;
}
