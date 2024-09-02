package game.service.impl.questions;

import game.model.questions.QuestionHibernate;
import game.repository.questions.QuestionHibernateRepository;
import game.service.interf.questions.QuestionHibernateService;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class QuestionHibernateServiceImpl implements QuestionHibernateService {
    private final QuestionHibernateRepository questionHibernateRepository;

    public QuestionHibernateServiceImpl(QuestionHibernateRepository questionHibernateRepository) {
        this.questionHibernateRepository = questionHibernateRepository;
    }

    public void save(QuestionHibernate questionHibernate) {
        this.questionHibernateRepository.save(questionHibernate);
    }

    public void update(QuestionHibernate questionHibernate) {
        this.questionHibernateRepository.save(questionHibernate);
    }

    public Iterable<QuestionHibernate> getAll() {
        return this.questionHibernateRepository.findAll();
    }

    public void delete(QuestionHibernate questionHibernate) {
        this.questionHibernateRepository.delete(questionHibernate);
    }

    public void deleteByID(long id) {
        this.questionHibernateRepository.deleteById(id);
    }

    public Optional<QuestionHibernate> getById(Long id) {
        return this.questionHibernateRepository.findById(id);
    }

    public long getEntityCount() {
        return this.questionHibernateRepository.count();
    }
}

