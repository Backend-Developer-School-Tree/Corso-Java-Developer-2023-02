package com.threeschool.springrestapi.service;

import com.threeschool.springrestapi.model.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*
* stub methods
* */
@Service
public class StudentService {

    static Logger logger = LoggerFactory.getLogger(StudentService.class);

    public List<Student> findAll(){
        logger.info("[FINDALL STUDENT]: ");

        List<Student> students = new ArrayList<>();
        students.add(new Student(1L, "Dummy 1"));
        students.add(new Student(2L, "Dummy 2"));

        return students;
    }

    public Optional<Student> findByID(Long id){
        logger.info("[GETBYID STUDENT]: " + id);

        if(id == 0)
            return Optional.empty();

        return Optional.of(new Student(id, "Dummy Student"));
    }

    public Student save(Student s){
        logger.info("[SAVE STUDENT]: " + s);

        return s;
    }

    public Student update(Student s){
        logger.info("[UPDATE STUDENT]: " + s);

        return s;
    }

    public void deleteByID(Long id){
        logger.info("[DELETE STUDENT]: " + id);

    }
}
