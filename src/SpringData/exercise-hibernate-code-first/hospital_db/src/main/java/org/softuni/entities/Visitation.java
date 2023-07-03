package org.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "visitations")
public class Visitation extends BaseEntity{

    private Date date;
    private String comments;
}
