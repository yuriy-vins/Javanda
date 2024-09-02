package game.controller;


import game.model.answers.AnswerCore1;
import game.model.Game2;
import game.model.questions.QuestionCore1;
import game.service.impl.answers.AnswerCore1ServiceImpl;
import game.service.impl.questions.QuestionCore1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GameController {

    @Autowired
    QuestionCore1ServiceImpl questionServiceImpl;
    @Autowired
    AnswerCore1ServiceImpl answerServiceImpl;

    @GetMapping("/")
    public String indexController(){
        return "index";
    }

    @GetMapping("/games")
    public String games(Model model) {
        List<AnswerCore1> answers = (List<AnswerCore1>) answerServiceImpl.getAll();
        List<QuestionCore1> questions = (List<QuestionCore1>) questionServiceImpl.getAll();

        List<Game2> questionAnswerWrappers = new ArrayList<>();

        // Сопоставьте вопросы и ответы в объекты Game2
        for (int i = 0; i < questions.size(); i++) {
            QuestionCore1 question = questions.get(i);
            AnswerCore1 answer = answers.get(i);
            Game2 wrapper = new Game2(question, answer);
            questionAnswerWrappers.add(wrapper);
        }

        model.addAttribute("games", questionAnswerWrappers);

        return "games";
    }

    @GetMapping("/games/save")
    public String getForms() {
        return "forms";
    }

    @GetMapping("/games/delete/{id}")
    public String showDeleteConfirmationPage(@PathVariable("id") long id, Model model) {
        QuestionCore1 question = questionServiceImpl.getById(id).get();
        model.addAttribute("game", question);
        return "delete";
    }

    @PostMapping("/games/delete/{id}")
    public String deleteGame(@PathVariable("id") long id) {
        questionServiceImpl.deleteByID(id);
        return "redirect:/games";
    }

    @GetMapping("/games/edit/{id}")
    public String showEditGameForm(@PathVariable("id") long id, Model model) {
        QuestionCore1 question = questionServiceImpl.getById(id).get();
        AnswerCore1 answer = answerServiceImpl.getById(id).get();
        Game2 gameForm = new Game2();
        gameForm.setQuestion(question);
        gameForm.setAnswer(answer);
        model.addAttribute("gameForm", gameForm);
        return "edit";
    }

    @PostMapping("/games/save")
    public String saveGame(@RequestParam("question") String question,
                           @RequestParam("answer") String answer) {
        // Создание объектов Question и Answer и сохранение их
        AnswerCore1 answerObj = new AnswerCore1();
        answerObj.setAnswer(answer);

        QuestionCore1 questionObj = new QuestionCore1();
        questionObj.setQuestion(question);
        questionObj.setAnswer(answerObj);

        answerServiceImpl.save(answerObj);
        questionServiceImpl.save(questionObj);
        return "redirect:/games";
    }


    @PostMapping("/games/update")
    public String updateGame(@ModelAttribute("game") QuestionCore1 question) {
        questionServiceImpl.save(question);
        return "redirect:/games";
    }
}
