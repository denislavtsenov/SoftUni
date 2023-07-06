package org.softuni.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "doctors")
public class Doctor extends BaseEntity {

    @OneToMany(mappedBy = "doctor")
    private Set<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private Set<Visitation> visitations;

    @OneToMany(mappedBy = "doctor")
    private Set<Diagnose> diagnoses;

    @OneToMany(mappedBy = "doctor")
    private Set<Medicament> medicaments;

}
