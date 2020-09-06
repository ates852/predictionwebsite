package com.alex.prediction.controller;

import com.alex.prediction.core.Core;
import com.alex.prediction.models.*;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/core")
public class CoreController {

    @Autowired
    private UserTeamService userTeamService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private UserScorerService userScorerService;
    @Autowired
    private ScorerService scorerService;
    @Autowired
    private UserAssistService userAssistService;
    @Autowired
    private AssistService assistService;
    @Autowired
    private CleanSheetService cleanSheetService;
    @Autowired
    private UserCleanSheetService userCleanSheetService;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/calStandings")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public int calculateStandings(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        User userToCalculate = userRepository.findByUsername(username);
        Core userPointsToCalculate = new Core(userToCalculate);
        List<UserTeam> userTeams = new ArrayList<>();
        userTeamService.getList(userToCalculate, season).forEach(userTeams::add);
        List<Team> teams = new ArrayList<>();
        teamService.getList().forEach(teams::add);
        return userPointsToCalculate.calculateStandings(userTeams, teams);
    }

    @GetMapping("/calScorerStandings")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public int calculateScorerStandings(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        User userToCalculate = userRepository.findByUsername(username);
        Core userPointsToCalculate = new Core(userToCalculate);
        List<UserScorer> userScorers = new ArrayList<>();
        userScorerService.getList(userToCalculate, season).forEach(userScorers::add);
        List<Scorer> scorers = new ArrayList<>();
        scorerService.getList().forEach(scorers::add);
        return userPointsToCalculate.calculateTopScorer(userScorers, scorers);
    }

    @GetMapping("/calAssistStandings")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public int calculateAssistStandings(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        User userToCalculate = userRepository.findByUsername(username);
        Core userPointsToCalculate = new Core(userToCalculate);
        List<UserAssist> userAssists = new ArrayList<>();
        userAssistService.getList(userToCalculate, season).forEach(userAssists::add);
        List<Assist> assists = new ArrayList<>();
        assistService.getList().forEach(assists::add);
        return userPointsToCalculate.calculateTopAssist(userAssists, assists);
    }

    @GetMapping("/calCleanSheetStandings")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public int calculateCleanSheetStandings(@RequestParam(name = "username") String username, @RequestParam(name = "season") String season) {
        User userToCalculate = userRepository.findByUsername(username);
        Core userPointsToCalculate = new Core(userToCalculate);
        List<UserCleanSheet> userCleanSheets = new ArrayList<>();
        userCleanSheetService.getList(userToCalculate, season).forEach(userCleanSheets::add);
        List<CleanSheet> cleanSheets = new ArrayList<>();
        cleanSheetService.getList().forEach(cleanSheets::add);
        return userPointsToCalculate.calculateTopCleanSheet(userCleanSheets, cleanSheets);
    }

}