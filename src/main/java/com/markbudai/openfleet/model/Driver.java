package com.markbudai.openfleet.model;

/**
 * Created by Mark on 2017. 04. 14..
 */
public class Driver {
    private long driverId;
    private Employee employee;
    private Vehicle vehicle;

    public Driver() {}

    public Driver(long dirverId, Employee employee, Vehicle vehicle) {
        this.driverId = dirverId;
        this.employee = employee;
        this.vehicle = vehicle;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(this.employee.getFirstName()).append(this.employee.getLastName()).toString();
    }
}
