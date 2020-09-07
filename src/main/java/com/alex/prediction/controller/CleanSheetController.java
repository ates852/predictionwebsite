package com.alex.prediction.controller;

import com.alex.prediction.models.CleanSheet;
import com.alex.prediction.services.CleanSheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/CleanSheets")
public class CleanSheetController {

    @Autowired
    private CleanSheetService cleanSheetService;

    @GetMapping("/list")
    @PreAuthorize("hasRole('USER')or hasRole('ADMIN')")
    public Iterable<CleanSheet> list(@RequestParam String season) {
        return cleanSheetService.getList(season);
    }

}
