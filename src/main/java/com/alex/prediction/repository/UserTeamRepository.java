package com.alex.prediction.repository;

import com.alex.prediction.domain.User;
import com.alex.prediction.domain.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {
    UserTeam findByPositionAndUser(int position, User user);

    UserTeam findByNameOfTeamAndUser(String nameOfTeam, User user);

    List<UserTeam> findByUserOrderByPosition(User user);
}
