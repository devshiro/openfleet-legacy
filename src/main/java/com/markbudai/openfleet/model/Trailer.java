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

    public LocalDate getDateOfManufacture() {
        return date_of_manufacture;
    }

    public void setDateOfManufacture(LocalDate date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    public LocalDate getDateOfAcquire() {
        return date_of_acquire;
    }

    public void setDateOfAcquire(LocalDate date_of_acquire) {
        this.date_of_acquire = date_of_acquire;
    }

    public LocalDate getDateOfSupervision() {
        return date_of_supervision;
    }

    public void setDateOfSupervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    public String getPlateNumber() {
        return plate_number;
    }

    public void setPlateNumber(String plate_number) {
        this.plate_number = plate_number;
    }

    public String getChassisNumber() {
        return chassis_number;
    }

    public void setChassisNumber(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    public long getWeight() {
        return weight;
    }

    public void setWeight(long weight) {
        this.weight = weight;
    }

    public long getMaxLoadWeight() {
        return max_load_weight;
    }

    public void setMaxLoadWeight(long max_load_weight) {
        this.max_load_weight = max_load_weight;
    }

    public LocalDate getDateOfSell() {
        return date_of_sell;
    }

    public void setDateOfSell(LocalDate date_of_sell) {
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
        if (getMaxLoadWeight() != trailer.getMaxLoadWeight()) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(trailer.getManufacturer()) : trailer.getManufacturer() != null)
            return false;
        if (getType() != null ? !getType().equals(trailer.getType()) : trailer.getType() != null) return false;
        if (getDateOfManufacture() != null ? !getDateOfManufacture().equals(trailer.getDateOfManufacture()) : trailer.getDateOfManufacture() != null)
            return false;
        if (getDateOfAcquire() != null ? !getDateOfAcquire().equals(trailer.getDateOfAcquire()) : trailer.getDateOfAcquire() != null)
            return false;
        if (getDateOfSupervision() != null ? !getDateOfSupervision().equals(trailer.getDateOfSupervision()) : trailer.getDateOfSupervision() != null)
            return false;
        if (getPlateNumber() != null ? !getPlateNumber().equals(trailer.getPlateNumber()) : trailer.getPlateNumber() != null)
            return false;
        if (getChassisNumber() != null ? !getChassisNumber().equals(trailer.getChassisNumber()) : trailer.getChassisNumber() != null)
            return false;
        return getDateOfSell() != null ? getDateOfSell().equals(trailer.getDateOfSell()) : trailer.getDateOfSell() == null;
    }

    @Override
    public int hashCode() {
        int result = getManufacturer() != null ? getManufacturer().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDateOfManufacture() != null ? getDateOfManufacture().hashCode() : 0);
        result = 31 * result + (getDateOfAcquire() != null ? getDateOfAcquire().hashCode() : 0);
        result = 31 * result + (getDateOfSupervision() != null ? getDateOfSupervision().hashCode() : 0);
        result = 31 * result + (getPlateNumber() != null ? getPlateNumber().hashCode() : 0);
        result = 31 * result + (getChassisNumber() != null ? getChassisNumber().hashCode() : 0);
        result = 31 * result + (int) (getWeight() ^ (getWeight() >>> 32));
        result = 31 * result + (int) (getMaxLoadWeight() ^ (getMaxLoadWeight() >>> 32));
        result = 31 * result + (getDateOfSell() != null ? getDateOfSell().hashCode() : 0);
        return result;
    }
}
