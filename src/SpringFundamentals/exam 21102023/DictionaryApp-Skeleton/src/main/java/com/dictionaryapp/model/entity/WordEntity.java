package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "words")
public class WordEntity extends BaseEntity{

    @Column(name = "term", nullable = false)
    private String term;

    @Column(name = "translation", nullable = false)
    private String translation;

    @Column(name = "example", columnDefinition = "TEXT")
    private String example;

    @Column(name = "input_date", nullable = false)
    private LocalDate inputDate;

    @ManyToOne(fetch = FetchType.EAGER)
    private LanguageEntity language;

    @ManyToOne()
    private UserEntity addedBy;

    public WordEntity() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public LocalDate getInputDate() {
        return inputDate;
    }

    public void setInputDate(LocalDate inputDate) {
        this.inputDate = inputDate;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }

    public UserEntity getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(UserEntity addedBy) {
        this.addedBy = addedBy;
    }
}
