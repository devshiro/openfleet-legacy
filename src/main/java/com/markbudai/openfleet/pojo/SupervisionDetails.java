package com.markbudai.openfleet.pojo;

import java.time.LocalDate;

/**
 * Class representing details about the supervision state of the vehicles.
 */
public class SupervisionDetails {
    private String plate_number;
    private String manufacturer;
    private String type;
    private LocalDate date_of_supervision;
    private long days_remaining;

    /**
     * Empty constructor for creating a {@link com.markbudai.openfleet.pojo.SupervisionDetails} object.
     */
    public SupervisionDetails(){}

    /**
     * Constructor for creating a {@link com.markbudai.openfleet.pojo.SupervisionDetails} object.
     * @param plate_no the license plate number of the vehicle.
     * @param manufacturer the manufacturer of the vehicle.
     * @param type the type or model name of the vehicle.
     * @param date_of_supervision the {@link java.time.LocalDate} when the vehicle will lose it's license to be used in road transport.
     * @param days_remaining the remaining days while the vehicle can be used without sending it to mechanical supervision.
     */
    public SupervisionDetails(String plate_no, String manufacturer, String type, LocalDate date_of_supervision, long days_remaining) {
        this.plate_number = plate_no;
        this.manufacturer = manufacturer;
        this.type = type;
        this.date_of_supervision = date_of_supervision;
        this.days_remaining = days_remaining;
    }

    /**
     * Gets the license plate number of the vehicle.
     * @return the license plate number of the vehicle.
     */
    public String getPlateNumber() {
        return plate_number;
    }

    /**
     * Sets the license plate number of the vehicle.
     * @param plate_no the license plate number of the vehicle.
     */
    public void setPlateNo(String plate_no) {
        this.plate_number = plate_no;
    }

    /**
     * Gets the manufacturer of the vehicle.
     * @return the manufacturer of the vehicle.
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * Sets the manufacturer of the vehicle.
     * @param manufacturer the manufacturer of the vehicle.
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    /**
     * Gets the type or model name of the vehicle.
     * @return the type or model name of the vehicle.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type or model name of the vehicle.
     * @param type the type or model name of the vehicle.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the {@link java.time.LocalDate} of the mechanical supervision.
     * <p>This date is the last date before the vehicle will lose it's license to be used in road transport.
     * The mechanical supervision must be done before or at this date.</p>
     * @return the {@link java.time.LocalDate} of the mechanical supervision.
     */
    public LocalDate getDateOfSupervision() {
        return date_of_supervision;
    }

    /**
     * Sets the {@link java.time.LocalDate} of the next mechanical supervision.
     * @param date_of_supervision the {@link java.time.LocalDate} of the next mechanical supervision.
     */
    public void setDateOfSupervision(LocalDate date_of_supervision) {
        this.date_of_supervision = date_of_supervision;
    }

    /**
     * Gets the remaining days before the next mechanical supervision.
     * @return the remaining days before the next mechanical supervision.
     */
    public long getDaysRemaining() {
        return days_remaining;
    }

    /**
     * Sets the remaining days before the next mechanical supervision.
     * @param days_remaining the remaining days before the next mechanical supervision.
     */
    public void setDaysRemaining(long days_remaining) {
        this.days_remaining = days_remaining;
    }
}
