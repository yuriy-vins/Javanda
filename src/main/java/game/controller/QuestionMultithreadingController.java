package game.controller;

import game.service.impl.answers.AnswerMultithreadingServiceImpl;
import game.service.impl.questions.QuestionMultithreadingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class QuestionMultithreadingController {

    @Autowired
    QuestionMultithreadingServiceImpl questionMultithreadingServiceImpl;
    @Autowired
    AnswerMultithreadingServiceImpl answerMultithreadingServiceImpl;

    private long entityCount;
    private long randomNumber;
    private long prevQuestionNumber;

    @GetMapping("/getQuestionMultithreading")
    public ResponseEntity<List> getQuestion() {
        entityCount = questionMultithreadingServiceImpl.getEntityCount(); //-- Получаем количество записей в БД.
        randomNumber = (long) (Math.random()*entityCount+1);
        String question = questionMultithreadingServiceImpl.getById(randomNumber).get().getQuestion(); // получить вопрос из базы данных
        prevQuestionNumber = randomNumber; //--- Записать номер вопроса, для возвращения к этому вопросу после нажатия на кнопку НАЗАД.

        List<String> questionAndId = new ArrayList<>();
        questionAndId.add(question);
        questionAndId.add(Long.toString(prevQuestionNumber));
        return new ResponseEntity<List>(questionAndId, HttpStatus.OK);
    }

    @GetMapping("/getPrevQuestionMultithreading")
    public ResponseEntity<List> getPrevQuestion() {

        String question = questionMultithreadingServiceImpl.getById(prevQuestionNumber).get().getQuestion(); // получить вопрос из базы данных

        List<String> questionAndId = new ArrayList<>();
        questionAndId.add(question);
        questionAndId.add(Long.toString(prevQuestionNumber));

        return new ResponseEntity<List>(questionAndId, HttpStatus.OK);
    }

    @GetMapping("/getAnswerMultithreading")
    public ResponseEntity<String> getAnswer() {
        String answer = answerMultithreadingServiceImpl.getById(randomNumber).get().getAnswer(); // получить ответ из базы данных

        return new ResponseEntity<String>(answer, HttpStatus.OK);
    }


}

