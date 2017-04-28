package com.markbudai.openfleet.model;

/**
 * Representation of Address
 */
public class Location {
    private long id;
    private String country;
    private String region;
    private String city;
    private String street;
    private String houseNo;
    private String zipcode;

    /**
     * Constructor of Location
     */
    public Location() {}

    public Location(long id, String country, String region, String city, String street, String houseNo, String zipcode) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.houseNo = houseNo;
        this.zipcode = zipcode;
    }

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
}
