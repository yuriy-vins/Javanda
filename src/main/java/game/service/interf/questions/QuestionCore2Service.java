package game.service.interf.questions;

import game.model.questions.QuestionCore2;
import java.util.Optional;

public interface QuestionCore2Service {
    void save(QuestionCore2 question);

    Iterable<QuestionCore2> getAll();

    void update(QuestionCore2 question);

    void delete(QuestionCore2 question);

    void deleteByID(long id);

    Optional<QuestionCore2> getById(Long id);

    long getEntityCount();
}
