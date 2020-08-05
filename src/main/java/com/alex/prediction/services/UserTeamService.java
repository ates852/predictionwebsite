package com.alex.prediction.services;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserTeam;
import com.alex.prediction.repository.UserTeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTeamService {
    private UserTeamRepository userTeamRepository;

    public UserTeamService(UserTeamRepository userTeamRepository) {
        this.userTeamRepository = userTeamRepository;
    }

    public UserTeam saveTeam(UserTeam userTeam) {
        return userTeamRepository.save(userTeam);
    }

    public void saveList(List<UserTeam> userTeams) {
        userTeamRepository.deleteAll();
        userTeamRepository.saveAll(userTeams);
    }

    public void deleteList(List<UserTeam> userTeams) {
        userTeamRepository.deleteAll();
    }

//    public List<UserTeam> getList(User user){
//        return userTeamRepository.findByUserOrderByPosition(user);
//    }

    public  Iterable<UserTeam> list(User user){
        return userTeamRepository.findByUserOrderByPosition(user);
    }


    public String getNameOfTeam(int position, User user) {
        String nameOfTeam = userTeamRepository.findByPositionAndUser(position, user).getNameOfTeam();
        return nameOfTeam;
    }

    public int getPositionOfTeam(String nameOfTeam , User user) {
        int position = userTeamRepository.findByNameOfTeamAndUser(nameOfTeam, user).getPosition();
        return position;
    }
}
