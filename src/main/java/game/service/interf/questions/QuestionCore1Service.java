package game.service.interf.questions;

import game.model.questions.QuestionCore1;
import java.util.Optional;

public interface QuestionCore1Service {
    void save(QuestionCore1 question);

    Iterable<QuestionCore1> getAll();

    void update(QuestionCore1 question);

    void delete(QuestionCore1 question);

    void deleteByID(long id);

    Optional<QuestionCore1> getById(Long id);

    long getEntityCount();
}
