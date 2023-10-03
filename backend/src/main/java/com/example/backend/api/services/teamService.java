package com.example.backend.api.services;

import com.example.backend.api.models.Team;

import java.util.List;

public interface teamService {
    Team teamAanmaken(Team team);
    List<Team> findAll();
}
