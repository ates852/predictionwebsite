package com.alex.prediction.controller;

import com.alex.prediction.domain.User;
import com.alex.prediction.domain.UserTeam;
import com.alex.prediction.services.UserService;
import com.alex.prediction.services.UserTeamService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userteams")
public class UserTeamController {
    private UserTeamService userTeamService;
    private UserService userService;

    public UserTeamController (UserTeamService userTeamService){
        this.userTeamService = userTeamService;
    }

    //Get users team standings
    @GetMapping("/list/{name}")
    public Iterable<UserTeam> list(@PathVariable("name") String name){
        return userTeamService.getList(userService.findUserByName(name));
    }


}
