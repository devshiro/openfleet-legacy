package com.markbudai.openfleet.model;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import org.hibernate.annotations.Parameter;

/**
 * A class representing the employees of the company.
 * @author Mark Budai
 */
@Entity
@Table(name = "Employee")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_of_birth")
    private Location placeOfBirth;
    @Column(name = "social_insurance_no")
    private String socialInsuranceNo;
    @Column(name = "mothers_name")
    private String mothersName;
    @Column(name = "tax_no")
    private String taxNo;
    @Column(name = "drivers_card_no")
    private String driversCardNo;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_of_living")
    private Location placeOfLiving;
    @Column(name = "employment_date")
    private LocalDate employmentDate;
    @Column(name = "end_of_employment_date")
    private LocalDate endOfEmploymentDate;

    /**
     * Empty constructor for creating an Employee Object
     */
    public Employee() {
    }

    /**
     * Constructor for creating an Employee Object.
     * @param id the id of the Employee
     * @param firstName the first name of the Employee
     * @param lastName the last name of the employee
     * @param dateOfBirth the birthdate of the employee
     * @param placeOfBirth the birthplace of the employee
     * @param socialInsuranceNo the social insurance number of the employee
     * @param mothersName the full name of the employee's mother
     * @param taxNo the tax number of the employee
     * @param driversCardNo the driver's card number of the employee
     * @param placeOfLiving the post address of the employee
     * @param employmentDate the start date of employment for the employee
     * @param endOfEmploymentDate the end date of employment for the employee
     */
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

    /**
     * Gets the id of the employee
     * @return the id of the employee
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the id of the employee
     * @param id the id of the employee
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Gets the first name of the employee
     * @return the first name of the employee
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the employee
     * @param firstName the first name of the employee
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name of the employee
     * @return the last name of the employee
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the employee
     * @param lastName the last name of the employee
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the birthdate of the employee
     * @return the birthdate of the employee
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Sets the birthdate of the employee
     * @param dateOfBirth the birthdate of the employee
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the birthplace of the employee
     * @return the birthplace of the employee
     */
    public Location getPlaceOfBirth() {
        return placeOfBirth;
    }

    /**
     * Sets the birthplace of the employee
     * @param placeOfBirth the birthplace of the employee
     */
    public void setPlaceOfBirth(Location placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    /**
     * Gets the social insurance number of the employee
     * @return the social insurance number of the employee
     */
    public String getSocialInsuranceNo() {
        return socialInsuranceNo;
    }

    /**
     * Sets the social insurance number of the employee
     * @param socialInsuranceNo the social insurance number of the employee
     */
    public void setSocialInsuranceNo(String socialInsuranceNo) {
        this.socialInsuranceNo = socialInsuranceNo;
    }

    /**
     * Gets the employee's mother's full name
     * @return the employee's mother's full name
     */
    public String getMothersName() {
        return mothersName;
    }

    /**
     * Sets the employee's mother's full name
     * @param mothersName the employee's mother's full name
     */
    public void setMothersName(String mothersName) {
        this.mothersName = mothersName;
    }

    /**
     * Gets the tax number of the employee
     * @return the tax number of the employee
     */
    public String getTaxNo() {
        return taxNo;
    }

    /**
     * Sets the tax number of the employee
     * @param taxNo the tax number of the employee
     */
    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo;
    }

    /**
     * Gets the driver's card number of the employee
     * @return the driver's card number of the employee
     */
    public String getDriversCardNo() {
        return driversCardNo;
    }

    /**
     * Sets the driver's card number of the employee
     * @param driversCardNo the driver's card number of the employee
     */
    public void setDriversCardNo(String driversCardNo) {
        this.driversCardNo = driversCardNo;
    }

    /**
     * Gets the address of the employee
     * @return the address of the employee
     */
    public Location getPlaceOfLiving() {
        return placeOfLiving;
    }

    /**
     * Sets the address of the employee
     * @param placeOfLiving the address of the employee
     */
    public void setPlaceOfLiving(Location placeOfLiving) {
        this.placeOfLiving = placeOfLiving;
    }

    /**
     * Gets the employment date of the employee
     * @return the employment date of the employee
     */
    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    /**
     * Sets the employment date of the employee
     * @param employmentDate the employment date of the employee
     */
    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    /**
     * Gets the end of employment date of the employee
     * @return the end of employment date of the employee
     */
    public LocalDate getEndOfEmploymentDate() {
        return endOfEmploymentDate;
    }

    /**
     * Sets the end of employment date of the employee
     * @param endOfEmploymentDate the end of employment date of the employee
     */
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
    public String toString() {
        return new StringBuilder().append(this.firstName).append(" ").append(this.lastName).toString();
    }
}
