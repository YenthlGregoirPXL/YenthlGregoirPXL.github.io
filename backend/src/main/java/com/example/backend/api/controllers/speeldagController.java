package com.example.backend.api.controllers;

import com.example.backend.api.models.Speeldag;
import com.example.backend.api.requests.SpeeldagRequest;
import com.example.backend.api.serviceImpls.SpeeldagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/speeldagen")
public class speeldagController {

    private final SpeeldagServiceImpl speeldagService;

    @Autowired
    public speeldagController(SpeeldagServiceImpl speeldagService) {
        this.speeldagService = speeldagService;
    }

    @PostMapping("/toevoegen")
    public Speeldag createSpeeldag(@RequestBody SpeeldagRequest speeldagRequest) {
        return speeldagService.speeldagAanmaken(speeldagRequest);
    }

    @GetMapping
    public List<Speeldag> getAll(){
        return speeldagService.getAll();
    }
}
