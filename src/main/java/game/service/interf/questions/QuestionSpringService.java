package game.service.interf.questions;

import game.model.questions.QuestionSpring;
import java.util.Optional;

public interface QuestionSpringService {
    void save(QuestionSpring questionSpring);

    Iterable<QuestionSpring> getAll();

    void update(QuestionSpring questionSpring);

    void delete(QuestionSpring questionSpring);

    void deleteByID(long id);

    Optional<QuestionSpring> getById(Long id);

    long getEntityCount();
}
