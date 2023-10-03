package com.example.backend.api.serviceImpls;

import com.example.backend.api.models.Speeldag;
import com.example.backend.api.repositories.SpeeldagRepository;
import com.example.backend.api.repositories.TeamRepository;
import com.example.backend.api.requests.SpeeldagRequest;
import com.example.backend.api.services.SpeeldagService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class SpeeldagServiceImpl implements SpeeldagService {

    private final SpeeldagRepository speeldagRepository;
    private final TeamRepository teamRepository;

    public SpeeldagServiceImpl(SpeeldagRepository repository , TeamRepository teamRepository){
        speeldagRepository = repository;
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Speeldag> getAll() {
        return speeldagRepository.findAll();
    }

    @Override
    public Speeldag speeldagAanmaken(SpeeldagRequest speeldag) {
        Speeldag newSpeeldag = new Speeldag();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        newSpeeldag.setDatum(LocalDate.parse(speeldag.datum() , dateFormatter));
        newSpeeldag.setOpbrengst(speeldag.bedrag());
        newSpeeldag.setTegenstander(teamRepository.findTeamByNaam(speeldag.tegenstanderNaam()));

        speeldagRepository.save(newSpeeldag);
        return newSpeeldag;
    }
}
