package com.sardina.robofight.model;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "roboque")
public class RoboQue {

    private Player player;
    private int id;
    private String name;
    private String occupation;
    private String city;
    private String country;
    private String avatar;
    private String skill1;
    private String skill2;
    private String skill3;

    public Player getPlayer() { return player; }

    public void setPlayer(Player player) { this.player = player; }

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getOccupation() { return occupation; }

    public void setOccupation(String occupation) { this.occupation = occupation; }

    public String getCity() { return city; }

    public void setCity(String city) { this.city = city; }

    public String getCountry() { return country; }

    public void setCountry(String country) { this.country = country; }

    public String getAvatar() { return avatar; }

    public void setAvatar(String avatar) { this.avatar = avatar; }

    public String getSkill1() { return skill1; }

    public void setSkill1(String skill1) { this.skill1 = skill1; }

    public String getSkill2() { return skill2; }

    public void setSkill2(String skill2) { this.skill2 = skill2; }

    public String getSkill3() { return skill3; }

    public void setSkill3(String skill3) { this.skill3 = skill3; }
}
