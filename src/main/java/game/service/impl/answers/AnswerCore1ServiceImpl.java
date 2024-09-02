package game.service.impl.answers;

import game.model.answers.AnswerCore1;
import game.repository.answers.AnswerCore1Repository;
import game.service.interf.answers.AnswerCore1Service;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerCore1ServiceImpl implements AnswerCore1Service {
    private final AnswerCore1Repository answerRepository;

    public AnswerCore1ServiceImpl(AnswerCore1Repository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public void save(AnswerCore1 answer) {
        this.answerRepository.save(answer);
    }

    public void update(AnswerCore1 answer) {
        this.answerRepository.save(answer);
    }

    public Iterable<AnswerCore1> getAll() {
        return this.answerRepository.findAll();
    }

    public void delete(AnswerCore1 answer) {
        this.answerRepository.delete(answer);
    }

    public void deleteByID(long id) {
        this.answerRepository.deleteById(id);
    }

    public Optional<AnswerCore1> getById(Long id) {
        return this.answerRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerRepository.count();
    }
}

