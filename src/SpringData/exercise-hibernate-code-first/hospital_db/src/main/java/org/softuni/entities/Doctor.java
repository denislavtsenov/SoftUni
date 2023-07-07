package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor extends BaseEntity {

    @OneToMany
    private Set<Patient> patients;

    @OneToMany
    private Set<Visitation> visitations;

    @OneToMany
    private Set<Diagnose> diagnoses;

    @OneToMany
    private Set<Medicament> medicaments;

}
