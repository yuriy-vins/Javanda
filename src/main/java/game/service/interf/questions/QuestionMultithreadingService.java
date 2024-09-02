package game.service.interf.questions;

import game.model.questions.QuestionMultithreading;
import java.util.Optional;

public interface QuestionMultithreadingService {
    void save(QuestionMultithreading questionMultithreading);

    Iterable<QuestionMultithreading> getAll();

    void update(QuestionMultithreading questionMultithreading);

    void delete(QuestionMultithreading questionMultithreading);

    void deleteByID(long id);

    Optional<QuestionMultithreading> getById(Long id);

    long getEntityCount();
}
