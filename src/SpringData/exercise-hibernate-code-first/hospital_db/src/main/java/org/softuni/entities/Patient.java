package org.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Blob;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "patients")
public class Patient extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "addresses")
    private String address;

    @Column(name = "emails")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "pictures")
    private Blob picture;

    @Column(name = "medical_insurance")
    private boolean medicalInsurance;

    @ManyToOne
    private Doctor doctor;

}
