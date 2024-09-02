package game.service.impl.questions;

import game.model.questions.QuestionSpring;
import game.repository.questions.QuestionSpringRepository;
import game.service.interf.questions.QuestionSpringService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionSpringServiceImpl implements QuestionSpringService {
    private final QuestionSpringRepository questionSpringRepository;

    public QuestionSpringServiceImpl(QuestionSpringRepository questionSpringRepository) {
        this.questionSpringRepository = questionSpringRepository;
    }

    public void save(QuestionSpring questionSpring) {
        this.questionSpringRepository.save(questionSpring);
    }

    public void update(QuestionSpring questionSpring) {
        this.questionSpringRepository.save(questionSpring);
    }

    public Iterable<QuestionSpring> getAll() {
        return this.questionSpringRepository.findAll();
    }

    public void delete(QuestionSpring questionSpring) {
        this.questionSpringRepository.delete(questionSpring);
    }

    public void deleteByID(long id) {
        this.questionSpringRepository.deleteById(id);
    }

    public Optional<QuestionSpring> getById(Long id) {
        return this.questionSpringRepository.findById(id);
    }

    public long getEntityCount() {
        return this.questionSpringRepository.count();
    }
}

