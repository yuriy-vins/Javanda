package game.service.impl.questions;

import game.model.questions.QuestionPatterns;
import game.repository.questions.QuestionPatternsRepository;
import game.service.interf.questions.QuestionPatternsService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionPatternsServiceImpl implements QuestionPatternsService {
    private final QuestionPatternsRepository questionPatternsRepository;

    public QuestionPatternsServiceImpl(QuestionPatternsRepository questionPatternsRepository) {
        this.questionPatternsRepository = questionPatternsRepository;
    }

    public void save(QuestionPatterns questionPatterns) {
        this.questionPatternsRepository.save(questionPatterns);
    }

    public void update(QuestionPatterns questionPatterns) {
        this.questionPatternsRepository.save(questionPatterns);
    }

    public Iterable<QuestionPatterns> getAll() {
        return this.questionPatternsRepository.findAll();
    }

    public void delete(QuestionPatterns questionPatterns) {
        this.questionPatternsRepository.delete(questionPatterns);
    }

    public void deleteByID(long id) {
        this.questionPatternsRepository.deleteById(id);
    }

    public Optional<QuestionPatterns> getById(Long id) {
        return this.questionPatternsRepository.findById(id);
    }

    public long getEntityCount() {
        return this.questionPatternsRepository.count();
    }
}

