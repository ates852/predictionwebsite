package com.alex.prediction.repository;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserCleanSheet;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserCleanSheetRepository extends JpaRepository<UserCleanSheet,Long> {
    UserCleanSheet findByPositionAndSeasonAndUser(int position, String season, User user);

    UserCleanSheet findByNameOfPlayerAndSeasonAndUser(String nameOfPlayer, String season, User user);

    Boolean existsByNameOfPlayerAndSeasonAndUser(String nameOfPlayer, String season, User user);

    Iterable<UserCleanSheet> findByUserAndSeasonOrderByPosition(User user,String season);
}
