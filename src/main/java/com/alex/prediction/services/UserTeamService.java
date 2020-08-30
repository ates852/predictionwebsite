package com.alex.prediction.services;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserTeam;
import com.alex.prediction.repository.UserRepository;
import com.alex.prediction.repository.UserTeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class UserTeamService {

    @Autowired
    private UserTeamRepository userTeamRepository;
    @Autowired
    private UserRepository userRepository;

    public UserTeam saveTeam(UserTeam userTeam) {
        // Finding User by username and checking if user exist
        User user = userRepository.findByUsername(userTeam.getUser().getUsername());
        if (user == null) {
            return null;
        }
        //Load user from database and save Users team
        if (userTeamRepository.existsByNameOfTeamAndUser(userTeam.getNameOfTeam(), user)) {
            UserTeam userTeamToUpdate = userTeamRepository.getOne(userTeamRepository.findByNameOfTeamAndUser(userTeam.getNameOfTeam(),user).getId());
            userTeamToUpdate.setPosition(userTeam.getPosition());
            userTeamToUpdate.setUser(user);
            return userTeamRepository.save(userTeamToUpdate);
        } else {
            userTeam.setUser(user);
        }
        return userTeamRepository.save(userTeam);

    }

    public List<UserTeam> saveList(List<UserTeam> userTeams) {
        if (userTeams == null) {
            return null;
        }
        for (UserTeam team : userTeams) {
            // Finding User by username and checking if user exist
            User user = userRepository.findByUsername(team.getUser().getUsername());
            if (!userRepository.existsByUsername(user.getUsername())) {
                System.out.println("User doesnt exist");
                continue;
            }
            //Load user from database and save Users team
            //If users team already exist then we just update team
            if (userTeamRepository.existsByNameOfTeamAndUser(team.getNameOfTeam(), user)) {
                //Updating users team
                UserTeam userTeamToUpdate = userTeamRepository.getOne(userTeamRepository.findByNameOfTeamAndUser(team.getNameOfTeam(),user).getId());
                userTeamToUpdate.setPosition(team.getPosition());
                userTeamToUpdate.setUser(user);
                userTeamRepository.save(userTeamToUpdate);
            } else {
                //Saving users team
                team.setUser(user);
                userTeamRepository.save(team);
            }
        }
        return userTeams;
    }

    public void deleteList(User user) {
        Iterable<UserTeam> userTeamToDelete = userTeamRepository.findByUserOrderByPosition(userRepository.findByUsername(user.getUsername()));
        userTeamRepository.deleteAll(userTeamToDelete);
    }

    public void deleteTeam(UserTeam userTeam){
        User user = userRepository.findByUsername(userTeam.getUser().getUsername());
        if (user == null) {
            return ;
        }
        UserTeam userTeamToDelete = userTeamRepository.getOne(userTeamRepository.findByNameOfTeamAndUser(userTeam.getNameOfTeam(),user).getId());
        userTeamRepository.delete(userTeamToDelete);
    }

    public Iterable<UserTeam> getList(User user) {
        return userTeamRepository.findByUserOrderByPosition(user);
    }

}
