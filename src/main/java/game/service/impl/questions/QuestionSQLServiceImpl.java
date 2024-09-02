package game.service.impl.questions;

import game.model.questions.QuestionSQL;
import game.repository.questions.QuestionSQLRepository;
import game.service.interf.questions.QuestionSQLService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionSQLServiceImpl implements QuestionSQLService {
    private final QuestionSQLRepository questionSQLRepository;

    public QuestionSQLServiceImpl(QuestionSQLRepository questionSQLRepository) {
        this.questionSQLRepository = questionSQLRepository;
    }

    public void save(QuestionSQL questionSQL) {
        this.questionSQLRepository.save(questionSQL);
    }

    public void update(QuestionSQL questionSQL) {
        this.questionSQLRepository.save(questionSQL);
    }

    public Iterable<QuestionSQL> getAll() {
        return this.questionSQLRepository.findAll();
    }

    public void delete(QuestionSQL questionSQL) {
        this.questionSQLRepository.delete(questionSQL);
    }

    public void deleteByID(long id) {
        this.questionSQLRepository.deleteById(id);
    }

    public Optional<QuestionSQL> getById(Long id) {
        return this.questionSQLRepository.findById(id);
    }

    public long getEntityCount() {
        return this.questionSQLRepository.count();
    }
}

