package com.alex.prediction.repository;

import com.alex.prediction.domain.CleanSheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CleanSheetRepository extends JpaRepository<CleanSheet, Long> {
    List<CleanSheet> findAllByPosition(String position);
}
