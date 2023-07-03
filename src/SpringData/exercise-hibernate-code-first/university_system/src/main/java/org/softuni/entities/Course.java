package org.softuni.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "courses")
public class Course extends BaseEntity {

    @Column(name = "names")
    private String name;

    @Column(name = "descriptions")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    private Integer credits;

    @ManyToMany
    private Set<Student> students;

    @ManyToOne
    private Teacher teacher;
}
