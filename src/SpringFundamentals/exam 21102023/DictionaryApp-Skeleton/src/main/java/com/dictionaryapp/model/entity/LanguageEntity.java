package com.dictionaryapp.model.entity;

import com.dictionaryapp.model.enums.LanguageNameEnum;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "languages")
public class LanguageEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false, unique = true)
    private LanguageNameEnum name;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToMany(mappedBy = "language", fetch = FetchType.EAGER)
    private Set<WordEntity> words;

    public LanguageEntity() {
    }

    public LanguageNameEnum getName() {
        return name;
    }

    public void setName(LanguageNameEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<WordEntity> getWords() {
        return words;
    }

    public void setWords(Set<WordEntity> words) {
        this.words = words;
    }
}
