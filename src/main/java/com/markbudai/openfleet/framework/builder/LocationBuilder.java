package com.markbudai.openfleet.framework.builder;

import com.markbudai.openfleet.exception.EmptyParameterException;
import com.markbudai.openfleet.model.Location;
import org.springframework.web.context.request.WebRequest;

/**
 * Class for building {@link com.markbudai.openfleet.model.Location} objects with Fluent API.
 * Also provides static method to map {@link org.springframework.web.context.request.WebRequest} to {@link com.markbudai.openfleet.model.Location}.
 */
public class LocationBuilder {

    private Location loc;

    /**
     * Empty constructor to start building a new {@link com.markbudai.openfleet.model.Location} object with Fluent API.
     */
    public LocationBuilder(){
        loc = new Location();
    }

    /**
     * Sets the id of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param id the id of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder id(long id){
        loc.setId(id);
        return this;
    }

    /**
     * Sets the country of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param country the country of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder country(String country){
        loc.setCountry(country);
        return this;
    }

    /**
     * Sets the city of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param city the city of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder city(String city){
        loc.setCity(city);
        return this;
    }

    /**
     * Sets the region of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param region the region of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder region(String region){
        loc.setRegion(region);
        return this;
    }

    /**
     * Sets the street of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param street the street of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder street(String street){
        loc.setStreet(street);
        return this;
    }

    /**
     * Sets the houseNo of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param houseNo the houseNo of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder houseNo(String houseNo){
        loc.setHouseNo(houseNo);
        return this;
    }

    /**
     * Sets the zipcode of the built {@link com.markbudai.openfleet.model.Location} object.
     * @param zipcode the zipcode of the built {@link com.markbudai.openfleet.model.Location} object.
     * @return a reference to this {@link com.markbudai.openfleet.framework.builder.LocationBuilder}.
     */
    public LocationBuilder zipcode(String zipcode){
        loc.setZipcode(zipcode);
        return this;
    }

    /**
     * Returns the built {@link com.markbudai.openfleet.model.Location} object.
     * @return the built {@link com.markbudai.openfleet.model.Location} object.
     */
    public Location build(){
        return loc;
    }

    /**
     * Clears the internal {@link com.markbudai.openfleet.model.Location} object to be ready for a new build process.
     */
    public void reset(){
        loc = new Location();
    }

    /**
     * Takes the parameters from the {@link org.springframework.web.context.request.WebRequest} and parses into the new {@link com.markbudai.openfleet.model.Location} object by its setter methods.
     * @param request the {@link org.springframework.web.context.request.WebRequest} containing parameters for the new {@link com.markbudai.openfleet.model.Location} object.
     * @return the parsed  {@link com.markbudai.openfleet.model.Location} object.
     * @exception com.markbudai.openfleet.exception.EmptyParameterException if any parameter is empty.
     */
    public static Location buildFromWebRequest(WebRequest request){
        Location loc = new Location();
        if(!(request.getParameter("id").isEmpty())){
            loc.setId(Long.parseLong(request.getParameter("id")));
        }
        if(request.getParameter("country").isEmpty()){
            throw new EmptyParameterException("country");
        }
        loc.setCountry(request.getParameter("country"));
        if(request.getParameter("city").isEmpty()){
            throw new EmptyParameterException("city");
        }
        loc.setCity(request.getParameter("city"));
        if(request.getParameter("region").isEmpty()){
            throw new EmptyParameterException("region");
        }
        loc.setRegion(request.getParameter("region"));
        if(request.getParameter("street").isEmpty()){
            throw new EmptyParameterException("street");
        }
        loc.setStreet(request.getParameter("street"));
        if(request.getParameter("houseNo").isEmpty()){
            throw new EmptyParameterException("houseNo");
        }
        loc.setHouseNo(request.getParameter("houseNo"));
        if(request.getParameter("zipcode").isEmpty()){
            throw new EmptyParameterException("zipcode");
        }
        loc.setZipcode(request.getParameter("zipcode"));
        return loc;
    }
}
