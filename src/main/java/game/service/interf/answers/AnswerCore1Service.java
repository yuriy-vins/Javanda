package game.service.interf.answers;

import game.model.answers.AnswerCore1;
import java.util.Optional;

public interface AnswerCore1Service {
    void save(AnswerCore1 answer);

    Iterable<AnswerCore1> getAll();

    void update(AnswerCore1 answer);

    void delete(AnswerCore1 answer);

    void deleteByID(long id);

    Optional<AnswerCore1> getById(Long id);

    long getEntityCount();
}
