package com.sardina.robofight.service;

import com.sardina.robofight.model.Robot;
import com.sardina.robofight.repository.RobotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RobotServiceImpl implements RobotService {

    @Autowired
    RobotRepository robotRepository;

    @Transactional(readOnly = true)
    @Override
    public Robot getById(int id) {

        return robotRepository.getOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Robot> getAll() {
        return robotRepository.findAll();
    }

    @Transactional
    @Override
    public Optional<Robot> getTen() {
        List<Robot> allRobots = robotRepository.findAll();
        Optional<Robot> tenRandom =
                allRobots.stream()
                    .limit(10)
                    .findAny();
        return tenRandom;

    }

    @Override
    public void addTen(List<Robot> robots) {
        robots.stream()
                .forEach(robot -> robotRepository.save(robot));
    }

    @Transactional
    @Override
    public void delete(int roboId) {
        robotRepository.delete(roboId);
    }
}
