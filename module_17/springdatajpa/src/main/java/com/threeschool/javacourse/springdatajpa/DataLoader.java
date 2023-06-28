package com.threeschool.javacourse.springdatajpa;

import com.threeschool.javacourse.springdatajpa.model.Esame;
import com.threeschool.javacourse.springdatajpa.model.Studente;
import com.threeschool.javacourse.springdatajpa.repository.EsameRepository;
import com.threeschool.javacourse.springdatajpa.repository.StudenteRepository;
import com.threeschool.javacourse.springdatajpa.service.EsameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/*
* object references an unsaved transient instance - save the transient instance
* before flushing
* --> Hibernate vi dice che l'istanza di quello oggetto non è stata prima salvata, in assenza di CASCADE va salvata prima
* */
@Component
public class DataLoader  implements CommandLineRunner {

    @Autowired
    EsameService esameService;

    @Autowired
    StudenteRepository studenteRepository;

    @Override
    public void run(String... args) throws Exception {

        Studente s1 = new Studente();
        studenteRepository.save(s1);

        Esame analisi1 = new Esame("Analisi I", 30, s1);
        esameService.save(analisi1);
    }
}
