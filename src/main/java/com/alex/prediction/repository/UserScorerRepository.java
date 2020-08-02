package com.alex.prediction.repository;

import com.alex.prediction.domain.User;
import com.alex.prediction.domain.UserScorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserScorerRepository extends JpaRepository<UserScorer, Long> {
    UserScorer findByPositionAndUser(int position, User user);

    UserScorer findByNameOfPlayerAndUser(String nameOfPlayer, User user);

    List<UserScorer> findByUserOrderByPosition(User user);
}
