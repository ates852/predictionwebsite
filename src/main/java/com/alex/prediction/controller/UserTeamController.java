package com.alex.prediction.controller;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserTeam;

import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.services.UserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/userTeams")
public class UserTeamController {
    @Autowired
    private UserTeamService userTeamService;
    @Autowired
    private UserRepository userRepository;

    //Get users team standings
    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<UserTeam> list(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        return userTeamService.getList(userRepository.findByUsername(username),season);
    }

    @PostMapping("/saveTeam")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<UserTeam> addTeam(@RequestBody UserTeam userTeam ) {
        UserTeam userTeam1 = userTeamService.saveTeam(userTeam);
        return new ResponseEntity<>(userTeam1, HttpStatus.OK);
    }

    @PostMapping("/saveTeams")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public ResponseEntity<List<UserTeam>> addTeams(@RequestBody List<UserTeam> userTeams) {
        List<UserTeam> userTeams1 = userTeamService.saveList(userTeams);
        return new ResponseEntity<>(userTeams1, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    @DeleteMapping("/deleteTeams")
    public void deleteTeams(@RequestParam(name = "username") String username ,@RequestParam(name = "season") String season) {
        userTeamService.deleteListOfTeams(userRepository.findByUsername(username),season);
    }

    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    @DeleteMapping("/deleteTeam")
    public void deleteTeam(@RequestBody UserTeam userTeam) {
        userTeamService.deleteTeam(userTeam);
    }

}
