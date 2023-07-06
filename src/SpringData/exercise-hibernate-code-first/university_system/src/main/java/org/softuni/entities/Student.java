package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "students")
public class Student extends Person {

    @Column(name = "average_grade")
    private double averageGrade;

    @Column(name = "attendance")
    private int attendance;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}
