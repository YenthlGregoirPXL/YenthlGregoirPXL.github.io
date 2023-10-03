package com.example.backend.api.serviceImpls;

import com.example.backend.api.models.Team;
import com.example.backend.api.repositories.TeamRepository;
import com.example.backend.api.services.teamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements teamService {

    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository){
        this.teamRepository = teamRepository;
    }

    @Override
    public Team teamAanmaken(Team team) {
        return null;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }
}
