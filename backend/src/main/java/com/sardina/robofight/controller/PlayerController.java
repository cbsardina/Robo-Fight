package com.sardina.robofight.controller;


import com.sardina.robofight.model.Player;
import com.sardina.robofight.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 10000)
@RestController
public class PlayerController {

    @Autowired
    PlayerService playerservice;

    @RequestMapping(value = "/api/add_score", method = RequestMethod.POST)
    public void addScore(@RequestParam String name, @RequestParam int score) {
        Player newScore = new Player();
            newScore.setPlayerName(name);
            newScore.setScore(score);

            playerservice.add(newScore);
    }

    @RequestMapping(value = "/api/leaderboard", method = RequestMethod.GET)
    public List<Player> getLeaderBoard() {
        List<Player> leaderBoard = playerservice.getAll();

        return leaderBoard;
    }
}
