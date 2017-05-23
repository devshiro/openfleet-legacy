package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class representing a semi-truck.
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

    /**
     * Empty constructor for the truck.
     */
    public Tractor() {}

    /**
     * Constructor for the truck object.
     * @param id the id of the truck.
     * @param manufacturer the manufacturer of the truck.
     * @param type the model name of the truck.
     * @param date_of_manufacture the production date of the truck.
     * @param date_of_acquire the date when the company bought the truck.
     * @param date_of_supervision the date when the truck needs to be inspected again.
     * @param plate_number the license plate number of the truck.
     * @param chassis_number the chassis number or VIN of the truck.
     * @param fuel_norm the fuel normative of the truck.
     * @param weight the self weight of the truck.
     * @param max_weight the maximum weight capacity of the truck.
     */
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

    /**
     * Gets the id of the truck object.
     * @return the id of the truck object.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of the truck object.
     * @param id the id of the truck object.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the manufacturer of the truck.
     * @return the manufacturer of the truck.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the truck.
     * @param manufacturer the manufacturer of the truck.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the type or model name of the truck.
     * @return the type or model name of the truck.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type or model name of the truck.
     * @param type the type or model name of the truck.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the date when the truck was manufactured.
     * @return the date when the truck was manufactured.
     */
    public LocalDate getDateOfManufacture() {
        return date_of_manufacture;
    }

    /**
     * Sets the date when the truck was manufactured.
     * @param date_of_manufacture the date when the truck was manufactured.
     */
    public void setDate_of_manufacture(LocalDate date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    /**
     * Gets the date when the company acquired the truck.
     * @return the date when the company acquired the truck.
     */
    public LocalDate getDate_of_acquire() {
        return date_of_acquire;
    }

    /**
     * Sets the date when the company acquired the truck.
     * @param date_of_acquire the date when the company acquired the truck.
     */
    public void setDate_of_acquire(LocalDate date_of_acquire) {
        this.date_of_acquire = date_of_acquire;
    }

    /**
     * Gets the date when the truck needs to be inspected again.
     * @return the date when the truck needs to be inspected again.
     */
    public LocalDate getDate_of_supervision() {
        return date_of_supervision;
    }

    /**
     * Sets the date when the truck needs to be inspected again.
     * @param date_of_supervision the date when the truck needs to be inspected again.
     */
    public void setDate_of_supervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    /**
     * Gets the license plate number of the truck.
     * @return the license plate number of the truck.
     */
    public String getPlate_number() {
        return plate_number;
    }

    /**
     * Sets the license plate number of the truck.
     * @param plate_number the license plate number of the truck.
     */
    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    /**
     * Gets the chassis number or VIN of the truck.
     * @return the chassis number or VIN of the truck.
     */
    public String getChassis_number() {
        return chassis_number;
    }

    /**
     * Sets the chassis number or VIN of the truck.
     * @param chassis_number the chassis number or VIN of the truck.
     */
    public void setChassis_number(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    /**
     * Gets the fuel normative of the truck.
     * @return the fuel normative of the truck.
     */
    public double getFuel_norm() {
        return fuel_norm;
    }

    /**
     * Sets the fuel normative of the truck.
     * @param fuel_norm the fuel normative of the truck.
     */
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tractor)) return false;

        Tractor tractor = (Tractor) o;

        if (Double.compare(tractor.getFuel_norm(), getFuel_norm()) != 0) return false;
        if (getWeight() != tractor.getWeight()) return false;
        if (getMax_weight() != tractor.getMax_weight()) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(tractor.getManufacturer()) : tractor.getManufacturer() != null)
            return false;
        if (getType() != null ? !getType().equals(tractor.getType()) : tractor.getType() != null) return false;
        if (getDateOfManufacture() != null ? !getDateOfManufacture().equals(tractor.getDateOfManufacture()) : tractor.getDateOfManufacture() != null)
            return false;
        if (getDate_of_acquire() != null ? !getDate_of_acquire().equals(tractor.getDate_of_acquire()) : tractor.getDate_of_acquire() != null)
            return false;
        if (getDate_of_supervision() != null ? !getDate_of_supervision().equals(tractor.getDate_of_supervision()) : tractor.getDate_of_supervision() != null)
            return false;
        if (getPlate_number() != null ? !getPlate_number().equals(tractor.getPlate_number()) : tractor.getPlate_number() != null)
            return false;
        if (getChassis_number() != null ? !getChassis_number().equals(tractor.getChassis_number()) : tractor.getChassis_number() != null)
            return false;
        return getDate_of_sell() != null ? getDate_of_sell().equals(tractor.getDate_of_sell()) : tractor.getDate_of_sell() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getManufacturer() != null ? getManufacturer().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDateOfManufacture() != null ? getDateOfManufacture().hashCode() : 0);
        result = 31 * result + (getDate_of_acquire() != null ? getDate_of_acquire().hashCode() : 0);
        result = 31 * result + (getDate_of_supervision() != null ? getDate_of_supervision().hashCode() : 0);
        result = 31 * result + (getPlate_number() != null ? getPlate_number().hashCode() : 0);
        result = 31 * result + (getChassis_number() != null ? getChassis_number().hashCode() : 0);
        temp = Double.doubleToLongBits(getFuel_norm());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (getWeight() ^ (getWeight() >>> 32));
        result = 31 * result + (int) (getMax_weight() ^ (getMax_weight() >>> 32));
        result = 31 * result + (getDate_of_sell() != null ? getDate_of_sell().hashCode() : 0);
        return result;
    }
}
