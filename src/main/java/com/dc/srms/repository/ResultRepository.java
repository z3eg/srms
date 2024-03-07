package com.dc.srms.repository;

import com.dc.srms.model.Result;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Long> {

    @Transactional
    void deleteResultsByCourseNameAndStudentName(String firstName, String studentName);
    @Transactional
    void deleteResultsByStudentName(String studentName);
    @Transactional
    void deleteResultsByCourseName(String courseName);
}
