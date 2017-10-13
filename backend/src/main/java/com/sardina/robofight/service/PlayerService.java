package com.sardina.robofight.service;

import com.sardina.robofight.model.Player;
import com.sardina.robofight.model.RoboQue;
import com.sardina.robofight.model.Robot;

import java.util.List;

public interface PlayerService {

    void add(Player player);
    List<Player> findAll();
    Player findPlayer(int id);
    void updatePlayer(Player player);

    void getTenAddTen();

    RoboQue getOneDeleteOne();
    void deleteQue();

}
