package game.service.interf.questions;

import game.model.questions.QuestionAlgorithms;
import java.util.Optional;

public interface QuestionAlgorithmsService {
    void save(QuestionAlgorithms questionAlgorithms);

    Iterable<QuestionAlgorithms> getAll();

    void update(QuestionAlgorithms questionAlgorithms);

    void delete(QuestionAlgorithms questionAlgorithms);

    void deleteByID(long id);

    Optional<QuestionAlgorithms> getById(Long id);

    long getEntityCount();
}
