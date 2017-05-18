package com.markbudai.openfleet.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Class representing an Address.
 */
@Entity
@Table(name = "Location")
public class Location implements Serializable{
    /**
     * Id of the location.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * The country.
     */
    private String country;
    /**
     * The region.
     */
    private String region;
    /**
     * The city.
     */
    private String city;
    /**
     * The street.
     */
    private String street;
    /**
     * The house number.
     */
    @Column(name = "house_number")
    private String houseNo;
    /**
     * The zipcode.
     */
    private String zipcode;

    /**
     * Empty constructor for the location.
     * Used by Hibernate.
     */
    public Location() {}

    /**
     * Constructor for the location.
     * @param id The id of the location object.
     * @param country The country of the Address.
     * @param region The region of the Address.
     * @param city The city of the Address.
     * @param street The street of the Address.
     * @param houseNo The house number of the Address.
     * @param zipcode The zipcode of the Address.
     */
    public Location(long id, String country, String region, String city, String street, String houseNo, String zipcode) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
        this.zipcode = zipcode;
    }

    /**
     * Gets the id   of the Location object.
     * @return the id of the object.
     */
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;

        Location location = (Location) o;

        if (getId() != location.getId()) return false;
        if (getCountry() != null ? !getCountry().equals(location.getCountry()) : location.getCountry() != null)
            return false;
        if (getRegion() != null ? !getRegion().equals(location.getRegion()) : location.getRegion() != null)
            return false;
        if (getCity() != null ? !getCity().equals(location.getCity()) : location.getCity() != null) return false;
        if (getStreet() != null ? !getStreet().equals(location.getStreet()) : location.getStreet() != null)
            return false;
        if (getHouseNo() != null ? !getHouseNo().equals(location.getHouseNo()) : location.getHouseNo() != null)
            return false;
        return getZipcode() != null ? getZipcode().equals(location.getZipcode()) : location.getZipcode() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getCountry() != null ? getCountry().hashCode() : 0);
        result = 31 * result + (getRegion() != null ? getRegion().hashCode() : 0);
        result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
        result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
        result = 31 * result + (getHouseNo() != null ? getHouseNo().hashCode() : 0);
        result = 31 * result + (getZipcode() != null ? getZipcode().hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(this.country).append(", ").append(this.city).toString();
    }

    public String fullString(){
        return new StringBuilder().append(this.country).append(", ").append(this.region).append(" ")
                .append(this.city).append(" ").append(this.street).append(" ")
                .append(this.houseNo).append(", ").append(this.zipcode).toString();
    }
}
