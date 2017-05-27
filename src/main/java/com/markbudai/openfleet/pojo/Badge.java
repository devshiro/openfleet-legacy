package com.markbudai.openfleet.pojo;

/**
 * Class representing count number for each model objects stored in the database.
 */
public class Badge {
    private long location_count;
    private long employee_count;
    private long tractor_count;
    private long trailer_count;
    private long job_count;

    /**
     * Empty constructor for creating {@link com.markbudai.openfleet.pojo.Badge} object.
     */
    public Badge() {}

    /**
     * Gets the count of {@link com.markbudai.openfleet.model.Location} objects stored in the database.
     * @return the count of {@link com.markbudai.openfleet.model.Location} objects stored in the database.
     */
    public long getLocationCount() {
        return location_count;
    }

    /**
     * Sets the count of {@link com.markbudai.openfleet.model.Location} objects stored in the database.
     * @param location_count the count of {@link com.markbudai.openfleet.model.Location} objects stored in the database.
     */
    public void setLocationCount(long location_count) {
        this.location_count = location_count;
    }

    /**
     * Gets the count of {@link com.markbudai.openfleet.model.Employee} objects stored in the database.
     * @return the count of {@link com.markbudai.openfleet.model.Employee} objects stored in the database.
     */
    public long getEmployeeCount() {
        return employee_count;
    }

    /**
     * Sets the count of {@link com.markbudai.openfleet.model.Employee} objects stored in the database.
     * @param employee_count the count of {@link com.markbudai.openfleet.model.Employee} objects stored in the database.
     */
    public void setEmployeeCount(long employee_count) {
        this.employee_count = employee_count;
    }

    /**
     * Gets the count of {@link com.markbudai.openfleet.model.Tractor} objects stored in the database.
     * @return the count of {@link com.markbudai.openfleet.model.Tractor} objects stored in the database.
     */
    public long getTractorCount() {
        return tractor_count;
    }

    /**
     * Sets the count of {@link com.markbudai.openfleet.model.Tractor} objects stored in the database.
     * @param tractor_count the count of {@link com.markbudai.openfleet.model.Tractor} objects stored in the database.
     */
    public void setTractorCount(long tractor_count) {
        this.tractor_count = tractor_count;
    }

    /**
     * Gets the count of {@link com.markbudai.openfleet.model.Trailer} objects stored in the database.
     * @return the count of {@link com.markbudai.openfleet.model.Trailer} objects stored in the database.
     */
    public long getTrailerCount() {
        return trailer_count;
    }

    /**
     * Sets the count of {@link com.markbudai.openfleet.model.Trailer} objects stored in the database.
     * @param trailer_count the count of {@link com.markbudai.openfleet.model.Trailer} objects stored in the database.
     */
    public void setTrailerCount(long trailer_count) {
        this.trailer_count = trailer_count;
    }

    /**
     * Gets the count of {@link com.markbudai.openfleet.model.Transport} objects stored in the database.
     * @return the count of {@link com.markbudai.openfleet.model.Transport} objects stored in the database.
     */
    public long getJobCount() {
        return job_count;
    }

    /**
     * Sets the count of {@link com.markbudai.openfleet.model.Transport} objects stored in the database.
     * @param job_count the count of {@link com.markbudai.openfleet.model.Transport} objects stored in the database.
     */
    public void setJobCount(long job_count) {
        this.job_count = job_count;
    }
}
