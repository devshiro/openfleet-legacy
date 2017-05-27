package com.markbudai.openfleet.pojo;

/**
 * Class for packaging
 */
public class Badge {
    private long location_count;
    private long employee_count;
    private long tractor_count;
    private long trailer_count;
    private long job_count;

    public Badge() {}

    public long getLocationCount() {
        return location_count;
    }

    public void setLocationCount(long location_count) {
        this.location_count = location_count;
    }

    public long getEmployeeCount() {
        return employee_count;
    }

    public void setEmployeeCount(long employee_count) {
        this.employee_count = employee_count;
    }

    public long getTractorCount() {
        return tractor_count;
    }

    public void setTractorCount(long tractor_count) {
        this.tractor_count = tractor_count;
    }

    public long getTrailerCount() {
        return trailer_count;
    }

    public void setTrailerCount(long trailer_count) {
        this.trailer_count = trailer_count;
    }

    public long getJobCount() {
        return job_count;
    }

    public void setJobCount(long job_count) {
        this.job_count = job_count;
    }
}
