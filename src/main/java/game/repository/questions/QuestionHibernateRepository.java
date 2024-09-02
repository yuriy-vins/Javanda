package game.repository.questions;

import game.model.questions.QuestionHibernate;
import org.springframework.data.repository.CrudRepository;

public interface QuestionHibernateRepository extends CrudRepository<QuestionHibernate, Long> {
}

