package com.markbudai.openfleet.framework;

import com.markbudai.openfleet.model.Location;

/**
 * Created by Mark on 2017. 03. 24..
 */
public class LocationBuilder {

    private Location loc;

    public LocationBuilder(){
        loc = new Location();
    }

    public LocationBuilder id(long id){
        loc.setId(id);
        return this;
    }

    public LocationBuilder country(String country){
        loc.setCountry(country);
        return this;
    }

    public LocationBuilder city(String city){
        loc.setCity(city);
        return this;
    }

    public LocationBuilder region(String region){
        loc.setRegion(region);
        return this;
    }

    public LocationBuilder street(String street){
        loc.setStreet(street);
        return this;
    }

    public LocationBuilder houseNo(String houseNo){
        loc.setHouseNo(houseNo);
        return this;
    }

    public LocationBuilder zipcode(String zipcode){
        loc.setZipcode(zipcode);
        return this;
    }

    public Location build(){
        return loc;
    }

    public void reset(){
        loc = new Location();
    }
}
