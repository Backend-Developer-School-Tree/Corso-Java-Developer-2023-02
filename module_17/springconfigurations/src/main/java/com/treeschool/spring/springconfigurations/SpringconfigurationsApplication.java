package com.treeschool.spring.springconfigurations;

import com.treeschool.spring.springconfigurations.beanconfiguration.BeansConfiguration;
import com.treeschool.spring.springconfigurations.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
 * Sta ad indicare che questa classe è l'entry point dell'applicazione Spring Boot. Combina diverse
 * annotazioni, tra cui @Configuration, @EnableAutoConfiguration e @ComponentScan.
 * Questa annotazione avvia l'applicazione Spring Boot e configura automaticamente diversi aspetti,
 * come la gestione dei bean, l'auto-configurazione e la scansione dei componenti.
 */
@SpringBootApplication
public class SpringconfigurationsApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringconfigurationsApplication.class, args);

		/*
		 * AnnotationConfigApplicationContext è una classe fornita dal framework Spring e viene
		 * utilizzata per creare un contesto di applicazione basato su annotazioni a partire da
		 * una o più classi di configurazione annotate con @Configuration.
		 */
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		Student hsNY = (Student) ctx.getBean("highSchoolStudentNY"); //nome del bean
		hsNY.printGradesExams();

		Student csNY = (Student) ctx.getBean("collegeStudentNY");
		csNY.printGradesExams();
	}

}
