package com.dictionaryapp.service.impl;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.entity.UserEntity;
import com.dictionaryapp.model.entity.WordEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import com.dictionaryapp.model.service.WordServiceModel;
import com.dictionaryapp.repo.LanguageRepository;
import com.dictionaryapp.repo.UserRepository;
import com.dictionaryapp.repo.WordRepository;
import com.dictionaryapp.service.WordService;
import com.dictionaryapp.util.CurrentUser;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WordServiceImpl implements WordService {

    private final LanguageRepository languageRepository;
    private final ModelMapper modelMapper;
    private final WordRepository wordRepository;
    private final CurrentUser currentUser;
    private final UserRepository userRepository;

    public WordServiceImpl(LanguageRepository languageRepository, ModelMapper modelMapper, WordRepository wordRepository, CurrentUser currentUser, UserRepository userRepository) {
        this.languageRepository = languageRepository;
        this.modelMapper = modelMapper;
        this.wordRepository = wordRepository;
        this.currentUser = currentUser;
        this.userRepository = userRepository;
    }

    @Override
    public void addWord(WordServiceModel wordServiceModel) {

        LanguageEntity language = languageRepository.findByName(wordServiceModel.getLanguage());
        UserEntity user = userRepository.findById(currentUser.getId()).orElse(null);
        if (language != null && user != null) {
            WordEntity word = modelMapper.map(wordServiceModel, WordEntity.class);
            word.setLanguage(language);
            word.setAddedBy(user);
            wordRepository.save(word);
        }
    }

    @Override
    public List<WordEntity> findAllByFrenchLanguage() {
        return wordRepository.findAllByLanguage_Name(LanguageNameEnum.FRENCH);
    }

    @Override
    public List<WordEntity> findAllBySpanishLanguage() {
        return wordRepository.findAllByLanguage_Name(LanguageNameEnum.SPANISH);
    }

    @Override
    public List<WordEntity> findAllByGermanLanguage() {
        return wordRepository.findAllByLanguage_Name(LanguageNameEnum.GERMAN);
    }

    @Override
    public List<WordEntity> findAllByItalianLanguage() {
        return wordRepository.findAllByLanguage_Name(LanguageNameEnum.ITALIAN);
    }

    @Override
    public void remove(Long id) {
        wordRepository.deleteById(id);
    }

    @Override
    public void removeAll() {
        wordRepository.deleteAll();
    }
}
