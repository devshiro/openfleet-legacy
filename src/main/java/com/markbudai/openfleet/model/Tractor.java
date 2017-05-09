package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Mark on 2017. 04. 14..
 */
@Entity
@Table(name = "Tractor")
public class Tractor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String manufacturer;
    private String type;
    private LocalDate date_of_manufacture;
    private LocalDate date_of_acquire;
    private LocalDate date_of_supervision;
    private String plate_number;
    private String chassis_number;
    private double fuel_norm;
    private long weight;
    private long max_weight;
    private LocalDate date_of_sell;

    public Tractor() {}

    public Tractor(long id, String manufacturer, String type, LocalDate date_of_manufacture, LocalDate date_of_acquire, LocalDate date_of_supervision, String plate_number, String chassis_number, double fuel_norm, long weight, long max_weight) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.type = type;
        this.date_of_manufacture = date_of_manufacture;
        this.date_of_acquire = date_of_acquire;
        this.date_of_supervision = date_of_supervision;
        this.plate_number = plate_number;
        this.chassis_number = chassis_number;
        this.fuel_norm = fuel_norm;
        this.weight = weight;
        this.max_weight = max_weight;
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

    public double getFuel_norm() {
        return fuel_norm;
    }

    public void setFuel_norm(double fuel_norm) {
        this.fuel_norm = fuel_norm;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getMax_weight() {
        return max_weight;
    }

    public void setMax_weight(long max_weight) {
        this.max_weight = max_weight;
    }

    public LocalDate getDate_of_sell() {
        return date_of_sell;
    }

    public void setDate_of_sell(LocalDate date_of_sell) {
        this.date_of_sell = date_of_sell;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(this.getManufacturer()).append(" ").append(this.getType()).toString();
    }
}
