package game.repository.answers;

import game.model.answers.AnswerHibernate;
import org.springframework.data.repository.CrudRepository;

public interface AnswerHibernateRepository extends CrudRepository<AnswerHibernate, Long> {
}
