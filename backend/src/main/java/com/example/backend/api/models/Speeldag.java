package com.example.backend.api.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "speeldagen")
public class Speeldag {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private LocalDate datum;
    private Double opbrengst;
    @ManyToOne
    private Team tegenstander;

    public Speeldag(){

    }

    public Speeldag(LocalDate datum, Double opbrengst, Team tegenstander) {
        this.datum = datum;
        this.opbrengst = opbrengst;
        this.tegenstander = tegenstander;
    }

    public LocalDate getDatum() {
        return datum;
    }

    public void setDatum(LocalDate datum) {
        this.datum = datum;
    }

    public Double getOpbrengst() {
        return opbrengst;
    }

    public void setOpbrengst(Double opbrengst) {
        this.opbrengst = opbrengst;
    }

    public Team getTegenstander() {
        return tegenstander;
    }

    public void setTegenstander(Team tegenstander) {
        this.tegenstander = tegenstander;
    }
}
