package com.alex.prediction.controller;

import com.alex.prediction.models.Assist;
import com.alex.prediction.services.AssistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/assists")
public class AssistController {

    @Autowired
    private AssistService assistService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<Assist> list(@RequestParam String season) {
        return assistService.getList(season);
    }

}
