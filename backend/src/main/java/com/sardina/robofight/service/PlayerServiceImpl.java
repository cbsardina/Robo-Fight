package com.sardina.robofight.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.sardina.robofight.model.Player;
import com.sardina.robofight.model.RoboQue;
import com.sardina.robofight.model.Robot;
import com.sardina.robofight.repository.PlayerRepository;
import com.sardina.robofight.repository.RoboQueRepository;
import com.sardina.robofight.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    RobotRepository robotRepository;

    @Autowired
    RoboQueRepository roboQueRepository;

 // -- Player transactions --
    @Transactional
    @Override
    public void add(Player player) {
        playerRepository.save(player);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Player> findAll() {
        List<Player> allPlayers = playerRepository.findAll();
        List<Player> leaderboard = allPlayers.stream().sorted().collect(Collectors.toList());

        return leaderboard;
    }

    @Transactional(readOnly = true)
    @Override
    public Player findPlayer(int id) {
        return playerRepository.findOne(id);
    }

    @Transactional
    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }

 // -- Robot transactions --
    @Override
    public void getTenAddTen() {
        List<Robot> allRobots =robotRepository.findAll();
        int i = 0;
        while(i<10) {
            Random r = new Random();
            int randomNum = r.nextInt(allRobots.size());
            RoboQue rQue = new RoboQue();
            Robot temp = allRobots.remove(randomNum);
                rQue.setName(temp.getName());
                rQue.setOccupation(temp.getOccupation());
                rQue.setCity(temp.getCity());
                rQue.setCountry(temp.getCountry());
                rQue.setAvatar(temp.getAvatar());
                    roboQueRepository.save(rQue);
            i++;
        }
    }

    @Override
    public RoboQue getOneDeleteOne() {
        List<RoboQue> currentQue = roboQueRepository.findAll();
        RoboQue nextRobot = currentQue.remove(0);

        int nexId = nextRobot.getId();
        roboQueRepository.delete(nexId);

        return nextRobot;
    }

    @Override
    public void deleteQue() {
        roboQueRepository.deleteAll();
    }
}

