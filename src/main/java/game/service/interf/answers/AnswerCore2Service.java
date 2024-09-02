package game.service.interf.answers;

import game.model.answers.AnswerCore2;
import java.util.Optional;

public interface AnswerCore2Service {
    void save(AnswerCore2 answer);

    Iterable<AnswerCore2> getAll();

    void update(AnswerCore2 answer);

    void delete(AnswerCore2 answer);

    void deleteByID(long id);

    Optional<AnswerCore2> getById(Long id);

    long getEntityCount();
}
