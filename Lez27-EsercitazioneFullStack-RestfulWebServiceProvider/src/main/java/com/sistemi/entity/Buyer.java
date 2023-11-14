package com.sistemi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Buyer implements Serializable {

    @Id
    @Column
    private Integer vatNumber;

    @Column(nullable = false, length = 50)
    private String businessName;

    @Column(nullable = false, length = 50)
    private String cityLocation;

    @Column(nullable = false)
    private Integer employeesNumber;

    public Integer getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(final Integer vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(final String businessName) {
        this.businessName = businessName;
    }

    public String getCityLocation() {
        return cityLocation;
    }

    public void setCityLocation(final String cityLocation) {
        this.cityLocation = cityLocation;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(final Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    protected Buyer() {}

    public Buyer(Integer vatNumber, String businessName, String cityLocation, Integer employeesNumber) {
        this.vatNumber = vatNumber;
        this.businessName = businessName;
        this.cityLocation = cityLocation;
        this.employeesNumber = employeesNumber;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "vatNumber=" + vatNumber +
                ", businessName='" + businessName + '\'' +
                ", cityLocation='" + cityLocation + '\'' +
                ", employeesNumber=" + employeesNumber +
                '}';
    }
}