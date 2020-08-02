package com.alex.prediction.repository;

import com.alex.prediction.domain.Scorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScorerRepository extends JpaRepository<Scorer,Long> {
    List<Scorer> findAll();
}
