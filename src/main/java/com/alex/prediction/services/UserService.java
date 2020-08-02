package com.alex.prediction.services;

import com.alex.prediction.domain.User;
import com.alex.prediction.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User findUserById(int userId){
        return userRepository.findByStandingsId(userId);
    }

    public User findUserByName(String userName){
        return userRepository.findByName(userName);
    }
}
