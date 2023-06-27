package com.treeschool.spring.springconfigurations.model.impl;

import com.treeschool.spring.springconfigurations.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CollegeStudent  implements Student {

    private int id;
    private String collegeCity;
    private int averageGrades;

    @Override
    public void printGradesExams() {
        System.out.println("[CollegeStudent Student] - ID: " + id + " City: " + collegeCity + " Average: " + averageGrades);
    }
}
