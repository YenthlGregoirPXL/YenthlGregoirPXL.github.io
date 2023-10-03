package com.example.backend.api.services;

import com.example.backend.api.models.Uitgave;
import com.example.backend.api.requests.UitgaveRequest;

import java.util.List;

public interface UitgaveService {

    Uitgave uitgaveAanmaken(UitgaveRequest uitgaveRequest);
    List<Uitgave> getAll();
}
