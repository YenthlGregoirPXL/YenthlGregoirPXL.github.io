package com.example.backend.api.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Uitgave {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private LocalDate datum;
    private Double bedrag;
    private String omschrijving;

    public Uitgave(){
        //jpa only
    }

    public Uitgave(LocalDate datum, Double bedrag, String omschrijving) {
        this.datum = datum;
        this.bedrag = bedrag;
        this.omschrijving = omschrijving;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Double getBedrag() {
        return bedrag;
    }

    public void setBedrag(Double bedrag) {
        this.bedrag = bedrag;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
}
