package com.alex.prediction.repository;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserAssist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAssistRepository extends JpaRepository<UserAssist, Long> {
    UserAssist findByPositionAndSeasonAndUser(int position, String season, User user);

    UserAssist findByNameOfPlayerAndSeasonAndUser(String nameOfPlayer, String season, User user);

    Boolean existsByNameOfPlayerAndSeasonAndUser(String nameOfPlayer, String season, User user);

    Iterable<UserAssist> findByUserAndSeasonOrderByPosition(User user, String season);
}
