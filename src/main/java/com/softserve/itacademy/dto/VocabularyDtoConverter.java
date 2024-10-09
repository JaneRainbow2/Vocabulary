package com.softserve.itacademy.dto;

import com.softserve.itacademy.model.Vocabulary;
import org.springframework.stereotype.Component;

@Component
public class VocabularyDtoConverter {

    public VocabularyDto toDto(Vocabulary vocabulary) {
        return VocabularyDto.builder()
                .id(vocabulary.getId())
                .question(vocabulary.getQuestion())
                .answer(vocabulary.getAnswer())
                .vocabularyID(vocabulary.getVocabularyID())
                .date(vocabulary.getDate())
                .errors(vocabulary.getErrors())
                .successes(vocabulary.getSuccesses())
                .build();
    }

    public void fillFields(Vocabulary vocabulary,VocabularyDto vocabularyDto) {
        vocabulary.setQuestion(vocabularyDto.getQuestion());
        vocabulary.setAnswer(vocabularyDto.getAnswer());
        vocabulary.setVocabularyID(vocabularyDto.getVocabularyID());
        vocabulary.setDate(vocabularyDto.getDate());
        vocabulary.setErrors(vocabularyDto.getErrors());
        vocabulary.setSuccesses(vocabularyDto.getSuccesses());

    }
}
