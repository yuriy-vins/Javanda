package game.service.impl.answers;

import game.model.answers.AnswerAlgorithms;
import game.repository.answers.AnswerAlgorithmsRepository;
import game.service.interf.answers.AnswerAlgorithmsService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerAlgorithmsServiceImpl implements AnswerAlgorithmsService {
    private final AnswerAlgorithmsRepository answerAlgorithmsRepository;

    public AnswerAlgorithmsServiceImpl(AnswerAlgorithmsRepository answerAlgorithmsRepository) {
        this.answerAlgorithmsRepository = answerAlgorithmsRepository;
    }

    public void save(AnswerAlgorithms answerAlgorithms) {
        this.answerAlgorithmsRepository.save(answerAlgorithms);
    }

    public void update(AnswerAlgorithms answerAlgorithms) {
        this.answerAlgorithmsRepository.save(answerAlgorithms);
    }

    public Iterable<AnswerAlgorithms> getAll() {
        return this.answerAlgorithmsRepository.findAll();
    }

    public void delete(AnswerAlgorithms answerAlgorithms) {
        this.answerAlgorithmsRepository.delete(answerAlgorithms);
    }

    public void deleteByID(long id) {
        this.answerAlgorithmsRepository.deleteById(id);
    }

    public Optional<AnswerAlgorithms> getById(Long id) {
        return this.answerAlgorithmsRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerAlgorithmsRepository.count();
    }
}

