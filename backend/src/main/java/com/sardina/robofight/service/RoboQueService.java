package com.sardina.robofight.service;

import com.sardina.robofight.model.RoboQue;
import com.sardina.robofight.model.Robot;

import java.util.List;
import java.util.Optional;

public interface RoboQueService {

    void addTenToRoboQue (List<RoboQue> robots);
    RoboQue getOneRandom ();
    void deleteAll ();

}
