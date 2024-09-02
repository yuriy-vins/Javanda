package game.service.interf.answers;

import game.model.answers.AnswerSpring;
import java.util.Optional;

public interface AnswerSpringService {
    void save(AnswerSpring answerSpring);

    Iterable<AnswerSpring> getAll();

    void update(AnswerSpring answerSpring);

    void delete(AnswerSpring answerSpring);

    void deleteByID(long id);

    Optional<AnswerSpring> getById(Long id);

    long getEntityCount();
}