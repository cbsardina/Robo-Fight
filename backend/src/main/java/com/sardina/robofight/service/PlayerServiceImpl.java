package com.sardina.robofight.service;


import com.sardina.robofight.model.Player;
import com.sardina.robofight.model.RobotQue;
import com.sardina.robofight.model.Robot;
import com.sardina.robofight.repository.PlayerRepository;
import com.sardina.robofight.repository.RobotQueRepository;
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
    RobotQueRepository robotQueRepository;

// ====================================
// ======= Player transactions ========

  // ----- add --------------------
    @Transactional
    @Override
    public void add(Player player) {
        playerRepository.save(player);
    }


  // ----- findAll ---------------------
    @Transactional(readOnly = true)
    @Override
    public List<Player> findAll() {
        List<Player> allPlayers = playerRepository.findAll();
        List<Player> leaderboard = allPlayers.stream().sorted().collect(Collectors.toList());

        return leaderboard;
    }

  // ----- findPlayerById -------------------
    @Transactional(readOnly = true)
    @Override
    public Player findPlayerById(int id) {
        return playerRepository.findOne(id);
    }

  // ----- updatePlayer ----------------------
    @Transactional
    @Override
    public void updatePlayer(Player player) {
        playerRepository.save(player);
    }


//===============================
// ==== Robot transactions =====

  // ----- getTenAddTen -------------------
    @Transactional(readOnly = true)
    @Override
    public void getTenAddTen(int id) {
        List<Robot> allRobots =robotRepository.findAll();
        List<RobotQue> tempList = new ArrayList<>();
        int i = 0;
        while(i<10) {
            Random r = new Random();
            int randomNum = r.nextInt(allRobots.size());
            Robot temp = allRobots.remove(randomNum);
            RobotQue rQue = new RobotQue();
                rQue.setName(temp.getName());
                rQue.setOccupation(temp.getOccupation());
                rQue.setCity(temp.getCity());
                rQue.setCountry(temp.getCountry());
                rQue.setAvatar(temp.getAvatar());
                    robotQueRepository.save(rQue);
                Player player = playerRepository.findOne(id);
                player.getRobotQue().add(rQue);
                    playerRepository.save(player);
            i++;
        }
    }

  // ----- getOneDeleteONe -----------------------
    @Transactional(readOnly = true)
    @Override
    public RobotQue removeOneQue(int id) {
        Player player = playerRepository.findOne(id);
        List<RobotQue> wholeQue = robotQueRepository.findAll();

        RobotQue nextRobot =
                wholeQue.stream()
                    .findFirst()
                    .filter(robotQue -> robotQue.getPlayer().)
                //TODO: PICK UP ON THIS!!!
                player.getRobotQue().remove(i);

        return nextRobot;
    }

  // ------ deleteQue --------------------------
    @Transactional
    @Override
    public void deleteQue(int id) {
        Player player = playerRepository.findOne(id);
            player.getRobotQue().clear();

        robotQueRepository.deleteAll();
    }
}

