package com.dc.srms.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Entity
@Data
@IdClass(ResultId.class)
public class Result {
    @Id
    private String courseName;
    @Id
    private String firstName;
    @Id
    private String familyName;
    private char score;
}
