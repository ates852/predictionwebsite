package com.alex.prediction.repository;

import com.alex.prediction.models.Assist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssistRepository extends JpaRepository<Assist, Long> {
    List<Assist> findAll();
}
