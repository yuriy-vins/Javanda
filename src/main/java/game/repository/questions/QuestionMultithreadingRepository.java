package game.repository.questions;

import game.model.questions.QuestionMultithreading;
import org.springframework.data.repository.CrudRepository;

public interface QuestionMultithreadingRepository extends CrudRepository<QuestionMultithreading, Long> {
}