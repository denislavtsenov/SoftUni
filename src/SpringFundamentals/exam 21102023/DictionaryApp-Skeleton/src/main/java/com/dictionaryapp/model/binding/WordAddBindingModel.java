package com.dictionaryapp.model.binding;

import com.dictionaryapp.model.enums.LanguageNameEnum;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class WordAddBindingModel {

    @NotNull
    @Length(min = 2, max = 40, message = "Term length must be between 2 and 40 characters!")
    private String term;

    @NotNull
    @Length(min = 2, max = 80, message = "Translation length must be between 2 and 80 characters!")
    private String translation;

    @Length(min = 2, max = 200, message = "Example length must be between 2 and 200 characters!")
    private String example;

    @NotNull
    @PastOrPresent(message = "The input date must be a date in the past or present.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate inputDate;

    @NotNull(message = "You must select language!")
    private LanguageNameEnum language;

    public WordAddBindingModel() {
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
}
