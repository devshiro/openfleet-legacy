package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Class representing a semi-truck pullable trailer.
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

    /**
     * Empty constructor for creating a {@link com.markbudai.openfleet.model.Trailer} object.
     */
    public Trailer() {
    }

    /**
     * Constructor for creating a {@link com.markbudai.openfleet.model.Trailer} object.
     * @param id the {@code id} of the trailer.
     * @param manufacturer the manufacturer of the trailer.
     * @param type the type or model name of the trailer.
     * @param date_of_manufacture the {@link java.time.LocalDate} when the trailer was made.
     * @param date_of_acquire the {@link java.time.LocalDate} when the company acquired the trailer.
     * @param date_of_supervision the {@link java.time.LocalDate} when the trailer needs to be inspected again.
     * @param plate_number the license plate number of the trailer.
     * @param chassis_number the chassis or VIN number of the trailer.
     * @param weight the empty self weight of the trailer.
     * @param max_load_weight the maximum loaded weight of the trailer.
     */
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

    /**
     * Gets the {@code id} of the trailer object.
     * @return the {@code id} of the trailer object.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the {@code id} of the trailer object.
     * @param id the {@code id} of the trailer object.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the manufacturer of the trailer.
     * @return the manufacturer of the trailer.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the trailer.
     * @param manufacturer the manufacturer of the trailer.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the type or model name of the trailer.
     * @return the type or model name of the trailer.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type or model name of the trailer.
     * @param type the type or model name of the trailer.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the trailer was made.
     * @return the {@link java.time.LocalDate} when the trailer was made.
     */
    public LocalDate getDateOfManufacture() {
        return date_of_manufacture;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the trailer was made.
     * @param date_of_manufacture the {@link java.time.LocalDate} when the trailer was made.
     */
    public void setDateOfManufacture(LocalDate date_of_manufacture) {
        this.date_of_manufacture = date_of_manufacture;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the trailer was acquired by the company.
     * @return the {@link java.time.LocalDate} when the trailer was acquired by the company.
     */
    public LocalDate getDateOfAcquire() {
        return date_of_acquire;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the trailer was acquired by the company.
     * @param date_of_acquire the {@link java.time.LocalDate} when the trailer was acquired by the company.
     */
    public void setDateOfAcquire(LocalDate date_of_acquire) {
        this.date_of_acquire = date_of_acquire;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the trailer needs to be inspected again.
     * @return the {@link java.time.LocalDate} when the trailer needs to be inspected again.
     */
    public LocalDate getDateOfSupervision() {
        return date_of_supervision;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the trailer needs to be inspected again.
     * @param date_of_supervision the {@link java.time.LocalDate} when the trailer needs to be inspected again.
     */
    public void setDateOfSupervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    /**
     * Gets the license plate number of the trailer.
     * @return the license plate number of the trailer.
     */
    public String getPlateNumber() {
        return plate_number;
    }

    /**
     * Sets the license plate number of the trailer.
     * @param plate_number the license plate number of the trailer.
     */
    public void setPlateNumber(String plate_number) {
        this.plate_number = plate_number;
    }

    /**
     * Gets the chassis or VIN number of the trailer.
     * @return the chassis or VIN number of the trailer.
     */
    public String getChassisNumber() {
        return chassis_number;
    }

    /**
     * Sets the chassis or VIN number of the trailer.
     * @param chassis_number the chassis or VIN number of the trailer.
     */
    public void setChassisNumber(String chassis_number) {
        this.chassis_number = chassis_number;
    }

    /**
     * Gets the empty self weight of the trailer.
     * @return the empty self weight of the trailer.
     */
    public long getWeight() {
        return weight;
    }

    /**
     * Sets the empty self weight of the trailer.
     * @param weight the empty self weight of the trailer.
     */
    public void setWeight(long weight) {
        this.weight = weight;
    }

    /**
     * Gets the maximum loaded weight of the trailer.
     * @return the maximum loaded weight of the trailer.
     */
    public long getMaxLoadWeight() {
        return max_load_weight;
    }

    /**
     * Sets the maximum loaded weight of the trailer.
     * @param max_load_weight the maximum loaded weight of the trailer.
     */
    public void setMaxLoadWeight(long max_load_weight) {
        this.max_load_weight = max_load_weight;
    }

    /**
     * Gets the {@link java.time.LocalDate} when the trailer was sold.
     * @return the {@link java.time.LocalDate} when the trailer was sold.
     */
    public LocalDate getDateOfSell() {
        return date_of_sell;
    }

    /**
     * Sets the {@link java.time.LocalDate} when the trailer was sold.
     * @param date_of_sell the {@link java.time.LocalDate} when the trailer was sold.
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
