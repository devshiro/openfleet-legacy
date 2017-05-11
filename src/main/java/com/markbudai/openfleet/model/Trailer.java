package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by Mark on 2017. 04. 14..
 */
@Entity
@Table(name = "Trailer")
public class Trailer {
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
    private long weight;
    private long max_load_weight;
    private LocalDate date_of_sell;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trailer)) return false;

        Trailer trailer = (Trailer) o;

        if (getWeight() != trailer.getWeight()) return false;
        if (getMax_load_weight() != trailer.getMax_load_weight()) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(trailer.getManufacturer()) : trailer.getManufacturer() != null)
            return false;
        if (getType() != null ? !getType().equals(trailer.getType()) : trailer.getType() != null) return false;
        if (getDate_of_manufacture() != null ? !getDate_of_manufacture().equals(trailer.getDate_of_manufacture()) : trailer.getDate_of_manufacture() != null)
            return false;
        if (getDate_of_acquire() != null ? !getDate_of_acquire().equals(trailer.getDate_of_acquire()) : trailer.getDate_of_acquire() != null)
            return false;
        if (getDate_of_supervision() != null ? !getDate_of_supervision().equals(trailer.getDate_of_supervision()) : trailer.getDate_of_supervision() != null)
            return false;
        if (getPlate_number() != null ? !getPlate_number().equals(trailer.getPlate_number()) : trailer.getPlate_number() != null)
            return false;
        if (getChassis_number() != null ? !getChassis_number().equals(trailer.getChassis_number()) : trailer.getChassis_number() != null)
            return false;
        return getDate_of_sell() != null ? getDate_of_sell().equals(trailer.getDate_of_sell()) : trailer.getDate_of_sell() == null;
    }

    @Override
    public int hashCode() {
        int result = getManufacturer() != null ? getManufacturer().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDate_of_manufacture() != null ? getDate_of_manufacture().hashCode() : 0);
        result = 31 * result + (getDate_of_acquire() != null ? getDate_of_acquire().hashCode() : 0);
        result = 31 * result + (getDate_of_supervision() != null ? getDate_of_supervision().hashCode() : 0);
        result = 31 * result + (getPlate_number() != null ? getPlate_number().hashCode() : 0);
        result = 31 * result + (getChassis_number() != null ? getChassis_number().hashCode() : 0);
        result = 31 * result + (int) (getWeight() ^ (getWeight() >>> 32));
        result = 31 * result + (int) (getMax_load_weight() ^ (getMax_load_weight() >>> 32));
        result = 31 * result + (getDate_of_sell() != null ? getDate_of_sell().hashCode() : 0);
        return result;
    }
}
