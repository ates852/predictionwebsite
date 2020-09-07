package com.alex.prediction.controller;

import com.alex.prediction.models.Scorer;
import com.alex.prediction.services.ScorerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/scorers")
public class ScorerController {

    @Autowired
    private ScorerService scorerService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<Scorer> list(@RequestParam String season) {
        return scorerService.getList(season);
    }

}
