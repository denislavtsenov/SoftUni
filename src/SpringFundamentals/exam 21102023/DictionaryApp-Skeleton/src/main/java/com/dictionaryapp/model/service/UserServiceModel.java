package com.dictionaryapp.model.service;

import com.dictionaryapp.model.entity.WordEntity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;

import java.util.HashSet;
import java.util.Set;

public class UserServiceModel {

    private Long id;
    private String username;

    private String password;

    private String email;

    private Set<WordEntity> addedWords;

    public UserServiceModel() {
        this.addedWords = new HashSet<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<WordEntity> getAddedWords() {
        return addedWords;
    }

    public void setAddedWords(Set<WordEntity> addedWords) {
        this.addedWords = addedWords;
    }
}
