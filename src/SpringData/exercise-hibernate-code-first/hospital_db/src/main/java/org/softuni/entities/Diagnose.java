package org.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "diagnoses")
public class Diagnose extends BaseEntity {

    private String name;
    private String comments;
}
