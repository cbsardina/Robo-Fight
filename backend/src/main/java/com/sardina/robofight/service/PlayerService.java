package com.sardina.robofight.service;

import com.sardina.robofight.model.Player;
import com.sardina.robofight.model.RobotQue;

import java.util.List;

public interface PlayerService {

    void add(Player player);
    List<Player> findAll();
    Player findPlayerById(int id);
    void updatePlayer(Player player);

    void getTenAddTen(int id);

    RobotQue removeOneQue(int id);
    void deleteQue(int id);

}
