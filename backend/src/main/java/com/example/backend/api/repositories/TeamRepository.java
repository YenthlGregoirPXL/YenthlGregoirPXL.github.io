package com.example.backend.api.repositories;

import com.example.backend.api.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findTeamByNaam(String naam);
}
