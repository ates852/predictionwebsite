package com.alex.prediction.repository;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
    UserTeam findByPositionAndUser(int position, User user);

    UserTeam findByNameOfTeamAndUser(String nameOfTeam, User user);

//    List<UserTeam> findByUserOrderByPosition(User user);

    Iterable<UserTeam> findByUserOrderByPosition(User user);
}
