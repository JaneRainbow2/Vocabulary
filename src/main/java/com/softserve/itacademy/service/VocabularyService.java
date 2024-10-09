package com.softserve.itacademy.service;

import com.softserve.itacademy.config.exception.NullEntityReferenceException;
import com.softserve.itacademy.dto.VocabularyDto;
import com.softserve.itacademy.dto.VocabularyDtoConverter;
import com.softserve.itacademy.model.Vocabulary;
import com.softserve.itacademy.repository.VocabularyRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VocabularyService {
    private final VocabularyRepository vocabularyRepository;
    private final VocabularyDtoConverter vocabularyDtoConverter;

    public Vocabulary create(Vocabulary vocabulary) {
        if (vocabulary != null) {
            System.out.println("-------------");
            System.out.println(vocabulary.getId());
            System.out.println(vocabulary.getQuestion());
            return vocabularyRepository.save(vocabulary);
        }
        throw new NullEntityReferenceException("User cannot be 'null'");
    }

    public Vocabulary readById(long id) {
        return vocabularyRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User with id " + id + " not found"));
    }

    public VocabularyDto update(VocabularyDto vocabularyDto) {
       Vocabulary vocabulary = vocabularyRepository.findById(vocabularyDto.getId()).orElseThrow(EntityNotFoundException::new);

        vocabularyDtoConverter.fillFields(vocabulary, vocabularyDto);
        vocabularyRepository.save(vocabulary);
        return vocabularyDtoConverter.toDto(vocabulary);
    }

    public void delete(long id) {
        Vocabulary vocabulary = readById(id);
        vocabularyRepository.delete(vocabulary);
    }

    public List<Vocabulary> getAll() {
        return vocabularyRepository.findAll();
    }

    public VocabularyDto findByIdThrowing(long id) {
        return vocabularyRepository.findById(id).map(vocabularyDtoConverter::toDto).orElseThrow(EntityNotFoundException::new);
    }

}

