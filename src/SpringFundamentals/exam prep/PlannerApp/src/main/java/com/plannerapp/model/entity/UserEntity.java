package com.plannerapp.model.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    @Email
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<TaskEntity> assignedTasks;

    public UserEntity() {
        this.assignedTasks = new HashSet<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<TaskEntity> getAssignedTasks() {
        return assignedTasks;
    }

    public void setAssignedTasks(Set<TaskEntity> assignedTasks) {
        this.assignedTasks = assignedTasks;
    }
}
