package com.sardina.robofight.service;

import com.sardina.robofight.model.Player;
import com.sardina.robofight.model.Robot;
import com.sardina.robofight.model.RobotQue;

import java.util.List;

public interface PlayerService {

    void addPlayer(Player player);
    List<Player> findAllPlayers();
    Player findPlayerById(int id);
    void updatePlayer(Player player);
    List<Robot> getAllRobots();

    void getTenAddTen();

    RobotQue removeOneDeleteOne();
    void deleteQue();
    void deletePlayers();

}
