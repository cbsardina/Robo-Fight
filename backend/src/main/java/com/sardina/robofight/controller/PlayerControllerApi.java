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

  // - set up new game: add player to db & return id; create new robot Que
    @PostMapping("/api/new_game")
    public String addPlayerSetupGame(@RequestParam String newPlayer) {

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
      // - set up que --
        playerservice.getTenAddTen();

        return playerId.toString();
    }

  // - get a robot from que -
    @GetMapping("/api/get_robot")
    public RobotQue getOne() {
        return playerservice.removeOneDeleteOne();
    }

  // -
    @PostMapping("/api/end_game")
    public List<Player> endGameClearQueGetLeaderboard(@RequestParam int id, @RequestParam int score) {
      // - get player from db, update score, save to db
        Player player = playerservice.findPlayerById(id);
            player.setScore(score);
        playerservice.updatePlayer(player);
      // - delete que to end game and for next game
        playerservice.deleteQue();
      // - get all players for leaderboard
        return playerservice.findAll();
    }
}
