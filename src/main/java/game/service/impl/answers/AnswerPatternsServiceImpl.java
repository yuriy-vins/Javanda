package game.service.impl.answers;

import game.model.answers.AnswerPatterns;
import game.repository.answers.AnswerPatternsRepository;
import game.service.interf.answers.AnswerPatternsService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerPatternsServiceImpl implements AnswerPatternsService {
    private final AnswerPatternsRepository answerPatternsRepository;

    public AnswerPatternsServiceImpl(AnswerPatternsRepository answerPatternsRepository) {
        this.answerPatternsRepository = answerPatternsRepository;
    }

    public void save(AnswerPatterns answerPatterns) {
        this.answerPatternsRepository.save(answerPatterns);
    }

    public void update(AnswerPatterns answerPatterns) {
        this.answerPatternsRepository.save(answerPatterns);
    }

    public Iterable<AnswerPatterns> getAll() {
        return this.answerPatternsRepository.findAll();
    }

    public void delete(AnswerPatterns answerPatterns) {
        this.answerPatternsRepository.delete(answerPatterns);
    }

    public void deleteByID(long id) {
        this.answerPatternsRepository.deleteById(id);
    }

    public Optional<AnswerPatterns> getById(Long id) {
        return this.answerPatternsRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerPatternsRepository.count();
    }
}
