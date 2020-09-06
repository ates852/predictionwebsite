package com.alex.prediction.controller;


import com.alex.prediction.models.User;
import com.alex.prediction.models.UserAssist;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.services.UserAssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/userAssist")
public class UserAssistController {
    @Autowired
    private UserAssistService userAssistService;
    @Autowired
    private UserRepository userRepository;

    //Get users team standings
    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<UserAssist> list(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        return userAssistService.getList(userRepository.findByUsername(username),season);
    }

    @PostMapping("/savePlayer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<UserAssist> addPlayer(@RequestBody UserAssist userAssist) {
        UserAssist userPlayerToReturn = userAssistService.saveUserPlayer(userAssist);
        return new ResponseEntity<>(userPlayerToReturn, HttpStatus.OK);
    }

    @PostMapping("/savePlayers")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<List<UserAssist>> addPlayers(@RequestBody List<UserAssist> userAssists) {
        List<UserAssist> userPlayerListToReturn  = userAssistService.saveList(userAssists);
        return new ResponseEntity<>(userPlayerListToReturn, HttpStatus.OK);
    }

    @DeleteMapping("/deletePlayers")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deletePlayers(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        userAssistService.deleteListOfPlayers(userRepository.findByUsername(username),season);
    }
    @DeleteMapping("/deletePlayer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deletePlayer(@RequestBody UserAssist userAssist) {
        userAssistService.deletePlayer(userAssist);
    }

}
