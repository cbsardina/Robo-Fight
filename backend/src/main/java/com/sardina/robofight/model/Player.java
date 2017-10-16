package com.sardina.robofight.model;

import javax.persistence.*;

@Entity
@Table(name = "player")
public class Player {

    private int id;
    private String playerName;
    private int score;

  // -- POJO --
    public Player() {}

  // -- GETTERs/SETTERs --

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerName='" + playerName + '\'' +
                ", score=" + score +
                '}';
    }
}
