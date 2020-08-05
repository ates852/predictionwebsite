//package com.alex.prediction.controller;
//
//import com.alex.prediction.models.User;
//import com.alex.prediction.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.*;
//
//
//@RestController
//@RequestMapping(value = "/api/user", produces = {MediaType.APPLICATION_JSON_VALUE})
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/getUser/{name}")
//    public User getUser(@PathVariable String name) {
//        return userService.findUserByName(name);
//    }
//
//    @PostMapping("/saveUser")
//    public User createUser(@RequestBody User newUser) {
//        return userService.saveUser(newUser);
//    }
//
//    @DeleteMapping("/deleteUser/{id}")
//    void deleteUser(@PathVariable Long id){
//
//    }
//}
