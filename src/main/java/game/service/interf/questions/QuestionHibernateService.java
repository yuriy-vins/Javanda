package game.service.interf.questions;

import game.model.questions.QuestionHibernate;
import java.util.Optional;

public interface QuestionHibernateService {
    void save(QuestionHibernate questionHibernate);

    Iterable<QuestionHibernate> getAll();

    void update(QuestionHibernate questionHibernate);

    void delete(QuestionHibernate questionHibernate);

    void deleteByID(long id);

    Optional<QuestionHibernate> getById(Long id);

    long getEntityCount();
}
