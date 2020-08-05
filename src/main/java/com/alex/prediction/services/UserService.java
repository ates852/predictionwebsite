//package com.alex.prediction.services;
//
//import com.alex.prediction.models.User;
//import com.alex.prediction.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Service;
//
//
//@Service
//public class UserService implements UserDetailsService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    public User saveUser(User user) {
//        return userRepository.save(user);
//    }
//
//    public void deleteUser(User user){userRepository.delete(user);}
//
//    public User findUserByName(String userName){
//        return userRepository.findByUsername(userName);
//    }
//}
