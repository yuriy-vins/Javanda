package game.model.questions;

import game.model.answers.AnswerSpring;
import jakarta.persistence.*;

@Entity
@Table(
        name = "questions_spring"
)
public class QuestionSpring {
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
    private AnswerSpring answer;

    public QuestionSpring() {
    }

    public QuestionSpring(int id, String question, String answer) {
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

    public AnswerSpring getAnswer() {
        return this.answer;
    }

    public void setAnswer(AnswerSpring answer) {
        this.answer = answer;
    }

    public String toString() {
        return "QuestionSpring{id=" + this.id + ", question='" + this.question + '\'' + ", answer=" + this.answer + '}';
    }
}

