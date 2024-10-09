package com.softserve.itacademy.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyDto {
    private long id;

    private String question;

    private String answer;

    private long vocabularyID;

    private LocalDateTime date;

    private long errors;

    private long successes;

}
