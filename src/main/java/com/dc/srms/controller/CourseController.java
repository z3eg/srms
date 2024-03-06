package com.dc.srms.controller;

import com.dc.srms.model.Course;
import com.dc.srms.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping
    String getAll() {
        StringBuilder sb = new StringBuilder();
        courseRepository.findAll().forEach(c -> sb.append(c.getName()).append('\n'));
        return sb.toString();
    }

    @PostMapping
    void create(@RequestParam String courseName) {
        courseRepository.save(new Course(courseName));
    }

    @DeleteMapping
    void delete(@RequestParam String courseName) {
        courseRepository.deleteCourseByName(courseName);
    }


}
