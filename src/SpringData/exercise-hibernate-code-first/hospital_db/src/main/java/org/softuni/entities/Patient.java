package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "patients")
public class Patient extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "picture")
    private Blob picture;

    @Column(name = "medical_insurance")
    private boolean medicalInsurance;

    @ManyToOne
    private Doctor doctor;

}
