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
    @GetMapping("/api/new_game")
    public String setUpGame() {
      // -- set up Que --
        playerservice.getTenAddTen();

        return "OK";
    }

  // - get a robot from que -
    @GetMapping("/api/get_robot")
    public RobotQue getOne() {
        return playerservice.removeOneDeleteOne();
    }

  // -
    @PostMapping("/api/end_game")
    public List<Player> endGameClearQueGetLeaderboard(@RequestBody Player player) {
      // - get player from db, update score, save to db
        Player newPlayer = new Player();
            newPlayer.setPlayerName(player.getPlayerName());
            newPlayer.setScore(player.getScore());
        playerservice.addPlayer(newPlayer);
      // - delete que to end game and for next game
        playerservice.deleteQue();
      // - get all players for leaderboard
        return playerservice.findAllPlayers();
    }

    @GetMapping("/api/listAllPlayers")
    public List<Player> listAllPlayers() {
        return playerservice.findAllPlayers();
    }

    @DeleteMapping("/api/deletePlayers")
    public String deletePlayerDb() {
        playerservice.deletePlayers();
        return "PLAYERS DELETED";
    }
    @GetMapping("/api/getAllRobots")
    public List<Robot> getAllRobots() {
        return playerservice.getAllRobots();
    }
}
