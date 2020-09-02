package com.alex.prediction.controller;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserCleanSheet;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.services.UserCleanSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/userCleanSheet")
public class UserCleanSheetController {
    @Autowired
    private UserCleanSheetService userCleanSheetService;
    @Autowired
    private UserRepository userRepository;

    //Get users team standings
    @GetMapping("/list/{name}/{season}")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<UserCleanSheet> list(@PathVariable String name, @PathVariable String season) {
        return userCleanSheetService.getList(userRepository.findByUsername(name),season);
    }

    @PostMapping("/savePlayer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<UserCleanSheet> addPlayer(@RequestBody UserCleanSheet userCleanSheet) {
        UserCleanSheet userPlayerToReturn = userCleanSheetService.saveUserPlayer(userCleanSheet);
        return new ResponseEntity<>(userPlayerToReturn, HttpStatus.OK);
    }

    @PostMapping("/savePlayers")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<List<UserCleanSheet>> addPlayers(@RequestBody List<UserCleanSheet> userCleanSheets) {
        List<UserCleanSheet> userPlayerListToReturn  = userCleanSheetService.saveList(userCleanSheets);
        return new ResponseEntity<>(userPlayerListToReturn, HttpStatus.OK);
    }

    @DeleteMapping("/deletePlayers/{season}")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deletePlayers(@RequestBody User user, @PathVariable String season) {
        userCleanSheetService.deleteListOfPlayers(user,season);
}
    @DeleteMapping("/deletePlayer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deletePlayer(@RequestBody UserCleanSheet userCleanSheet) {
        userCleanSheetService.deletePlayer(userCleanSheet);
    }

}
