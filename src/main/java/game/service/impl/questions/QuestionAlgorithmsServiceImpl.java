package game.service.impl.questions;

import game.model.questions.QuestionAlgorithms;
import game.repository.questions.QuestionAlgorithmsRepository;
import game.service.interf.questions.QuestionAlgorithmsService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionAlgorithmsServiceImpl implements QuestionAlgorithmsService {
    private final QuestionAlgorithmsRepository questionAlgorithmsRepository;

    public QuestionAlgorithmsServiceImpl(QuestionAlgorithmsRepository questionAlgorithmsRepository) {
        this.questionAlgorithmsRepository = questionAlgorithmsRepository;
    }

    public void save(QuestionAlgorithms questionAlgorithms) {
        this.questionAlgorithmsRepository.save(questionAlgorithms);
    }

    public void update(QuestionAlgorithms questionAlgorithms) {
        this.questionAlgorithmsRepository.save(questionAlgorithms);
    }

    public Iterable<QuestionAlgorithms> getAll() {
        return this.questionAlgorithmsRepository.findAll();
    }

    public void delete(QuestionAlgorithms questionAlgorithms) {
        this.questionAlgorithmsRepository.delete(questionAlgorithms);
    }

    public void deleteByID(long id) {
        this.questionAlgorithmsRepository.deleteById(id);
    }

    public Optional<QuestionAlgorithms> getById(Long id) {
        return this.questionAlgorithmsRepository.findById(id);
    }

    public long getEntityCount() {
        return this.questionAlgorithmsRepository.count();
    }
}
