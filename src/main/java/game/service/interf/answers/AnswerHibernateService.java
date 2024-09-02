package game.service.interf.answers;

import game.model.answers.AnswerHibernate;
import java.util.Optional;

public interface AnswerHibernateService {
    void save(AnswerHibernate answerHibernate);

    Iterable<AnswerHibernate> getAll();

    void update(AnswerHibernate answerHibernate);

    void delete(AnswerHibernate answerHibernate);

    void deleteByID(long id);

    Optional<AnswerHibernate> getById(Long id);

    long getEntityCount();
}