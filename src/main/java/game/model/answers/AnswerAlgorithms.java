package game.model.answers;

import jakarta.persistence.*;

@Entity
@Table(
        name = "answers_algorithms"
)
public class AnswerAlgorithms {
    @Id
    @Column(
            name = "id"
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private long id;
    @Column(
            name = "answer",
            columnDefinition = "TEXT"
    )
    private String answer;

    public AnswerAlgorithms() {
    }

    public AnswerAlgorithms(int id, String question, String answer) {
        this.id = (long)id;
        this.answer = answer;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String toString() {
        return "AnswerAlgorithms{id=" + this.id + ", answer='" + this.answer + '\'' + '}';
    }
}

