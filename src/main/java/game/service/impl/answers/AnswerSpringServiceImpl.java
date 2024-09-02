package game.service.impl.answers;

import game.model.answers.AnswerSpring;
import game.repository.answers.AnswerSpringRepository;
import game.service.interf.answers.AnswerSpringService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerSpringServiceImpl implements AnswerSpringService {
    private final AnswerSpringRepository answerSpringRepository;

    public AnswerSpringServiceImpl(AnswerSpringRepository answerSpringRepository) {
        this.answerSpringRepository = answerSpringRepository;
    }

    public void save(AnswerSpring answerSpring) {
        this.answerSpringRepository.save(answerSpring);
    }

    public void update(AnswerSpring answerSpring) {
        this.answerSpringRepository.save(answerSpring);
    }

    public Iterable<AnswerSpring> getAll() {
        return this.answerSpringRepository.findAll();
    }

    public void delete(AnswerSpring answerSpring) {
        this.answerSpringRepository.delete(answerSpring);
    }

    public void deleteByID(long id) {
        this.answerSpringRepository.deleteById(id);
    }

    public Optional<AnswerSpring> getById(Long id) {
        return this.answerSpringRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerSpringRepository.count();
    }
}

