package com.threeschool.springrestapi.controller.api;

import com.threeschool.springrestapi.model.Student;
import com.threeschool.springrestapi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class StudentController {

    @Autowired
    StudentService studentService;

    final String versionV1 = "v1";
    final String versionV2 = "v2";

    @GetMapping(versionV2 + "/students")
    public ResponseEntity<List<Student>> getAllStudents(){

        List<Student> result = studentService.findAll();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping(versionV1 + "/student")
    public ResponseEntity<Optional<Student>> getStudentByID(@RequestParam Long id){

        Optional<Student> result = studentService.findByID(id);

        if(result.isEmpty())
            //null potrei mapparlo con classe wrapper (POJO)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping(versionV1 + "/student")
    public ResponseEntity<Student> createStudent(@RequestBody Student newStudent){

        Student studentSaved = studentService.save(newStudent);

        return new ResponseEntity<>(studentSaved, HttpStatus.OK);
    }

    @PutMapping(versionV1 + "/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student updateStudent){

        Student studentUpdated = studentService.update(updateStudent);

        return new ResponseEntity<>(studentUpdated, HttpStatus.OK);
    }

    @DeleteMapping(versionV1 + "/student/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable Long id){

        studentService.deleteByID(id);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }


}
