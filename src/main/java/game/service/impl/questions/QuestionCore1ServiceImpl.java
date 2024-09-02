package game.service.impl.questions;

import game.model.questions.QuestionCore1;
import game.repository.questions.QuestionCore1Repository;
import game.service.interf.questions.QuestionCore1Service;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionCore1ServiceImpl implements QuestionCore1Service {
    private final QuestionCore1Repository questionCore1Repository;

    public QuestionCore1ServiceImpl(QuestionCore1Repository questionRepository) {
        this.questionCore1Repository = questionRepository;
    }

    public void save(QuestionCore1 question) {
        this.questionCore1Repository.save(question);
    }

    public void update(QuestionCore1 question) {
        this.questionCore1Repository.save(question);
    }

    public Iterable<QuestionCore1> getAll() {
        return this.questionCore1Repository.findAll();
    }

    public void delete(QuestionCore1 question) {
        this.questionCore1Repository.delete(question);
    }

    public void deleteByID(long id) {
        this.questionCore1Repository.deleteById(id);
    }

    public Optional<QuestionCore1> getById(Long id) {
        return this.questionCore1Repository.findById(id);
    }

    public long getEntityCount() {
        return this.questionCore1Repository.count();
    }
}

