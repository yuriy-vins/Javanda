package game.service.interf.questions;

import game.model.questions.QuestionPatterns;
import java.util.Optional;

public interface QuestionPatternsService {
    void save(QuestionPatterns questionPatterns);

    Iterable<QuestionPatterns> getAll();

    void update(QuestionPatterns questionPatterns);

    void delete(QuestionPatterns questionPatterns);

    void deleteByID(long id);

    Optional<QuestionPatterns> getById(Long id);

    long getEntityCount();
}
