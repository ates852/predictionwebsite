package com.alex.prediction.repository;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
//    UserTeam findByPositionAndUser(int position, User user);

    UserTeam findByNameOfTeamAndSeasonAndUser(String nameOfTeam,String season, User user);

    Boolean existsByNameOfTeamAndSeasonAndUser(String nameOfTeam,String season, User user);

    Iterable<UserTeam> findByUserAndSeason(User user , String season);
}
