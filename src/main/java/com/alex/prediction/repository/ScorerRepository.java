package com.alex.prediction.repository;

import com.alex.prediction.models.Scorer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScorerRepository extends JpaRepository<Scorer,Long> {
    List<Scorer> findAllBySeason(String season);
}
