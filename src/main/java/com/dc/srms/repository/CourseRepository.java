package com.dc.srms.repository;

import com.dc.srms.model.Course;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Long> {

    @Transactional
    void deleteCourseByName(String name);
}
