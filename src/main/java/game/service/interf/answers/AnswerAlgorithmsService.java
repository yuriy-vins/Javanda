package game.service.interf.answers;

import game.model.answers.AnswerAlgorithms;
import java.util.Optional;

public interface AnswerAlgorithmsService {
    void save(AnswerAlgorithms answerAlgorithms);

    Iterable<AnswerAlgorithms> getAll();

    void update(AnswerAlgorithms answerAlgorithms);

    void delete(AnswerAlgorithms answerAlgorithms);

    void deleteByID(long id);

    Optional<AnswerAlgorithms> getById(Long id);

    long getEntityCount();
}
