package com.sardina.robofight.controller;


import com.sardina.robofight.model.Player;
import com.sardina.robofight.model.Robot;
import com.sardina.robofight.model.RobotQue;
import com.sardina.robofight.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 10000)
@RestController
public class PlayerControllerApi {

    @Autowired
    PlayerService playerservice;

    @PostMapping("/api/new_player")
    public String  addPlayerSetupGame(@RequestParam String newPlayer) {
        Player addPlayer = new Player();
        addPlayer.setPlayerName(newPlayer);
            playerservice.add(addPlayer);

        List<Player> allPlayers = playerservice.findAll();
        int lastPlayerId =
                allPlayers.stream()
                        .mapToInt(p -> p.getId())
                        .max()
                        .getAsInt();
        Player currentPlayer = playerservice.findPlayerById(lastPlayerId);
            Integer playerId = currentPlayer.getId();

        return playerId.toString();
    }

    @GetMapping("/api/start_game")
    public String setQueAndGetOne() {

        playerservice.getTenAddTen();
        RobotQue firstRobot = playerservice.getOneDeleteOne();

    }



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
