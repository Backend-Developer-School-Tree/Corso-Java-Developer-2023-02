package com.threeschool.springautowiring.beans_config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    List<String> students() {

        List<String> studentsList = new ArrayList<>();
        studentsList.add("Davide Fella");
        studentsList.add("Simone Bianchi");

        return studentsList;
    }


    @Bean
    List<Integer> studentsIDs() {

        List<Integer> studentsList = new ArrayList<>();
        studentsList.add(42);
        studentsList.add(43);

        return studentsList;
    }

    @Bean
    List<Integer> studentsNumbers1() {

        List<Integer> studentsList = new ArrayList<>();
        studentsList.add(1);
        studentsList.add(2);

        return studentsList;
    }
}
