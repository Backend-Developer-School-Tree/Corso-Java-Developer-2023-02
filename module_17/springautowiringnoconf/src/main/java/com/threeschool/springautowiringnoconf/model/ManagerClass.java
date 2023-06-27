package com.threeschool.springautowiringnoconf.model;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class ManagerClass {

    DepClass dependencyClass;

    /*public ManagerClass(){
        System.out.println("Sono nel costruttore di ManagerClass");
    }*/

    // Autowired può essere anche su variabile di istanza
    @Autowired
    public ManagerClass(DepClass dependencyClass){
        this.dependencyClass = dependencyClass;
    }

    /*public ManagerClass(String s){
    }*/

    public void printHello(){

        System.out.println("Dependency Class: " + dependencyClass);
    }

}
