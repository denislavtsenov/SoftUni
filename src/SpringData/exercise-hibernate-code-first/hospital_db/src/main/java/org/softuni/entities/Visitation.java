package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "visitations")
public class Visitation extends BaseEntity {

    @Column(name = "date")
    private Date date;

    @Column(name = "comments")
    private String comments;

    @ManyToOne
    private Doctor doctor;
}
