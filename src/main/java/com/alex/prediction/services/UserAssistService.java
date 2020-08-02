package com.alex.prediction.services;

import com.alex.prediction.domain.User;
import com.alex.prediction.domain.UserAssist;
import com.alex.prediction.repository.UserAssistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserAssistService {
    private UserAssistRepository userAssistRepository;

    public UserAssistService(UserAssistRepository userAssistRepository){
        this.userAssistRepository = userAssistRepository;
    }

    public UserAssist saveUserAssist(UserAssist userAssist){
        return userAssistRepository.save(userAssist);
    }

    public List<UserAssist> getList(User user){
        return userAssistRepository.findByUserOrderByPosition(user);
    }

    public  Iterable<UserAssist> list(User user){
        return userAssistRepository.findByUserOrderByPosition(user);
    }
}
