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
    public void addPlayer(Player player) {
//        List<Player> allPlayers = playerRepository.findAll();
//        if(allPlayers.size() == 0) {
//            Player newPlayer = new Player();
//            newPlayer.setId(1);
//            newPlayer.setPlayerName(playerName);
//            playerRepository.save(newPlayer);
//        } else {
//            int newId = allPlayers.stream()
//                    .mapToInt(player -> player.getId())
//                    .max()
//                    .getAsInt();
//
//            Player player = new Player();
//                player.setId(newId + 1);
//                player.setPlayerName(playerName);
//            playerRepository.save(player);
//        }
        playerRepository.save(player);
    }

  // ----- findAll ---------------------
    @Transactional(readOnly = true)
    @Override
    public List<Player> findAllPlayers() {
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
    @Transactional
    @Override
    public void getTenAddTen() {
        List<Robot> allRobots =robotRepository.findAll();
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
            i++;
        }
    }

  // ----- getOneDeleteONe -----------------------
    @Transactional
    @Override
    public RobotQue removeOneDeleteOne() {
        List<RobotQue> wholeQue = robotQueRepository.findAll();
        RobotQue nextUp = wholeQue.remove(0);
            int deleteId = nextUp.getId();
        robotQueRepository.delete(deleteId);

        return nextUp;
    }

  // ------ deleteQue --------------------------
    @Transactional
    @Override
    public void deleteQue() {
        robotQueRepository.deleteAll();
    }


// -- FOR DEVELOPMENT -----
  // ++++ GET ALL ROBOTS +++++
    @Override
    public List<Robot> getAllRobots() {
        return robotRepository.findAll();
    }

    @Override
    public void deletePlayers() {
        playerRepository.deleteAll();
    }
}

