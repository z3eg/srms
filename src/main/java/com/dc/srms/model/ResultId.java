package com.dc.srms.model;

import lombok.AllArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
public class ResultId implements Serializable {
    private String courseName;
    private String firstName;
    private String familyName;
}
