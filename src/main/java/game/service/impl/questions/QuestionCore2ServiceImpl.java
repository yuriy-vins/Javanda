package game.service.impl.questions;

import game.model.questions.QuestionCore2;
import game.repository.questions.QuestionCore2Repository;
import game.service.interf.questions.QuestionCore2Service;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionCore2ServiceImpl implements QuestionCore2Service {
    private final QuestionCore2Repository questionCore2Repository;

    public QuestionCore2ServiceImpl(QuestionCore2Repository questionCore2Repository) {
        this.questionCore2Repository = questionCore2Repository;
    }

    public void save(QuestionCore2 question) {
        this.questionCore2Repository.save(question);
    }

    public void update(QuestionCore2 question) {
        this.questionCore2Repository.save(question);
    }

    public Iterable<QuestionCore2> getAll() {
        return this.questionCore2Repository.findAll();
    }

    public void delete(QuestionCore2 question) {
        this.questionCore2Repository.delete(question);
    }

    public void deleteByID(long id) {
        this.questionCore2Repository.deleteById(id);
    }

    public Optional<QuestionCore2> getById(Long id) {
        return this.questionCore2Repository.findById(id);
    }

    public long getEntityCount() {
        return this.questionCore2Repository.count();
    }
}

