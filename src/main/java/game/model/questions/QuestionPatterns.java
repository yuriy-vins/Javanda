package game.model.questions;

import game.model.answers.AnswerPatterns;
import jakarta.persistence.*;

@Entity
@Table(
        name = "questions_patterns"
)
public class QuestionPatterns {
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
    private AnswerPatterns answer;

    public QuestionPatterns() {
    }

    public QuestionPatterns(int id, String question, String answer) {
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

    public AnswerPatterns getAnswer() {
        return this.answer;
    }

    public void setAnswer(AnswerPatterns answer) {
        this.answer = answer;
    }

    public String toString() {
        return "QuestionPatterns{id=" + this.id + ", question='" + this.question + '\'' + ", answer=" + this.answer + '}';
    }
}
