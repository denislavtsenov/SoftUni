package org.softuni.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "credit_cards")
public class CreditCard extends BillingDetail {

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "expiration_month")
    private String expirationMonth;

    @Column(name = "expiration_year")
    private String expirationYear;
}
