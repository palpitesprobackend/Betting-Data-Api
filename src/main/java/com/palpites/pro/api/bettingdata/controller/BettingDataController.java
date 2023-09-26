package com.palpites.pro.api.bettingdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.palpites.pro.api.bettingdata.service.FindDataService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/betting-data")
public class BettingDataController {

    private final FindDataService service;

    @Autowired
    public BettingDataController(FindDataService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping(value = "/tips", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findTips(@RequestParam(name = "league") String league,
                                           @RequestParam(name = "date") String date) {
        return new ResponseEntity<>(service.findBettingTips(league, date), HttpStatus.OK);
    }

    @ResponseBody
    @GetMapping(value = "/standing", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findStanding(@RequestParam(name = "league") String league) {
        return new ResponseEntity<>(service.findStanding(league), HttpStatus.OK);
    }

}
