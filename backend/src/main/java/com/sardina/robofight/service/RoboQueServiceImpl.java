package com.sardina.robofight.service;


import com.sardina.robofight.model.RoboQue;
import com.sardina.robofight.repository.RoboQueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoboQueServiceImpl implements RoboQueService {

    @Autowired
    RoboQueRepository roboQueRepository;

  // -- addTenToRoboQue() adds a random ten to the que --
    @Transactional
    @Override
    public void addTenToRoboQue(List<RoboQue> robots) {
        robots.stream()
                .forEach(roboQue -> roboQueRepository.save(roboQue));
    }

  // -- getOneRandom() pulls one robot from a que of 10 and returns for the fight then deletes from que ---
    @Transactional
    @Override
    public RoboQue getOneRandom() {


        return null;
    }

  // -- deleteAll() deletes entire que at the end of the game --
    @Transactional
    @Override
    public void deleteAll() {
        roboQueRepository.deleteAll();
    }
}
