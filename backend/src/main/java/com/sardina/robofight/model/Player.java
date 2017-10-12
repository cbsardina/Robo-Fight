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
    private List<RoboQue> roboQue = new ArrayList<>();

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
    public List<RoboQue> getRoboQue() { return roboQue; }

    public void setRoboQue(List<RoboQue> roboQue) { this.roboQue = roboQue; }

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
                ", roboQue=" + roboQue +
                '}';
    }
}
