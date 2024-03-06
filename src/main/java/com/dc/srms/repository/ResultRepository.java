package com.dc.srms.repository;

import com.dc.srms.model.Result;
import org.springframework.data.repository.CrudRepository;

public interface ResultRepository extends CrudRepository<Result, Long> {

    void deleteResultsByCourseNameAndFirstNameAndFamilyName(String firstName, String familyName, String courseName);

    void deleteResultsByFirstNameAndFamilyName(String firstName, String familyName);

    void deleteResultsByCourseName(String courseName);
}
