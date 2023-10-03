package com.example.backend.api.serviceImpls;

import com.example.backend.api.models.Uitgave;
import com.example.backend.api.repositories.UitgaveRepository;
import com.example.backend.api.requests.UitgaveRequest;
import com.example.backend.api.services.UitgaveService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class UitgaveServiceImpl implements UitgaveService{

    private final UitgaveRepository uitgaveRepository;

    public UitgaveServiceImpl(UitgaveRepository uitgaveRepository){
        this.uitgaveRepository = uitgaveRepository;
    }

    @Override
    public Uitgave uitgaveAanmaken(UitgaveRequest uitgaveRequest) {
        Uitgave newUitgave = new Uitgave();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        newUitgave.setDatum(LocalDate.parse(uitgaveRequest.datum() , dateFormatter));
        newUitgave.setBedrag(uitgaveRequest.bedrag());
        newUitgave.setOmschrijving(uitgaveRequest.omschrijving());

        uitgaveRepository.save(newUitgave);
        return newUitgave;
    }

    @Override
    public List<Uitgave> getAll() {
        return uitgaveRepository.findAll();
    }
}
