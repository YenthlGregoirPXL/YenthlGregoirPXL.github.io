package com.example.backend.api.services;

import com.example.backend.api.models.Speeldag;
import com.example.backend.api.requests.SpeeldagRequest;

import java.util.List;

public interface SpeeldagService {
    List<Speeldag> getAll();

    Speeldag speeldagAanmaken(SpeeldagRequest speeldag);
}
