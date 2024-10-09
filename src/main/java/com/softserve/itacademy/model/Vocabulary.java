package com.softserve.itacademy.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "vocabularies")
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "question", nullable = false)
    private String question;

    @Column(name = "answer", nullable = false)
    private String answer;

    @Column(name = "vocabularyID")
    private long vocabularyID;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "errors")
    private long errors;

    @Column(name = "successes")
    private long successes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vocabulary that = (Vocabulary) o;
        return id == that.id && vocabularyID == that.vocabularyID && errors == that.errors && successes == that.successes && Objects.equals(question, that.question) && Objects.equals(answer, that.answer) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, question, answer, vocabularyID, date, errors, successes);
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", vocabularyID=" + vocabularyID +
                ", date=" + date +
                ", errors=" + errors +
                ", successes=" + successes +
                '}';
    }
}