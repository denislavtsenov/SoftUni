package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private Doctor doctor;
}
