package com.sardina.robofight.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "player")
public class Player {

    private int id;
    private String playerName;
    private int score;
    private List<RobotQue> robotQue = new ArrayList<>();
    private List<Robot> robots = new ArrayList<>();

  // -- POJO --
    public Player() {}

  // -- GETTERs/SETTERs --

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "playername")
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Column(name = "score")
    public int getScore() { return score; }

    public void setScore(int score) { this.score = score; }

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    public List<RobotQue> getRobotQue() { return robotQue; }

    public void setRobotQue(List<RobotQue> robotQue) { this.robotQue = robotQue; }

    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER)
    public List<Robot> getRobots() { return robots; }

    public void setRobots(List<Robot> robots) { this.robots = robots; }

    // ----------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return id == player.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

  // -- Override toString() --


    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                ", robotQue(Size)=" + robotQue.size() +
                ", robots(Size)=" + robots.size() +
                '}';
    }
}
