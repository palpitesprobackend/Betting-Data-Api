package com.palpites.pro.api.bettingdata.controller;

import com.palpites.pro.api.bettingdata.dto.users.UserRequestDto;
import com.palpites.pro.api.bettingdata.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> createUser(@RequestBody @Valid UserRequestDto userRequestDto) {
        return new ResponseEntity<>(service.createUser(userRequestDto).tojSON(), HttpStatus.CREATED);
    }

    @ResponseBody
    @GetMapping(produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findUserAccount(@RequestHeader String nome,
                                                  @RequestHeader String email,
                                                  @RequestHeader String senha) {
        return service.loginUserAccount(nome, email, senha);
    }

    @ResponseBody
    @GetMapping(value = "/find-all", produces = "application/json;charset=UTF-8")
    public ResponseEntity<Object> findAllUserAccount() {
        return new ResponseEntity<>(service.findAllUserAccount(), HttpStatus.OK);
    }
}
