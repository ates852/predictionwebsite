package com.alex.prediction.services;

import com.alex.prediction.models.CleanSheet;
import com.alex.prediction.repository.CleanSheetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanSheetService {
    private CleanSheetRepository cleanSheetRepository;

    public CleanSheetService(CleanSheetRepository cleanSheetRepository) {
        this.cleanSheetRepository = cleanSheetRepository;
    }

    public Iterable<CleanSheet> list() {
        return cleanSheetRepository.findAll();
    }

    public List<CleanSheet> getList() {
        return cleanSheetRepository.findAllByPosition("Goalkeeper");
    }

    public CleanSheet save(CleanSheet cleanSheet) {
        return cleanSheetRepository.save(cleanSheet);
    }

    public void save(List<CleanSheet> cleanSheets) {
        cleanSheetRepository.deleteAll();
        cleanSheetRepository.saveAll(cleanSheets);
    }

}
