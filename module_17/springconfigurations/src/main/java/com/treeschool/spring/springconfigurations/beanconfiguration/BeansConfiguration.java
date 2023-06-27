package com.treeschool.spring.springconfigurations.beanconfiguration;


import com.treeschool.spring.springconfigurations.model.Student;
import com.treeschool.spring.springconfigurations.model.impl.CollegeStudent;
import com.treeschool.spring.springconfigurations.model.impl.HighSchoolStudent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * Annotazione di classe per indicare che è una configurazione Spring.
 * In questa classe verranno definiti i bean che saranno gestiti dal contesto dell'applicazione
 */
@Configuration
public class BeansConfiguration {

    /**
     * Definisce un bean gestito dal contesto dell'applicazione. Il metodo restituisce un oggetto che
     * sarà istanziato e gestito dal contesto. I bean definiti in questo modo possono essere iniettati
     * in altre parti dell'applicazione
     *
     */
    @Bean
    public Student collegeStudentNY() {
        return new CollegeStudent(0, "New York", 7);
    }

    @Bean
    public Student highSchoolStudentNY() {
        return new HighSchoolStudent(42, "New York", 8);
    }
}
