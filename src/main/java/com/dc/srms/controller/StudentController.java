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
    public String getAddForm() {
        return "addStudent";
    }

    @PostMapping("/add")
    public String create(Student student, Model model) {
        boolean addedSuccessfully = true;
        Iterable<Student> studentsBefore = studentRepository.findAll();
        int numberOfStudentsBeforeAdding = 0;
        for (Object s : studentsBefore)
            numberOfStudentsBeforeAdding++;
        String originalDateOfBirth = student.getDateOfBirth();
        student.setDateOfBirth(shuffleDate(originalDateOfBirth));
        try {
            studentRepository.save(student);
        }
        catch(Exception ex) {
            addedSuccessfully = false;
            student.setDateOfBirth(originalDateOfBirth);
            model.addAttribute("failedStudent", student);
        }
        Iterable<Student> studentsAfter = studentRepository.findAll();
        int numberOfStudentsAfterAdding = 0;
        for (Object s : studentsAfter)
            numberOfStudentsAfterAdding++;
        if (numberOfStudentsAfterAdding<=numberOfStudentsBeforeAdding)
            addedSuccessfully = false;
        model.addAttribute("addedSuccessfully", addedSuccessfully);
        return "addStudent";
    }

    private String shuffleDate(String dateOfBirth) {
        if (dateOfBirth==null)
            return null;
        String[] split = dateOfBirth.split("-");
        return split[1] + "/" + split[2] + "/" + split[0];
    }

    @GetMapping("/delete/{firstName}/{familyName}")
    public String delete(@PathVariable String firstName, @PathVariable String familyName, Model model) {
        resultRepository.deleteResultsByStudentName(firstName+' '+familyName);
        studentRepository.deleteStudentByFirstNameAndFamilyName(firstName,familyName);
        model.addAttribute("students", studentRepository.findAll());
        return "studentsList";
    }

}
