package com.markbudai.openfleet.model;

/**
 * Created by Mark on 2017. 04. 14..
 */
public class Vehicle {
    private long vehicleId;
    private Tractor tractor;
    private Trailer trailer;

    public Vehicle(){}

    public Vehicle(long vehicleId, Tractor tractor, Trailer trailer) {
        this.vehicleId = vehicleId;
        this.tractor = tractor;
        this.trailer = trailer;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public Tractor getTractor() {
        return tractor;
    }

    public void setTractor(Tractor tractor) {
        this.tractor = tractor;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(this.tractor).append(" + ").append(this.trailer).toString();
    }
}
