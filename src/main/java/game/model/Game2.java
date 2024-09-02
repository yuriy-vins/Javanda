package game.model;

import game.model.answers.AnswerCore1;
import game.model.questions.QuestionCore1;
import org.springframework.beans.factory.annotation.Autowired;

public class Game2 {

    @Autowired
    QuestionCore1 question;

    @Autowired
    AnswerCore1 answer;

    public Game2() {
    }

    public Game2(QuestionCore1 question, AnswerCore1 answer) {
        this.question = question;
        this.answer = answer;
    }

    public QuestionCore1 getQuestion() {
        return question;
    }

    public void setQuestion(QuestionCore1 question) {
        this.question = question;
    }

    public AnswerCore1 getAnswer() {
        return answer;
    }

    public void setAnswer(AnswerCore1 answer) {
        this.answer = answer;
    }
}
