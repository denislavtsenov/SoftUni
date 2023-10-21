package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.entity.WordEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WordRepository extends JpaRepository<WordEntity, Long> {

    List<WordEntity> findAllByLanguage_Name(LanguageNameEnum languageName);


}
