package com.sardina.robofight.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "roboque")
public class RoboQue {

    // -- POJO --

    private String skill3;
    public RoboQue() {}

    private Player player;
    private int id;
    private String name;
    private String occupation;
    private String city;
    private String country;
    private String avatar;
    private String skill1;
    private String skill2;


    // -- GETTERs/SETTERs --

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "player_id")
    public Player getPlayer() { return player; }

    public void setPlayer(Player player) { this.player = player; }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() { return id; }

    public void setId(int id) {
        this.id = id; }

    @Column(name = "name")
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    @Column(name = "occupation")
    public String getOccupation() { return occupation; }

    public void setOccupation(String occupation) { this.occupation = occupation; }

    @Column(name = "city")
    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    @Column(name = "country")
    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    @Column(name = "avatar")
    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    @Column(name = "skill1")
    public String getSkill1() { return skill1; }

    public void setSkill1(String skill1) { this.skill1 = skill1; }

    @Column(name = "skill2")
    public String getSkill2() { return skill2; }

    public void setSkill2(String skill2) { this.skill2 = skill2; }

    @Column(name = "skill3")
    public String getSkill3() { return skill3; }

    public void setSkill3(String skill3) { this.skill3 = skill3; }

    // --------------------------------------------
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoboQue roboQue = (RoboQue) o;

        return id == roboQue.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    // -- toString() --

    @Override
    public String toString() {
        return "RoboQue{" +
                "player=" + player +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", avatar='" + avatar + '\'' +
                ", skill1='" + skill1 + '\'' +
                ", skill2='" + skill2 + '\'' +
                ", skill3='" + skill3 + '\'' +
                '}';
    }



}
