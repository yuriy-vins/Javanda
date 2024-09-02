package game.service.impl.questions;

import game.model.questions.QuestionMultithreading;
import game.repository.questions.QuestionMultithreadingRepository;
import game.service.interf.questions.QuestionMultithreadingService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionMultithreadingServiceImpl implements QuestionMultithreadingService {
    private final QuestionMultithreadingRepository questionMultithreadingRepository;

    public QuestionMultithreadingServiceImpl(QuestionMultithreadingRepository questionMultithreadingRepository) {
        this.questionMultithreadingRepository = questionMultithreadingRepository;
    }

    public void save(QuestionMultithreading questionMultithreading) {
        this.questionMultithreadingRepository.save(questionMultithreading);
    }

    public void update(QuestionMultithreading questionMultithreading) {
        this.questionMultithreadingRepository.save(questionMultithreading);
    }

    public Iterable<QuestionMultithreading> getAll() {
        return this.questionMultithreadingRepository.findAll();
    }

    public void delete(QuestionMultithreading questionMultithreading) {
        this.questionMultithreadingRepository.delete(questionMultithreading);
    }

    public void deleteByID(long id) {
        this.questionMultithreadingRepository.deleteById(id);
    }

    public Optional<QuestionMultithreading> getById(Long id) {
        return this.questionMultithreadingRepository.findById(id);
    }

    public long getEntityCount() {
        return this.questionMultithreadingRepository.count();
    }
}

