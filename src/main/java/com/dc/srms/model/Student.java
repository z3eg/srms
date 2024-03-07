package com.dc.srms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
@IdClass(StudentId.class)
public class Student {
    @Id
    private String firstName;
    @Id
    private String familyName;
    private String dateOfBirth;
    @Column(unique=true)
    private String emailAddress;
}
