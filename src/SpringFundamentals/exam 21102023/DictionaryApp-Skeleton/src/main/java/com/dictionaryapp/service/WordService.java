package com.dictionaryapp.service;

import com.dictionaryapp.model.entity.WordEntity;
import com.dictionaryapp.model.service.WordServiceModel;

import java.util.List;

public interface WordService {
    void addWord(WordServiceModel wordServiceModel);

    List<WordEntity> findAllByFrenchLanguage();

    List<WordEntity> findAllBySpanishLanguage();

    List<WordEntity> findAllByGermanLanguage();

    List<WordEntity> findAllByItalianLanguage();

    void remove(Long id);

    void removeAll();
}
