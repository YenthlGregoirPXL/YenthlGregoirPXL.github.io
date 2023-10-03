package com.example.backend.api.controllers;

import com.example.backend.api.models.Uitgave;
import com.example.backend.api.requests.UitgaveRequest;
import com.example.backend.api.serviceImpls.UitgaveServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Uitgave")
public class UitgaveController {

    private final UitgaveServiceImpl uitgaveService;

    @Autowired
    public UitgaveController(UitgaveServiceImpl uitgaveService){
        this.uitgaveService = uitgaveService;
    }


    @GetMapping
    public List<Uitgave> getAll(){
        return uitgaveService.getAll();
    }
    @PostMapping("/toevoegen")
    public Uitgave uitgaveAanmaken(@RequestBody UitgaveRequest uitgaveRequest){
        return uitgaveService.uitgaveAanmaken(uitgaveRequest);
    }


}

