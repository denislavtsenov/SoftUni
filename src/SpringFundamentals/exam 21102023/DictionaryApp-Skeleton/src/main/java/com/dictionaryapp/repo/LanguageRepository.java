package com.dictionaryapp.repo;

import com.dictionaryapp.model.entity.LanguageEntity;
import com.dictionaryapp.model.enums.LanguageNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    LanguageEntity findByName(LanguageNameEnum languageName);



}
