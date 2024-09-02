package game.model.questions;

import game.model.answers.AnswerHibernate;
import jakarta.persistence.*;

@Entity
@Table(
        name = "questions_hibernate"
)
public class QuestionHibernate {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(
            name = "question",
            columnDefinition = "TEXT"
    )
    private String question;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    @JoinColumn(
            name = "answer_id"
    )
    private AnswerHibernate answer;

    public QuestionHibernate() {
    }

    public QuestionHibernate(int id, String question, String answer) {
        this.id = (long)id;
        this.question = question;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public AnswerHibernate getAnswer() {
        return this.answer;
    }

    public void setAnswer(AnswerHibernate answer) {
        this.answer = answer;
    }

    public String toString() {
        return "QuestionHibernate{id=" + this.id + ", question='" + this.question + '\'' + ", answer=" + this.answer + '}';
    }
}

