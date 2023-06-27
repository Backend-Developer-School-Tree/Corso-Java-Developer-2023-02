package com.threeschool.springautowiringnoconf;

import com.threeschool.springautowiringnoconf.model.ManagerClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ApplicationStartupEvent2 implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ManagerClass managerClass;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println(managerClass.hashCode());

        System.out.println(managerClass);

        //managerClass.printHello();
    }
}
