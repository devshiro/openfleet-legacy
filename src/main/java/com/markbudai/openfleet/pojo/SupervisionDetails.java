package com.markbudai.openfleet.pojo;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class SupervisionDetails {
    private String plate_number;
    private String manufacturer;
    private String type;
    private LocalDate date_of_supervision;
    private long days_remaining;

    public SupervisionDetails(){}

    public SupervisionDetails(String plate_no, String manufacturer, String type, LocalDate date_of_supervision, long days_remaining) {
        this.plate_number = plate_no;
        this.manufacturer = manufacturer;
        this.type = type;
        this.date_of_supervision = date_of_supervision;
        this.days_remaining = days_remaining;
    }

    public String getPlateNumber() {
        return plate_number;
    }

    public void setPlateNo(String plate_no) {
        this.plate_number = plate_no;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getDateOfSupervision() {
        return date_of_supervision;
    }

    public void setDateOfSupervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    public long getDaysRemaining() {
        return days_remaining;
    }

    public void setDaysRemaining(long days_remaining) {
        this.days_remaining = days_remaining;
    }
}
