package com.dc.srms.controller;

import com.dc.srms.model.Course;
import com.dc.srms.repository.CourseRepository;
import com.dc.srms.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;
    private final ResultRepository resultRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository,
                            ResultRepository resultRepository) {
        this.courseRepository = courseRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/list")
    String getAll(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "coursesList";
    }

    @PostMapping("/add")
    String create(Course course) {
        courseRepository.save(course);
        return "addCourse";
    }

    @GetMapping("/addForm")
    String getAddForm() {
        return "addCourse";
    }

    @GetMapping("/delete/{name}")
    String delete(@PathVariable String name, Model model) {
        Iterable<Course> courses = courseRepository.findAll();
        int initialSize = 0;
        for (Object c : courses)
            initialSize++;
        courseRepository.deleteCourseByName(name);
        resultRepository.deleteResultsByCourseName(name);
        Iterable<Course> coursesAfterDeletion = courseRepository.findAll();
        int finalSize = 0;
        for (Object c : coursesAfterDeletion)
            finalSize++;
        model.addAttribute("courses", coursesAfterDeletion);
        boolean deleted = initialSize > finalSize;
        model.addAttribute("deleted", deleted);
        return "coursesList";
    }


}
