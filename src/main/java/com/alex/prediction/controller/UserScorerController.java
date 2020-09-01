package com.alex.prediction.controller;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserScorer;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.services.UserScorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/userScorer")
public class UserScorerController {
    @Autowired
    private UserScorerService userScorerService;
    @Autowired
    private UserRepository userRepository;

    //Get users team standings
    @GetMapping("/list/{name}/{season}")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<UserScorer> list(@PathVariable String name, @PathVariable String season) {
        return userScorerService.getList(userRepository.findByUsername(name),season);
    }

    @PostMapping("/saveScorer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<UserScorer> addScorer(@RequestBody UserScorer userScorer) {
        UserScorer userScorerToReturn = userScorerService.saveUserScorer(userScorer);
        return new ResponseEntity<>(userScorerToReturn, HttpStatus.OK);
    }

    @PostMapping("/saveScorers")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<List<UserScorer>> addScorers(@RequestBody List<UserScorer> userScorers) {
        List<UserScorer> userScorerListToReturn  = userScorerService.saveList(userScorers);
        return new ResponseEntity<>(userScorerListToReturn, HttpStatus.OK);
    }

    @DeleteMapping("/deleteScorers/{season}")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deleteScorers(@RequestBody User user, @PathVariable String season) {
        userScorerService.deleteListOfScorer(user,season);
    }
    @DeleteMapping("/deleteScorer")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public void deleteScorer(@RequestBody UserScorer userScorer) {
        userScorerService.deleteTeam(userScorer);
    }

}
