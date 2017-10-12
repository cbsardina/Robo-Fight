package com.sardina.robofight.controller;

import com.sardina.robofight.model.Robot;
import com.sardina.robofight.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 10000)
@RestController
public class RobotController {

    @Autowired
    RobotService robotService;

    @RequestMapping(value = "/api/index", method = RequestMethod.GET)
    public List<Robot> allRobots() {
        List<Robot> robos = robotService.getAll();

        return robos;
    }

    @RequestMapping(value = "/api/set_one", method = RequestMethod.GET)
    public Robot getOneRoboToFight(){
        Robot robo = new Robot();

        return robo;
    }

    @RequestMapping(value = "/api/delete/{id}", method = RequestMethod.DELETE)
    public void deleteRobo(@PathVariable("id") int roboId){
        //TODO: robotService.delete(roboID)
    }


}
