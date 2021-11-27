package com.excel.exceltosql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class excelInfo {

    private String joiningDate;
    private Double salary;
    private String atc;
    @Id
    private String empId;
    private String name;

    public excelInfo(String joiningDate, Double salary, String atc, String empId, String name) {
        this.joiningDate = joiningDate;
        this.salary = salary;
        this.atc = atc;
        this.empId = empId;
        this.name = name;
    }

    public excelInfo() {
    }

    public String getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getAtc() {
        return atc;
    }

    public void setAtc(String atc) {
        this.atc = atc;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
