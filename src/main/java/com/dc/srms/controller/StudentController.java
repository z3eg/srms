package com.dc.srms.controller;

import com.dc.srms.model.Student;
import com.dc.srms.repository.ResultRepository;
import com.dc.srms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "studentsList";
    }

    @GetMapping("/addForm")
    String getAddForm() {
        return "addStudent";
    }

    @PostMapping("/add")
    String create(Student student) {
        //TODO shuffle date fields to adhere to the required format
        studentRepository.save(student);
        return "addStudent";
    }

    @GetMapping("/delete/{firstName}/{familyName}")
    public String delete(@PathVariable String firstName, @PathVariable String familyName, Model model) {
        resultRepository.deleteResultsByStudentName(firstName+' '+familyName);
        studentRepository.deleteStudentByFirstNameAndFamilyName(firstName,familyName);
        model.addAttribute("students", studentRepository.findAll());
        return "studentsList";
    }

}
