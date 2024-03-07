package com.dc.srms.controller;

import com.dc.srms.model.Course;
import com.dc.srms.repository.CourseRepository;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/course")
public class CourseController {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @GetMapping("/list")
    String getAll(Model model) {
        model.addAttribute("courses", courseRepository.findAll());
        return "coursesList";
    }

    @PostMapping(value="/add", headers = "HX-Request")
    String create(Course course) {
        courseRepository.save(course);
        return "redirect:/";
    }

    @GetMapping("/addForm")
    String getAddForm() {
        return "addCourse";
    }

    @DeleteMapping(value="/delete/{name}")
    String delete(@PathVariable String name,
                  HttpServletResponse response) {
        courseRepository.deleteCourseByName(name);
//        response.setHeader("HX-Trigger", "itemDeleted");
        return "index";
    }


}
