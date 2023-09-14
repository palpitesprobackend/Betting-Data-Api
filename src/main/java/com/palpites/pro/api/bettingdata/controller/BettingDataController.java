package com.palpites.pro.api.bettingdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.palpites.pro.api.bettingdata.client.ApiFootBallClient;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/betting-data")
public class BettingDataController {

    private final ApiFootBallClient client;

    @Autowired
    public BettingDataController(ApiFootBallClient client) {
        this.client = client;
    }

    @ResponseBody
    @GetMapping(value = "/tips", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findTips() {
        return new ResponseEntity<>(client.findBettingTips(), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/standings", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findStandings() {
        return new ResponseEntity<>(client.findStandings(), HttpStatus.OK);
    }

}
