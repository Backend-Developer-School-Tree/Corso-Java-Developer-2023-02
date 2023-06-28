package com.threeschool.javacourse.springdatajpa.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Esame {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Studente studente;

    private String materia;

    private Integer votazione;

    public Esame(String materia, Integer votazione, Studente studente){
        this.materia = materia;
        this.votazione = votazione;
        this.studente = studente;
    }

    public Esame(String materia, Integer votazione) {
        this.materia = materia;
        this.votazione = votazione;
    }
}
