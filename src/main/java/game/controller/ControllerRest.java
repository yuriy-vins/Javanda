package game.controller;

import game.model.questions.QuestionCore1;
import game.service.impl.questions.QuestionCore1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class ControllerRest {

    @Autowired
    QuestionCore1ServiceImpl gameServiceImpl;

    @GetMapping("gamelist")
    public Iterable<QuestionCore1> getGames(){

        Iterable<QuestionCore1> gameList = gameServiceImpl.getAll();

        return gameList;
    }

}
