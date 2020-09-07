package com.alex.prediction.services;

import com.alex.prediction.models.Scorer;
import com.alex.prediction.repository.ScorerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScorerService {
    @Autowired
    private ScorerRepository scorerRepository;

    public Iterable<Scorer> getList(String season) {
        return scorerRepository.findAllBySeason(season);
    }

    public Scorer save(Scorer scorer) {
        return scorerRepository.save(scorer);
    }

    public void save(List<Scorer> scorers) {
        scorerRepository.deleteAll();
        scorerRepository.saveAll(scorers);
    }
}
