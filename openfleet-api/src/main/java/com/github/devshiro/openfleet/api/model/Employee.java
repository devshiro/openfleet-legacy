package com.github.devshiro.openfleet.api.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Employee implements Serializable {

    private long id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    private Location placeOfBirth;

    private String socialInsuranceNo;

    private String mothersName;

    private String taxNo;

    private String driversCardNo;

    private Location placeOfLiving;

    private LocalDate employmentDate;

    private LocalDate endOfEmploymentDate;
}
