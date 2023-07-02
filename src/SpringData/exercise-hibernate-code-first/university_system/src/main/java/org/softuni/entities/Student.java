package org.softuni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;

    @Column(name = "attendances")
    private int attendance;

    @OneToMany
    private Set<Course> courses;
}
