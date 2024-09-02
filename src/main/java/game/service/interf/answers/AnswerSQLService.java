package game.service.interf.answers;

import game.model.answers.AnswerSQL;
import java.util.Optional;

public interface AnswerSQLService {
    void save(AnswerSQL answerSQL);

    Iterable<AnswerSQL> getAll();

    void update(AnswerSQL answerSQL);

    void delete(AnswerSQL answerSQL);

    void deleteByID(long id);

    Optional<AnswerSQL> getById(Long id);

    long getEntityCount();
}
