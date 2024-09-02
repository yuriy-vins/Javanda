package game.model.questions;

import game.model.answers.AnswerAlgorithms;
import jakarta.persistence.*;

@Entity
@Table(
        name = "questions_algorithms"
)
public class QuestionAlgorithms {
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
    private AnswerAlgorithms answer;

    public QuestionAlgorithms() {
    }

    public QuestionAlgorithms(int id, String question, String answer) {
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

    public AnswerAlgorithms getAnswer() {
        return this.answer;
    }

    public void setAnswer(AnswerAlgorithms answer) {
        this.answer = answer;
    }

    public String toString() {
        return "QuestionAlgorithms{id=" + this.id + ", question='" + this.question + '\'' + ", answer=" + this.answer + '}';
    }
}

