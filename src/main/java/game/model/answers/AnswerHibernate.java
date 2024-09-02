package game.model.answers;

import jakarta.persistence.*;

@Entity
@Table(
        name = "answers_hibernate"
)
public class AnswerHibernate {
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

    public AnswerHibernate() {
    }

    public AnswerHibernate(int id, String question, String answer) {
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
        return "AnswerHibernate{id=" + this.id + ", answer='" + this.answer + '\'' + '}';
    }
}
