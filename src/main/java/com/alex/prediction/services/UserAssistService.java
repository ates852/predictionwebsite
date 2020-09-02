package com.alex.prediction.services;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserAssist;
import com.alex.prediction.repository.UserAssistRepository;
import com.alex.prediction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserAssistService {

    @Autowired
    private UserAssistRepository userAssistRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<UserAssist> getList(User user, String season) {
        return userAssistRepository.findByUserAndSeasonOrderByPosition(user, season);
    }

    public UserAssist saveUserPlayer(UserAssist userAssist) {
        // Finding User by username and checking if user exist
        User user = userRepository.findByUsername(userAssist.getUser().getUsername());
        if (user == null) {
            return null;
        }
        //Load user from database and save Users scorer
        if (userAssistRepository.existsByNameOfPlayerAndSeasonAndUser(userAssist.getNameOfPlayer(), userAssist.getSeason(), user)) {
            UserAssist userPlayerToUpdate = userAssistRepository.getOne(userAssistRepository.findByNameOfPlayerAndSeasonAndUser(userAssist.getNameOfPlayer(), userAssist.getSeason(), user).getId());
            userPlayerToUpdate.setPosition(userAssist.getPosition());
            userPlayerToUpdate.setUser(user);
            return userAssistRepository.save(userPlayerToUpdate);
        } else {
            userAssist.setUser(user);
        }
        return userAssistRepository.save(userAssist);
    }

    public List<UserAssist> saveList(List<UserAssist> userAssists) {
        if (userAssists == null) {
            return null;
        }
        for (UserAssist player : userAssists) {
            // Finding User by username and checking if user exist
            User user = userRepository.findByUsername(player.getUser().getUsername());
            if (!userRepository.existsByUsername(user.getUsername())) {
                System.out.println("User doesnt exist");
                continue;
            }
            //Load user from database and save Users player
            //If users player already exist then we just update player
            if (userAssistRepository.existsByNameOfPlayerAndSeasonAndUser(player.getNameOfPlayer(), player.getSeason(), user)) {
                UserAssist userPlayerToUpdate = userAssistRepository.getOne(userAssistRepository.findByNameOfPlayerAndSeasonAndUser(player.getNameOfPlayer(), player.getSeason(), user).getId());
                userPlayerToUpdate.setPosition(player.getPosition());
                userPlayerToUpdate.setUser(user);
                userAssistRepository.save(userPlayerToUpdate);
            } else {
                //Saving users player
                player.setUser(user);
                userAssistRepository.save(player);
            }
        }
        return userAssists;
    }

    public void deleteListOfPlayers(User user, String season) {
        Iterable<UserAssist> userPlayersToDelete = userAssistRepository.findByUserAndSeasonOrderByPosition(userRepository.findByUsername(user.getUsername()), season);
        userAssistRepository.deleteAll(userPlayersToDelete);
    }

    public void deletePlayer(UserAssist userAssist) {
        User user = userRepository.findByUsername(userAssist.getUser().getUsername());
        if (user == null) {
            return;
        }
        UserAssist userPlayerToDelete = userAssistRepository.getOne(userAssistRepository.findByNameOfPlayerAndSeasonAndUser(userAssist.getNameOfPlayer(), userAssist.getSeason(), user).getId());
        userAssistRepository.delete(userPlayerToDelete);
    }

}
