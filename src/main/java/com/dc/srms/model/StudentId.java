package com.dc.srms.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class StudentId implements Serializable {
    private String firstName;
    private String familyName;
}
