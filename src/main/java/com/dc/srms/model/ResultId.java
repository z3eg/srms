package com.dc.srms.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
public class ResultId implements Serializable {
    private String courseName;
    private String studentName;
}
