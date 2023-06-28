package com.threeschool.javacourse.springdatajpa.service;

import com.threeschool.javacourse.springdatajpa.model.Esame;
import com.threeschool.javacourse.springdatajpa.repository.EsameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EsameService {

    @Autowired
    EsameRepository esameRepository;

    // Qui ci va logica di business (CRUD + Algoritmi e controlli)
    public Esame save(Esame e){
        return esameRepository.save(e);
    }
}
