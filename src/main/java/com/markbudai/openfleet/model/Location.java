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
     * Gets the id of the Location object.
     * @return the id of the location object.
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of the Location object.
     * @param id the id of the location object.
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the Country of the address.
     * @return the Country of the address.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the Country of the address.
     * @param country the country of the address.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets the region of the address.
     * @return the region of the address.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets the region of the address.
     * @param region the region of the address
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets the city of the address.
     * @return the city of the address.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the city of the address.
     * @param city the city of the address.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the street name of the address.
     * @return the street name of the address.
     */
    public String getStreet() {
        return street;
    }

    /**
     * Sets the street name of the address.
     * @param street the street name of the address.
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Gets the house number of the address.
     * @return the house number of the address.
     */
    public String getHouseNo() {
        return houseNo;
    }

    /**
     * Sets the house number of the address.
     * @param houseNo the house number of the address.
     */
    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    /**
     * Gets the zipcode of the address.
     * @return the zipcode of the address.
     */
    public String getZipcode() {
        return zipcode;
    }

    /**
     * Sets the zipcode of the address.
     * @param zipcode the zipcode of the address.
     */
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

    /**
     * Gets a complete text representation of the address.
     * @return the complete text representation of the address.
     */
    public String fullString(){
        return new StringBuilder().append(this.country).append(", ").append(this.region).append(" ")
                .append(this.city).append(" ").append(this.street).append(" ")
                .append(this.houseNo).append(", ").append(this.zipcode).toString();
    }
}
