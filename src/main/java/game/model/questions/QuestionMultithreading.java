package game.model.questions;

import game.model.answers.AnswerMultithreading;
import jakarta.persistence.*;

@Entity
@Table(
        name = "questions_mt"
)
public class QuestionMultithreading {
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
    private AnswerMultithreading answer;

    public QuestionMultithreading() {
    }

    public QuestionMultithreading(int id, String question, String answer) {
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

    public AnswerMultithreading getAnswer() {
        return this.answer;
    }

    public void setAnswer(AnswerMultithreading answer) {
        this.answer = answer;
    }

    public String toString() {
        return "QuestionMultithreading{id=" + this.id + ", question='" + this.question + '\'' + ", answer=" + this.answer + '}';
    }
}

