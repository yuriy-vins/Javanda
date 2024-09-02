package game.service.impl.answers;

import game.model.answers.AnswerCore2;
import game.repository.answers.AnswerCore2Repository;
import game.service.interf.answers.AnswerCore2Service;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerCore2ServiceImpl implements AnswerCore2Service {
    private final AnswerCore2Repository answerCore2Repository;

    public AnswerCore2ServiceImpl(AnswerCore2Repository answerCore2Repository) {
        this.answerCore2Repository = answerCore2Repository;
    }

    public void save(AnswerCore2 answer) {
        this.answerCore2Repository.save(answer);
    }

    public void update(AnswerCore2 answer) {
        this.answerCore2Repository.save(answer);
    }

    public Iterable<AnswerCore2> getAll() {
        return this.answerCore2Repository.findAll();
    }

    public void delete(AnswerCore2 answer) {
        this.answerCore2Repository.delete(answer);
    }

    public void deleteByID(long id) {
        this.answerCore2Repository.deleteById(id);
    }

    public Optional<AnswerCore2> getById(Long id) {
        return this.answerCore2Repository.findById(id);
    }

    public long getEntityCount() {
        return this.answerCore2Repository.count();
    }
}

