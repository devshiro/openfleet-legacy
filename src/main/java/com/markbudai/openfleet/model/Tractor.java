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
     * Empty constructor for creating {@link com.markbudai.openfleet.model.Tractor} objects.
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
     * Gets the {@code id} of the truck object.
     * @return the {@code id} the truck object.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the {@code id} of the truck object.
     * @param id the {@code id} of the truck object.
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
     * Gets the {@link java.time.LocalDate} when the truck was manufactured.
     * @return the {@link java.time.LocalDate} when the truck was manufactured.
     */
    public LocalDate getDateOfManufacture() {
        return date_of_manufacture;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the truck was manufactured.
     * @param date_of_manufacture the {@link java.time.LocalDate} when the truck was manufactured.
     */
    public void setDateOfManufacture(LocalDate date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the company acquired the truck.
     * @return the {@link java.time.LocalDate} when the company acquired the truck.
     */
    public LocalDate getDateOfAcquire() {
        return date_of_acquire;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the company acquired the truck.
     * @param date_of_acquire the {@link java.time.LocalDate} when the company acquired the truck.
     */
    public void setDateOfAcquire(LocalDate date_of_acquire) {
        this.date_of_acquire = date_of_acquire;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the truck needs to be inspected again.
     * @return the {@link java.time.LocalDate} when the truck needs to be inspected again.
     */
    public LocalDate getDateOfSupervision() {
        return date_of_supervision;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the truck needs to be inspected again.
     * @param date_of_supervision the {@link java.time.LocalDate} when the truck needs to be inspected again.
     */
    public void setDateOfSupervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    /**
     * Gets the license plate number of the truck.
     * @return the license plate number of the truck.
     */
    public String getPlateNumber() {
        return plate_number;
    }

    /**
     * Sets the license plate number of the truck.
     * @param plate_number the license plate number of the truck.
     */
    public void setPlateNumber(String plate_number) {
        this.plate_number = plate_number;
    }

    /**
     * Gets the chassis number or VIN of the truck.
     * @return the chassis number or VIN of the truck.
     */
    public String getChassisNumber() {
        return chassis_number;
    }

    /**
     * Sets the chassis number or VIN of the truck.
     * @param chassis_number the chassis number or VIN of the truck.
     */
    public void setChassisNumber(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    /**
     * Gets the fuel normative of the truck.
     * @return the fuel normative of the truck.
     */
    public double getFuelNorm() {
        return fuel_norm;
    }

    /**
     * Sets the fuel normative of the truck.
     * @param fuel_norm the fuel normative of the truck.
     */
    public void setFuelNorm(double fuel_norm) {
        this.fuel_norm = fuel_norm;
    }

    /**
     * Gets the empty weight of the truck.
     * @return the empty weight of the truck.
     */
    public long getWeight() {
        return weight;
    }

    /**
     * Sets the empty weight of the truck.
     * @param weight the empty weight of the truck.
     */
    public void setWeight(long weight) {
        this.weight = weight;
    }

    /**
     * Gets the maximum loaded weight of the truck.
     * @return the maximum loaded weight of the truck.
     */
    public long getMaxWeight() {
        return max_weight;
    }

    /**
     * Sets the maximum loaded weight of the truck.
     * @param max_weight the maximum loaded weight of the truck.
     */
    public void setMaxWeight(long max_weight) {
        this.max_weight = max_weight;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the truck was sold.
     * @return the {@link java.time.LocalDate} when the truck was sold.
     */
    public LocalDate getDateOfSell() {
        return date_of_sell;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the truck was sold.
     * @param date_of_sell the {@link java.time.LocalDate} when the truck was sold.
     */
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
        if (!(o instanceof Tractor)) return false;

        Tractor tractor = (Tractor) o;

        if (Double.compare(tractor.getFuelNorm(), getFuelNorm()) != 0) return false;
        if (getWeight() != tractor.getWeight()) return false;
        if (getMaxWeight() != tractor.getMaxWeight()) return false;
        if (getManufacturer() != null ? !getManufacturer().equals(tractor.getManufacturer()) : tractor.getManufacturer() != null)
            return false;
        if (getType() != null ? !getType().equals(tractor.getType()) : tractor.getType() != null) return false;
        if (getDateOfManufacture() != null ? !getDateOfManufacture().equals(tractor.getDateOfManufacture()) : tractor.getDateOfManufacture() != null)
            return false;
        if (getDateOfAcquire() != null ? !getDateOfAcquire().equals(tractor.getDateOfAcquire()) : tractor.getDateOfAcquire() != null)
            return false;
        if (getDateOfSupervision() != null ? !getDateOfSupervision().equals(tractor.getDateOfSupervision()) : tractor.getDateOfSupervision() != null)
            return false;
        if (getPlateNumber() != null ? !getPlateNumber().equals(tractor.getPlateNumber()) : tractor.getPlateNumber() != null)
            return false;
        if (getChassisNumber() != null ? !getChassisNumber().equals(tractor.getChassisNumber()) : tractor.getChassisNumber() != null)
            return false;
        return getDateOfSell() != null ? getDateOfSell().equals(tractor.getDateOfSell()) : tractor.getDateOfSell() == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getManufacturer() != null ? getManufacturer().hashCode() : 0;
        result = 31 * result + (getType() != null ? getType().hashCode() : 0);
        result = 31 * result + (getDateOfManufacture() != null ? getDateOfManufacture().hashCode() : 0);
        result = 31 * result + (getDateOfAcquire() != null ? getDateOfAcquire().hashCode() : 0);
        result = 31 * result + (getDateOfSupervision() != null ? getDateOfSupervision().hashCode() : 0);
        result = 31 * result + (getPlateNumber() != null ? getPlateNumber().hashCode() : 0);
        result = 31 * result + (getChassisNumber() != null ? getChassisNumber().hashCode() : 0);
        temp = Double.doubleToLongBits(getFuelNorm());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (int) (getWeight() ^ (getWeight() >>> 32));
        result = 31 * result + (int) (getMaxWeight() ^ (getMaxWeight() >>> 32));
        result = 31 * result + (getDateOfSell() != null ? getDateOfSell().hashCode() : 0);
        return result;
    }
}
