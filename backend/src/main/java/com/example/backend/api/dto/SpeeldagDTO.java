package com.example.backend.api.dto;


import com.example.backend.api.models.Team;

import java.time.LocalDate;

public record SpeeldagDTO(Long id , LocalDate datum , Double opbrengst , Team team) {
}
