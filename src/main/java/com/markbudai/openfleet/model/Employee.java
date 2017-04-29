package com.markbudai.openfleet.model;

import java.time.LocalDate;

/**
 * Created by Mark on 2017. 03. 24..
 */
public class Employee {
    private long id;
            private String firstName;
            private String lastName;
            private LocalDate dateOfBirth;
            private Location placeOfBirth;
            private String socialInsuranceNo;
            private String mothersName;
            private String taxNo;
            private String driversCardNo;
            private Location placeOfLiving;
            private LocalDate employmentDate;
            private LocalDate endOfEmploymentDate;

            public Employee(){}

    public Employee(long id, String firstName, String lastName, LocalDate dateOfBirth, Location placeOfBirth, String socialInsuranceNo, String mothersName, String taxNo, String driversCardNo, Location placeOfLiving, LocalDate employmentDate, LocalDate endOfEmploymentDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.socialInsuranceNo = socialInsuranceNo;
        this.mothersName = mothersName;
        this.taxNo = taxNo;
        this.driversCardNo = driversCardNo;
        this.placeOfLiving = placeOfLiving;
        this.employmentDate = employmentDate;
        this.endOfEmploymentDate = endOfEmploymentDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Location getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(Location placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getSocialInsuranceNo() {
        return socialInsuranceNo;
    }

    public void setSocialInsuranceNo(String socialInsuranceNo) {
        this.socialInsuranceNo = socialInsuranceNo;
    }

    public String getMothersName() {
        return mothersName;
    }

    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    public String getDriversCardNo() {
        return driversCardNo;
    }

    public void setDriversCardNo(String driversCardNo) {
        this.driversCardNo = driversCardNo;
    }

    public Location getPlaceOfLiving() {
        return placeOfLiving;
    }

    public void setPlaceOfLiving(Location placeOfLiving) {
        this.placeOfLiving = placeOfLiving;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public LocalDate getEndOfEmploymentDate() {
        return endOfEmploymentDate;
    }

    public void setEndOfEmploymentDate(LocalDate endOfEmploymentDate) {
        this.endOfEmploymentDate = endOfEmploymentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (getId() != employee.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(employee.getFirstName()) : employee.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(employee.getLastName()) : employee.getLastName() != null)
            return false;
        if (getDateOfBirth() != null ? !getDateOfBirth().equals(employee.getDateOfBirth()) : employee.getDateOfBirth() != null)
            return false;
        if (getPlaceOfBirth() != null ? !getPlaceOfBirth().equals(employee.getPlaceOfBirth()) : employee.getPlaceOfBirth() != null)
            return false;
        if (getSocialInsuranceNo() != null ? !getSocialInsuranceNo().equals(employee.getSocialInsuranceNo()) : employee.getSocialInsuranceNo() != null)
            return false;
        if (getMothersName() != null ? !getMothersName().equals(employee.getMothersName()) : employee.getMothersName() != null)
            return false;
        if (getTaxNo() != null ? !getTaxNo().equals(employee.getTaxNo()) : employee.getTaxNo() != null) return false;
        if (getDriversCardNo() != null ? !getDriversCardNo().equals(employee.getDriversCardNo()) : employee.getDriversCardNo() != null)
            return false;
        if (getPlaceOfLiving() != null ? !getPlaceOfLiving().equals(employee.getPlaceOfLiving()) : employee.getPlaceOfLiving() != null)
            return false;
        if (getEmploymentDate() != null ? !getEmploymentDate().equals(employee.getEmploymentDate()) : employee.getEmploymentDate() != null)
            return false;
        return getEndOfEmploymentDate() != null ? getEndOfEmploymentDate().equals(employee.getEndOfEmploymentDate()) : employee.getEndOfEmploymentDate() == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getDateOfBirth() != null ? getDateOfBirth().hashCode() : 0);
        result = 31 * result + (getPlaceOfBirth() != null ? getPlaceOfBirth().hashCode() : 0);
        result = 31 * result + (getSocialInsuranceNo() != null ? getSocialInsuranceNo().hashCode() : 0);
        result = 31 * result + (getMothersName() != null ? getMothersName().hashCode() : 0);
        result = 31 * result + (getTaxNo() != null ? getTaxNo().hashCode() : 0);
        result = 31 * result + (getDriversCardNo() != null ? getDriversCardNo().hashCode() : 0);
        result = 31 * result + (getPlaceOfLiving() != null ? getPlaceOfLiving().hashCode() : 0);
        result = 31 * result + (getEmploymentDate() != null ? getEmploymentDate().hashCode() : 0);
        result = 31 * result + (getEndOfEmploymentDate() != null ? getEndOfEmploymentDate().hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        return new StringBuilder().append(this.firstName).append(" ").append(this.lastName).toString();
    }
}
