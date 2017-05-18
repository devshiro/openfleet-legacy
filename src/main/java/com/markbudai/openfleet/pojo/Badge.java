package com.markbudai.openfleet.pojo;

/**
 * Created by Mark on 2017. 05. 19..
 */
public class Badge {
    private long location_count;
    private long employee_count;
    private long tractor_count;
    private long trailer_count;
    private long job_count;

    public Badge() {}

    public long getLocation_count() {
        return location_count;
    }

    public void setLocation_count(long location_count) {
        this.location_count = location_count;
    }

    public long getEmployee_count() {
        return employee_count;
    }

    public void setEmployee_count(long employee_count) {
        this.employee_count = employee_count;
    }

    public long getTractor_count() {
        return tractor_count;
    }

    public void setTractor_count(long tractor_count) {
        this.tractor_count = tractor_count;
    }

    public long getTrailer_count() {
        return trailer_count;
    }

    public void setTrailer_count(long trailer_count) {
        this.trailer_count = trailer_count;
    }

    public long getJob_count() {
        return job_count;
    }

    public void setJob_count(long job_count) {
        this.job_count = job_count;
    }
}
