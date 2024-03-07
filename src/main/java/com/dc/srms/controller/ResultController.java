package com.dc.srms.controller;

import com.dc.srms.model.Result;
import com.dc.srms.repository.CourseRepository;
import com.dc.srms.repository.ResultRepository;
import com.dc.srms.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/result")
public class ResultController {

    StudentRepository studentRepository;
    CourseRepository courseRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public ResultController(StudentRepository studentRepository, CourseRepository courseRepository, ResultRepository resultRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/list")
    public String getAll(Model model) {
        model.addAttribute("results", resultRepository.findAll());
        return "resultsList";
    }

    @GetMapping("/addForm")
    String getAddForm(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("courses", courseRepository.findAll());
        return "addResult";
    }

    @PostMapping("/add")
    String create(Result result) {
        resultRepository.save(result);
        return "addResult";
    }
}
