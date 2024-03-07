package com.dc.srms.repository;

import com.dc.srms.model.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Transactional
    void deleteStudentByFirstNameAndFamilyName(String firstName, String familyName);
}
