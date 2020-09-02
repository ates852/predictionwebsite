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
    @GetMapping("/list/{name}/{season}")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<UserAssist> list(@PathVariable String name, @PathVariable String season) {
        return userAssistService.getList(userRepository.findByUsername(name),season);
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

    @DeleteMapping("/deletePlayers/{season}")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deletePlayers(@RequestBody User user, @PathVariable String season) {
        userAssistService.deleteListOfPlayers(user,season);
    }
    @DeleteMapping("/deletePlayer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deletePlayer(@RequestBody UserAssist userAssist) {
        userAssistService.deletePlayer(userAssist);
    }

}
