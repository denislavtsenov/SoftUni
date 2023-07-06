package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "medicaments")
public class Medicament extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToOne
    private Doctor doctor;
}
