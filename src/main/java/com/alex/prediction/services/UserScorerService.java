package com.alex.prediction.services;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserScorer;
import com.alex.prediction.repository.UserScorerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserScorerService {
    private UserScorerRepository userScorerRepository;

    public UserScorerService (UserScorerRepository userScorerRepository){
        this.userScorerRepository = userScorerRepository;
    }

    public List<UserScorer> getList(User user){
        return userScorerRepository.findByUserOrderByPosition(user);
    }

    public  Iterable<UserScorer> list(User user){
        return userScorerRepository.findByUserOrderByPosition(user);
    }

    public UserScorer saveUserScorer(UserScorer userScorer){
        return userScorerRepository.save(userScorer);
    }

    public String getNameOfPlayer(int position, User user) {
        String nameOfPlayer = userScorerRepository.findByPositionAndUser(position, user).getNameOfPlayer();
        return nameOfPlayer;
    }

    public int getPositionOfPlayer(String nameOfPlayer , User user) {
        int position = userScorerRepository.findByNameOfPlayerAndUser(nameOfPlayer, user).getPosition();
        return position;
    }
}
