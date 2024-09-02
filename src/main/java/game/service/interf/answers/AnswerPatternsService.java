package game.service.interf.answers;

import game.model.answers.AnswerPatterns;
import java.util.Optional;

public interface AnswerPatternsService {
    void save(AnswerPatterns answerPatterns);

    Iterable<AnswerPatterns> getAll();

    void update(AnswerPatterns answerPatterns);

    void delete(AnswerPatterns answerPatterns);

    void deleteByID(long id);

    Optional<AnswerPatterns> getById(Long id);

    long getEntityCount();
}
