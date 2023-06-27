package com.threeschool.springautowiring;

import com.threeschool.springautowiring.dummy_persistence.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * ApplicationListener è un'interfaccia fornita dal framework Spring che consente di gestire gli eventi
 * dell'applicazione, può essere implementato per ascoltare specifici eventi che si verificano durante il
 * ciclo di vita dell'applicazione e rispondere di conseguenza.
 *
 * Utilizzando un ApplicationListener, si ottiene una maggiore flessibilità e un maggiore controllo sulla
 * sequenza di avvio dell'applicazione e sulle azioni da eseguire dopo che l'applicazione è pronta
 *
 * ApplicationReadyEvent, evento che viene generato quando l'applicazione è pronta per essere utilizzata,
 * dopo che tutti i bean sono stati configurati e il contesto dell'applicazione è completamente avviato.
 */

@SpringBootApplication
public class MyApplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    // Opzione 1 --> getBean dal Context come esempio precedent
    // Opzione 2 --> Usare Autowired
    @Autowired
    StudentManager studentManager; // Dep Injection

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println(studentManager);

        studentManager.printAllStudents();
    }
}
