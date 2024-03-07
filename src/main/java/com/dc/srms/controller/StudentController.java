package com.dc.srms.controller;

import com.dc.srms.repository.ResultRepository;
import com.dc.srms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/student")
public class StudentController {

    StudentRepository studentRepository;
    ResultRepository resultRepository;

    @Autowired
    public StudentController(StudentRepository studentRepository, ResultRepository resultRepository) {
        this.studentRepository = studentRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping
    public String getAll() {
        return "studentsList";
    }

    @DeleteMapping
    public void delete(String firstName, String familyName) {
        resultRepository.deleteResultsByFirstNameAndFamilyName(firstName,familyName);
        studentRepository.deleteStudentByFirstNameAndFamilyName(firstName,familyName);
    }

}
