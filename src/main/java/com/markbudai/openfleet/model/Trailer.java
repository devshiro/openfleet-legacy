package com.markbudai.openfleet.model;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 04. 14..
 */
public class Trailer {
    private long id;
    private String manufacturer;
    private String type;
    private LocalDate date_of_manufacture;
    private LocalDate date_of_acquire;
    private LocalDate date_of_supervision;
    private String plate_number;
    private String chassis_number;
    private long weight;
    private long max_load_weight;

    public Trailer() {
    }

    public Trailer(long id, String manufacturer, String type, LocalDate date_of_manufacture, LocalDate date_of_acquire, LocalDate date_of_supervision, String plate_number, String chassis_number, long weight, long max_load_weight) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.date_of_manufacture = date_of_manufacture;
        this.date_of_acquire = date_of_acquire;
        this.date_of_supervision = date_of_supervision;
        this.plate_number = plate_number;
        this.chassis_number = chassis_number;
        this.weight = weight;
        this.max_load_weight = max_load_weight;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate_of_manufacture() {
        return date_of_manufacture;
    }

    public void setDate_of_manufacture(LocalDate date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    public LocalDate getDate_of_acquire() {
        return date_of_acquire;
    }

    public void setDate_of_acquire(LocalDate date_of_acquire) {
        this.date_of_acquire = date_of_acquire;
    }

    public LocalDate getDate_of_supervision() {
        return date_of_supervision;
    }

    public void setDate_of_supervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getChassis_number() {
        return chassis_number;
    }

    public void setChassis_number(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getMax_load_weight() {
        return max_load_weight;
    }

    public void setMax_load_weight(long max_load_weight) {
        this.max_load_weight = max_load_weight;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(this.getManufacturer()).append(" ").append(this.getType()).toString();
    }
}
