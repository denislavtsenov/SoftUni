package org.softuni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "teachers")
public class Teacher extends Person {

    @Column(name = "emails")
    private String email;

    @Column(name = "salary_per_hour")
    private BigDecimal salaryPerHour;

    @OneToMany
    private Set<Course> courses;
}
