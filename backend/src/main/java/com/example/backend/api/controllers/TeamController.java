package com.example.backend.api.controllers;

import com.example.backend.api.models.Team;
import com.example.backend.api.serviceImpls.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {
    private final TeamServiceImpl teamService;

    @Autowired
    public TeamController(TeamServiceImpl teamService){
        this.teamService = teamService;
    }
    @GetMapping
    public List<Team> findAll(){
        return teamService.findAll();
    }
}
