package com.alex.prediction.services;


import com.alex.prediction.models.Assist;
import com.alex.prediction.repository.AssistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistService {
    @Autowired
    private AssistRepository assistRepository;

    public Iterable<Assist> getList(String season) {
        return assistRepository.findBySeason(season);
    }

    public Assist save(Assist assist) {
        return assistRepository.save(assist);
    }

    public void save(List<Assist> assists) {
        assistRepository.deleteAll();
        assistRepository.saveAll(assists);
    }
}
