package com.markbudai.openfleet.pojo;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 05. 18..
 */
public class SupervisionDetails {
    private String plate_no;
    private String manufacturer;
    private String type;
    private LocalDate date_of_supervision;
    private long days_remaining;

    public SupervisionDetails(){}

    public SupervisionDetails(String plate_no, String manufacturer, String type, LocalDate date_of_supervision, long days_remaining) {
        this.plate_no = plate_no;
        this.manufacturer = manufacturer;
        this.type = type;
        this.date_of_supervision = date_of_supervision;
        this.days_remaining = days_remaining;
    }

    public String getPlate_no() {
        return plate_no;
    }

    public void setPlate_no(String plate_no) {
        this.plate_no = plate_no;
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

    public LocalDate getDate_of_supervision() {
        return date_of_supervision;
    }

    public void setDate_of_supervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    public long getDays_remaining() {
        return days_remaining;
    }

    public void setDays_remaining(long days_remaining) {
        this.days_remaining = days_remaining;
    }
}
