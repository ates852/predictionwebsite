package com.alex.prediction.services;

import com.alex.prediction.models.Scorer;
import com.alex.prediction.repository.ScorerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScorerService {

    private ScorerRepository scorerRepository;

    public ScorerService(ScorerRepository scorerRepository) {
        this.scorerRepository = scorerRepository;
    }

    public Iterable<Scorer> list() {
        return scorerRepository.findAll();
    }

    public List<Scorer> getList() {
        return scorerRepository.findAll();
    }

    public Scorer save(Scorer scorer) {
        return scorerRepository.save(scorer);
    }

    public void save(List<Scorer> scorers) {
        scorerRepository.deleteAll();
        scorerRepository.saveAll(scorers);
    }
}
