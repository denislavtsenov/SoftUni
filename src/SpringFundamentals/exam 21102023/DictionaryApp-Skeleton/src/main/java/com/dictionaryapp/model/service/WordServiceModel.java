package com.dictionaryapp.model.service;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;

import java.time.LocalDate;

public class WordServiceModel {

    private Long id;
    private String term;
    private String translation;
    private String example;
    private LocalDate inputDate;
    private LanguageNameEnum language;
    private UserEntity addedBy;

    public WordServiceModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LanguageNameEnum getLanguage() {
        return language;
    }

    public void setLanguage(LanguageNameEnum language) {
        this.language = language;
    }

    public UserEntity getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(UserEntity addedBy) {
        this.addedBy = addedBy;
    }
}
