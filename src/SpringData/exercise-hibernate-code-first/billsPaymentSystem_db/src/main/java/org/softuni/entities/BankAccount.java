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
@Table(name = "bank_accounts")
public class BankAccount extends BillingDetail {

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "swift_code", unique = true)
    private String swiftCode;
}
