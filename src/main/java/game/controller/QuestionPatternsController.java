package game.controller;

import game.service.impl.answers.AnswerPatternsServiceImpl;
import game.service.impl.questions.QuestionPatternsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionPatternsController {

    @Autowired
    QuestionPatternsServiceImpl questionPatternsServiceImpl;
    @Autowired
    AnswerPatternsServiceImpl answerPatternsServiceImpl;

    private long entityCount;
    private long randomNumber;
    private long prevQuestionNumber;

    @GetMapping("/getQuestionPatterns")
    public ResponseEntity<List> getQuestion() {
        entityCount = questionPatternsServiceImpl.getEntityCount(); //-- Получаем количество записей в БД.
        randomNumber = (long) (Math.random()*entityCount+1);
        String question = questionPatternsServiceImpl.getById(randomNumber).get().getQuestion(); // получить вопрос из базы данных
        prevQuestionNumber = randomNumber; //--- Записать номер вопроса, для возвращения к этому вопросу после нажатия на кнопку НАЗАД.

        List<String> questionAndId = new ArrayList<>();
        questionAndId.add(question);
        questionAndId.add(Long.toString(prevQuestionNumber));
        return new ResponseEntity<List>(questionAndId, HttpStatus.OK);
    }

    @GetMapping("/getPrevQuestionPatterns")
    public ResponseEntity<List> getPrevQuestion() {

        String question = questionPatternsServiceImpl.getById(prevQuestionNumber).get().getQuestion(); // получить вопрос из базы данных

        List<String> questionAndId = new ArrayList<>();
        questionAndId.add(question);
        questionAndId.add(Long.toString(prevQuestionNumber));

        return new ResponseEntity<List>(questionAndId, HttpStatus.OK);
    }

    @GetMapping("/getAnswerPatterns")
    public ResponseEntity<String> getAnswer() {
        String answer = answerPatternsServiceImpl.getById(randomNumber).get().getAnswer(); // получить ответ из базы данных

        return new ResponseEntity<String>(answer, HttpStatus.OK);
    }


}

