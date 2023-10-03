package com.example.backend.api.models;

import jakarta.persistence.*;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private String naam;



    public void setNaam(String naam) {
        this.naam = naam;
    }

    public Long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }
}
