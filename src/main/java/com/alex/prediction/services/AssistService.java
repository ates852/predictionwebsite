package com.alex.prediction.services;


import com.alex.prediction.models.Assist;
import com.alex.prediction.repository.AssistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistService {
    private AssistRepository assistRepository;

    public AssistService(AssistRepository assistRepository) {
        this.assistRepository = assistRepository;
    }

    public Iterable<Assist> list() {
        return assistRepository.findAll();
    }

    public List<Assist> getList() {
        return assistRepository.findAll();
    }

    public Assist save(Assist assist) {
        return assistRepository.save(assist);
    }

    public void save(List<Assist> assists) {
        assistRepository.deleteAll();
        assistRepository.saveAll(assists);
    }
}
