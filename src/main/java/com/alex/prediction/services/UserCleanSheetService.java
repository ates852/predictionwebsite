package com.alex.prediction.services;


import com.alex.prediction.models.User;
import com.alex.prediction.models.UserCleanSheet;
import com.alex.prediction.repository.UserCleanSheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCleanSheetService {
    private UserCleanSheetRepository userCleanSheetRepository;

    public UserCleanSheetService(UserCleanSheetRepository userCleanSheetRepository) {
        this.userCleanSheetRepository = userCleanSheetRepository;
    }

    public UserCleanSheet saveUserCleanSheet(UserCleanSheet userCleanSheet){
        return userCleanSheetRepository.save(userCleanSheet);
    }

    public List<UserCleanSheet> getList(User user) {
        return userCleanSheetRepository.findByUserOrderByPosition(user);
    }

    public  Iterable<UserCleanSheet> list(User user){
        return userCleanSheetRepository.findByUserOrderByPosition(user);
    }
}
