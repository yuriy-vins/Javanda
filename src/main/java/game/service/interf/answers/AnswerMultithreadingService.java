package game.service.interf.answers;

import game.model.answers.AnswerMultithreading;
import java.util.Optional;

public interface AnswerMultithreadingService {
    void save(AnswerMultithreading answerMultithreading);

    Iterable<AnswerMultithreading> getAll();

    void update(AnswerMultithreading answerMultithreading);

    void delete(AnswerMultithreading answerMultithreading);

    void deleteByID(long id);

    Optional<AnswerMultithreading> getById(Long id);

    long getEntityCount();
}