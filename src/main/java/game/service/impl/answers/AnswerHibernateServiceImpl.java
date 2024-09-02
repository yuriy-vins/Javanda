package game.service.impl.answers;

import game.model.answers.AnswerHibernate;
import game.repository.answers.AnswerHibernateRepository;
import game.service.interf.answers.AnswerHibernateService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.*;

import java.util.Optional;

@Service
@Transactional
public class AnswerHibernateServiceImpl implements AnswerHibernateService {
    private final AnswerHibernateRepository answerHibernateRepository;

    public AnswerHibernateServiceImpl(AnswerHibernateRepository answerHibernateRepository) {
        this.answerHibernateRepository = answerHibernateRepository;
    }

    public void save(AnswerHibernate answerHibernate) {
        this.answerHibernateRepository.save(answerHibernate);
    }

    public void update(AnswerHibernate answerHibernate) {
        this.answerHibernateRepository.save(answerHibernate);
    }

    public Iterable<AnswerHibernate> getAll() {
        return this.answerHibernateRepository.findAll();
    }

    public void delete(AnswerHibernate answerHibernate) {
        this.answerHibernateRepository.delete(answerHibernate);
    }

    public void deleteByID(long id) {
        this.answerHibernateRepository.deleteById(id);
    }

    public Optional<AnswerHibernate> getById(Long id) {
        return this.answerHibernateRepository.findById(id);
    }

    public long getEntityCount() {
        return this.answerHibernateRepository.count();
    }
}

