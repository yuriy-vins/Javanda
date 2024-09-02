package game.controller;

import game.service.impl.answers.AnswerCore2ServiceImpl;
import game.service.impl.questions.QuestionCore2ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionCore2Controller {

    @Autowired
    QuestionCore2ServiceImpl questionCore2ServiceImpl;
    @Autowired
    AnswerCore2ServiceImpl answerCore2ServiceImpl;

    private long entityCount;
    private long randomNumber;
    private long prevQuestionNumber;

    @GetMapping("/getQuestionCore2")
    public ResponseEntity<List> getQuestionCore2() {
        entityCount = questionCore2ServiceImpl.getEntityCount(); //-- Получаем количество записей в БД.
        randomNumber = (long) (Math.random()*entityCount+1);
        String question = questionCore2ServiceImpl.getById(randomNumber).get().getQuestion(); // получить вопрос из базы данных
        prevQuestionNumber = randomNumber; //--- Записать номер вопроса, для возвращения к этому вопросу после нажатия на кнопку НАЗАД.

        List<String> questionAndId = new ArrayList<>();
        questionAndId.add(question);
        questionAndId.add(Long.toString(prevQuestionNumber));
        return new ResponseEntity<List>(questionAndId, HttpStatus.OK);
    }

    @GetMapping("/getPrevQuestionCore2")
    public ResponseEntity<List> getPrevQuestionCore2() {

        String question = questionCore2ServiceImpl.getById(prevQuestionNumber).get().getQuestion(); // получить вопрос из базы данных

        List<String> questionAndId = new ArrayList<>();
        questionAndId.add(question);
        questionAndId.add(Long.toString(prevQuestionNumber));

        return new ResponseEntity<List>(questionAndId, HttpStatus.OK);
    }

    @GetMapping("/getAnswerCore2")
    public ResponseEntity<String> getAnswerCore2() {
        String answer = answerCore2ServiceImpl.getById(randomNumber).get().getAnswer(); // получить ответ из базы данных

        return new ResponseEntity<String>(answer, HttpStatus.OK);
    }


}

