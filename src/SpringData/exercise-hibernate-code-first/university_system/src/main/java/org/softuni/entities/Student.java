package org.softuni.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;

    @Column(name = "attendances")
    private int attendance;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
