package game.service.impl.answers;

import game.model.answers.AnswerSQL;
import game.repository.answers.AnswerSQLRepository;
import game.service.interf.answers.AnswerSQLService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerSQLServiceImpl implements AnswerSQLService {
    private final AnswerSQLRepository answerSQLRepository;

    public AnswerSQLServiceImpl(AnswerSQLRepository answerSQLRepository) {
        this.answerSQLRepository = answerSQLRepository;
    }

    public void save(AnswerSQL answerSQL) {
        this.answerSQLRepository.save(answerSQL);
    }

    public void update(AnswerSQL answerSQL) {
        this.answerSQLRepository.save(answerSQL);
    }

    public Iterable<AnswerSQL> getAll() {
        return this.answerSQLRepository.findAll();
    }

    public void delete(AnswerSQL answerSQL) {
        this.answerSQLRepository.delete(answerSQL);
    }

    public void deleteByID(long id) {
        this.answerSQLRepository.deleteById(id);
    }

    public Optional<AnswerSQL> getById(Long id) {
        return this.answerSQLRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerSQLRepository.count();
    }
}

