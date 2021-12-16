package com.excel.exceltosql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class excelInfo3 {

    @Id
    private String custNo;
    private String custName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private Double creditLimit;
    private String taxId;
    private String salesRep;

    public excelInfo3() {
    }

    public excelInfo3(String custNo, String custName, String streetAddress, String city, String state, String zipCode, Double creditLimit, String taxId, String salesRep) {
        this.custNo = custNo;
        this.custName = custName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.creditLimit = creditLimit;
        this.taxId = taxId;
        this.salesRep = salesRep;
    }

    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Double creditLimit) {
        this.creditLimit = creditLimit;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public String getSalesRep() {
        return salesRep;
    }

    public void setSalesRep(String salesRep) {
        this.salesRep = salesRep;
    }
}
