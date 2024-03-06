package com.dc.srms.controller;

import com.dc.srms.repository.ResultRepository;
import com.dc.srms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController()
@RequestMapping("/student")
public class StudentController {

    StudentRepository studentRepository;
    ResultRepository resultRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, ResultRepository resultRepository) {
        this.studentRepository = studentRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/all")
    public String getAll() {
        return "ALL";
    }

    @DeleteMapping
    public void delete(String firstName, String familyName) {
        resultRepository.deleteResultsByFirstNameAndFamilyName(firstName,familyName);
        studentRepository.deleteStudentByFirstNameAndFamilyName(firstName,familyName);
    }

}
