package game.service.impl.answers;

import game.model.answers.AnswerMultithreading;
import game.repository.answers.AnswerMultithreadingRepository;
import game.service.interf.answers.AnswerMultithreadingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerMultithreadingServiceImpl implements AnswerMultithreadingService {
    private final AnswerMultithreadingRepository answerMultithreadingRepository;

    public AnswerMultithreadingServiceImpl(AnswerMultithreadingRepository answerMultithreadingRepository) {
        this.answerMultithreadingRepository = answerMultithreadingRepository;
    }

    public void save(AnswerMultithreading answerMultithreading) {
        this.answerMultithreadingRepository.save(answerMultithreading);
    }

    public void update(AnswerMultithreading answerMultithreading) {
        this.answerMultithreadingRepository.save(answerMultithreading);
    }

    public Iterable<AnswerMultithreading> getAll() {
        return this.answerMultithreadingRepository.findAll();
    }

    public void delete(AnswerMultithreading answerMultithreading) {
        this.answerMultithreadingRepository.delete(answerMultithreading);
    }

    public void deleteByID(long id) {
        this.answerMultithreadingRepository.deleteById(id);
    }

    public Optional<AnswerMultithreading> getById(Long id) {
        return this.answerMultithreadingRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerMultithreadingRepository.count();
    }
}

