package com.treeschool.spring.springconfigurations.model.impl;

import com.treeschool.spring.springconfigurations.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HighSchoolStudent implements Student {

    private int id;
    private String schoolCity;
    private int averageGrades;


    @Override
    public void printGradesExams() {
        System.out.println("[Highschool Student] - ID: " + id + " City: " + schoolCity + " Average: " + averageGrades);
    }
}
