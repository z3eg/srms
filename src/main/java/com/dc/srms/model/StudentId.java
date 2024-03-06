package com.dc.srms.model;

import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
public class StudentId implements Serializable {
    private String firstName;
    private String familyName;
}
