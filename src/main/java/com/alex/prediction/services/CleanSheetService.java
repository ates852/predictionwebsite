package com.alex.prediction.services;

import com.alex.prediction.models.CleanSheet;
import com.alex.prediction.repository.CleanSheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CleanSheetService {
    @Autowired
    private CleanSheetRepository cleanSheetRepository;

    public Iterable<CleanSheet> getList(String season) {
        return cleanSheetRepository.findAllByPositionAndSeason("Goalkeeper",season);
    }

    public CleanSheet save(CleanSheet cleanSheet) {
        return cleanSheetRepository.save(cleanSheet);
    }

    public void save(List<CleanSheet> cleanSheets) {
        cleanSheetRepository.deleteAll();
        cleanSheetRepository.saveAll(cleanSheets);
    }

}
