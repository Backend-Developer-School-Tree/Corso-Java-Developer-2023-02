package com.threeschool.springautowiring.dummy_persistence;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/*
* Senza @Component non è un Bean di Spring ma una semplice classe di Java
*
* Ricorda, Autowired può essere usato anche su Costruttore e sul set della variabile (setStudents)
* */
@Data
@Component
public class StudentManager {

    @Autowired
    private List<String> students;

    @Autowired
    private List<String> studentsRandomListName;

    @Autowired
    private List<Integer> studentsIDs; //nome esatto in AppConfig.java

    //Se non metto Autowired Spring non lo istanzia (No Dep Inj)
    //@Autowired
    //private List<Integer> studentsIDsRandomName; //Va in errore perché senza @Primary Spring non sa quale istanza passare

    public void printAllStudents(){

        System.out.println("Stampa lista students");
        System.out.println(students);

        System.out.println("Stampa lista IDs");
        System.out.println(studentsIDs);
    }

}
