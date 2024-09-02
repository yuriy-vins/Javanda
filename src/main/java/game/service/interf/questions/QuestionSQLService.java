package game.service.interf.questions;

import game.model.questions.QuestionSQL;
import java.util.Optional;

public interface QuestionSQLService {
    void save(QuestionSQL questionSQL);

    Iterable<QuestionSQL> getAll();

    void update(QuestionSQL questionSQL);

    void delete(QuestionSQL questionSQL);

    void deleteByID(long id);

    Optional<QuestionSQL> getById(Long id);

    long getEntityCount();
}
