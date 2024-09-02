package game.model.questions;

import game.model.answers.AnswerCore1;
import jakarta.persistence.*;

@Entity
@Table(
        name = "questions_core2"
)
public class QuestionCore2 {
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
    private AnswerCore1 answer;

    public QuestionCore2() {
    }

    public QuestionCore2(int id, String question, String answer) {
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

    public AnswerCore1 getAnswer() {
        return this.answer;
    }

    public void setAnswer(AnswerCore1 answer) {
        this.answer = answer;
    }

    public String toString() {
        return "Question{id=" + this.id + ", question='" + this.question + '\'' + ", answer=" + this.answer + '}';
    }
}

