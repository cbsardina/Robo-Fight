package com.sardina.robofight.service;

import com.sardina.robofight.model.Robot;

import java.util.List;
import java.util.Optional;

public interface RobotService {

    Robot getById(int id);
    List<Robot> getAll();
    Optional<Robot> getTen();
    void delete(int id);
    void addTen(List<Robot> robots);

}
