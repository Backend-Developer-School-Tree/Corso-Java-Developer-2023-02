package com.threeschool.springautowiringnoconf;

import com.threeschool.springautowiringnoconf.model.ManagerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.EventListener;

@SpringBootApplication
public class ApplicationStartupEvent implements ApplicationListener<ApplicationReadyEvent> {

    // Autowired è come a dire "Spring mi serve una istanza di ManagerClass, pensaci tu a fare il "new" e dammi indietro l'istanza
    @Autowired
    private ManagerClass managerClass;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println(managerClass.hashCode());

        //System.out.println(managerClass);

        managerClass.printHello();
    }
}
