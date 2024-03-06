package com.dc.srms.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@IdClass(StudentId.class)
public class Student {
    @Id
    private String firstName;
    @Id
    private String familyName;
    private Date dateOfBirth;
    @Column(unique=true)
    private String emailAddress;
}
