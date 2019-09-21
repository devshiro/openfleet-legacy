package com.github.devshiro.openfleet.api.model;

import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

@Data
@Builder
@FieldNameConstants
public class Location implements Serializable {

    private long id;

    private String country;

    private String region;

    private String city;

    private String street;

    private String houseNo;

    private String zipcode;
}
