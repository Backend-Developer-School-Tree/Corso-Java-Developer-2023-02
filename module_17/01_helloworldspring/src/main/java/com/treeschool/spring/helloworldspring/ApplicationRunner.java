package com.treeschool.spring.helloworldspring;

import lombok.extern.apachecommons.CommonsLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(ApplicationRunner.class);

    @Value("${myapplication.myparam}")
    private String myParamPath2File;

    @Override
    public void run(String... args) throws Exception {
        logger.info("*** SPRING BOOT STARTUP - START ***");

        // Caricamento Dati
        // Logging particolare
        // Invocazione di servizi REST
        // Controllo parametri
        // Funzionalità persistenza
        // ...
        logger.info(myParamPath2File);

        logger.info("*** SPRING BOOT STARTUP - END ***");
    }
}
