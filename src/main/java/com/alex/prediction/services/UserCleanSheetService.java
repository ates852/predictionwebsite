package com.alex.prediction.services;


import com.alex.prediction.models.User;
import com.alex.prediction.models.UserCleanSheet;
import com.alex.prediction.repository.UserCleanSheetRepository;
import com.alex.prediction.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserCleanSheetService {

    @Autowired
    private UserCleanSheetRepository userCleanSheetRepository;
    @Autowired
    private UserRepository userRepository;

    public Iterable<UserCleanSheet> getList(User user, String season) {
        return userCleanSheetRepository.findByUserAndSeasonOrderByPosition(user,season);
    }

    public UserCleanSheet saveUserPlayer(UserCleanSheet userCleanSheet) {
        // Finding User by username and checking if user exist
        User user = userRepository.findByUsername(userCleanSheet.getUser().getUsername());
        if (user == null) {
            return null;
        }
        //Load user from database and save Users scorer
        if (userCleanSheetRepository.existsByNameOfPlayerAndSeasonAndUser(userCleanSheet.getNameOfPlayer(), userCleanSheet.getSeason(), user)) {
            UserCleanSheet userPlayerToUpdate = userCleanSheetRepository.getOne(userCleanSheetRepository.findByNameOfPlayerAndSeasonAndUser(userCleanSheet.getNameOfPlayer(), userCleanSheet.getSeason(), user).getId());
            userPlayerToUpdate.setPosition(userCleanSheet.getPosition());
            userPlayerToUpdate.setUser(user);
            return userCleanSheetRepository.save(userPlayerToUpdate);
        } else {
            userCleanSheet.setUser(user);
        }
        return userCleanSheetRepository.save(userCleanSheet);
    }

    public List<UserCleanSheet> saveList(List<UserCleanSheet> userCleanSheets) {
        if (userCleanSheets == null) {
            return null;
        }
        for (UserCleanSheet player : userCleanSheets) {
            // Finding User by username and checking if user exist
            User user = userRepository.findByUsername(player.getUser().getUsername());
            if (!userRepository.existsByUsername(user.getUsername())) {
                System.out.println("User doesnt exist");
                continue;
            }
            //Load user from database and save Users player
            //If users player already exist then we just update player
            if (userCleanSheetRepository.existsByNameOfPlayerAndSeasonAndUser(player.getNameOfPlayer(), player.getSeason(), user)) {
                UserCleanSheet userPlayerToUpdate = userCleanSheetRepository.getOne(userCleanSheetRepository.findByNameOfPlayerAndSeasonAndUser(player.getNameOfPlayer(), player.getSeason(), user).getId());
                userPlayerToUpdate.setPosition(player.getPosition());
                userPlayerToUpdate.setUser(user);
                userCleanSheetRepository.save(userPlayerToUpdate);
            } else {
                //Saving users player
                player.setUser(user);
                userCleanSheetRepository.save(player);
            }
        }
        return userCleanSheets;
    }

    public void deleteListOfPlayers(User user,String season) {
        Iterable<UserCleanSheet> userScorersToDelete = userCleanSheetRepository.findByUserAndSeasonOrderByPosition(user,season);
        userCleanSheetRepository.deleteAll(userScorersToDelete);
    }

    public void deletePlayer(UserCleanSheet userCleanSheet){
        User user = userRepository.findByUsername(userCleanSheet.getUser().getUsername());
        if (user == null) {
            return ;
        }
        UserCleanSheet userPlayerToDelete = userCleanSheetRepository.getOne(userCleanSheetRepository.findByNameOfPlayerAndSeasonAndUser(userCleanSheet.getNameOfPlayer(),userCleanSheet.getSeason(),user).getId());
        userCleanSheetRepository.delete(userPlayerToDelete);
    }

}
