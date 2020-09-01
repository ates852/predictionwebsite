package com.alex.prediction.services;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserScorer;
import com.alex.prediction.models.UserTeam;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.repository.UserScorerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserScorerService {

    @Autowired
    private UserScorerRepository userScorerRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<UserScorer> getList(User user,String season) {
        return userScorerRepository.findByUserAndSeasonOrderByPosition(user,season);
    }

    public UserScorer saveUserScorer(UserScorer userScorer) {
        // Finding User by username and checking if user exist
        User user = userRepository.findByUsername(userScorer.getUser().getUsername());
        if (user == null) {
            return null;
        }
        //Load user from database and save Users scorer
        if (userScorerRepository.existsByNameOfPlayerAndSeasonAndUser(userScorer.getNameOfPlayer(), userScorer.getSeason(), user)) {
            UserScorer userScorerToUpdate = userScorerRepository.getOne(userScorerRepository.findByNameOfPlayerAndSeasonAndUser(userScorer.getNameOfPlayer(), userScorer.getSeason(), user).getId());
            userScorerToUpdate.setPosition(userScorer.getPosition());
            userScorerToUpdate.setUser(user);
            return userScorerRepository.save(userScorerToUpdate);
        } else {
            userScorer.setUser(user);
        }
        return userScorerRepository.save(userScorer);
    }

    public List<UserScorer> saveList(List<UserScorer> userScorers) {
        if (userScorers == null) {
            return null;
        }
        for (UserScorer scorer : userScorers) {
            // Finding User by username and checking if user exist
            User user = userRepository.findByUsername(scorer.getUser().getUsername());
            if (!userRepository.existsByUsername(user.getUsername())) {
                System.out.println("User doesnt exist");
                continue;
            }
            //Load user from database and save Users scorer
            //If users scorer already exist then we just update scorer
            if (userScorerRepository.existsByNameOfPlayerAndSeasonAndUser(scorer.getNameOfPlayer(), scorer.getSeason(), user)) {
                UserScorer userScorerToUpdate = userScorerRepository.getOne(userScorerRepository.findByNameOfPlayerAndSeasonAndUser(scorer.getNameOfPlayer(), scorer.getSeason(), user).getId());
                userScorerToUpdate.setPosition(scorer.getPosition());
                userScorerToUpdate.setUser(user);
                userScorerRepository.save(userScorerToUpdate);
            } else {
                //Saving users scorer
                scorer.setUser(user);
                userScorerRepository.save(scorer);
            }
        }
        return userScorers;
    }

    public void deleteListOfScorer(User user,String season) {
        Iterable<UserScorer> userScorersToDelete = userScorerRepository.findByUserAndSeasonOrderByPosition(userRepository.findByUsername(user.getUsername()),season);
        userScorerRepository.deleteAll(userScorersToDelete);
    }

    public void deleteTeam(UserScorer userScorer){
        User user = userRepository.findByUsername(userScorer.getUser().getUsername());
        if (user == null) {
            return ;
        }
        UserScorer userScorerToDelete = userScorerRepository.getOne(userScorerRepository.findByNameOfPlayerAndSeasonAndUser(userScorer.getNameOfPlayer(),userScorer.getSeason(),user).getId());
        userScorerRepository.delete(userScorerToDelete);
    }

}
