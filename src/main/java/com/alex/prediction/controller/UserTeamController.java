//package com.alex.prediction.controller;
//
//import com.alex.prediction.models.UserTeam;
//import com.alex.prediction.services.UserService;
//import com.alex.prediction.services.UserTeamService;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/userTeams")
//public class UserTeamController {
//    private UserTeamService userTeamService;
//    private UserService userService;
//
//    public UserTeamController(UserTeamService userTeamService, UserService userService) {
//        this.userTeamService = userTeamService;
//        this.userService = userService;
//    }
//
//    //Get users team standings
//    @CrossOrigin
//    @GetMapping("/list/{name}")
//    public Iterable<UserTeam> list(@PathVariable String name) {
//        return userTeamService.list(userService.findUserByName(name));
//    }
//
//    @CrossOrigin
//    @PostMapping("/saveTeam")
//    public UserTeam saveTeam (@RequestBody UserTeam userTeam){
//        return userTeamService.saveTeam(userTeam);
//    }
//}
