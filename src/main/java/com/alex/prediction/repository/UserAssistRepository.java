package com.alex.prediction.repository;

import com.alex.prediction.domain.User;
import com.alex.prediction.domain.UserAssist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAssistRepository extends JpaRepository<UserAssist, Long> {
    List<UserAssist> findByUserOrderByPosition(User user);
}
