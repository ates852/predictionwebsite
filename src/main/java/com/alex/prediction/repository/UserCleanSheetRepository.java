package com.alex.prediction.repository;

import com.alex.prediction.models.User;
import com.alex.prediction.models.UserCleanSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCleanSheetRepository extends JpaRepository<UserCleanSheet,Long> {
    List<UserCleanSheet> findByUserOrderByPosition(User user);
}
