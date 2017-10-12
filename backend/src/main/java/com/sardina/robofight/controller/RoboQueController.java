package com.sardina.robofight.controller;


import com.sardina.robofight.service.RoboQueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 10000)
@RestController
public class RoboQueController {

    @Autowired
    RoboQueService roboQueService;


}
