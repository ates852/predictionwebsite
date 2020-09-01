package com.alex.prediction.repository;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserScorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScorerRepository extends JpaRepository<UserScorer, Long> {
    UserScorer findByPositionAndSeasonAndUser(int position, String season, User user);

    UserScorer findByNameOfPlayerAndSeasonAndUser(String nameOfPlayer, String season, User user);

    Boolean existsByNameOfPlayerAndSeasonAndUser(String nameOfPlayer, String season, User user);

    Iterable<UserScorer> findByUserAndSeasonOrderByPosition(User user,String season);
}
