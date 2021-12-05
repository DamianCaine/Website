package com.excel.exceltosql.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class excelInfo2 {

    private Integer srNo;
    @Id
    private String candidateNo;
    private String name;
    private String branch;
    private String date;
    private String techRoom;
    private String regNo;

    public excelInfo2() {
    }

    public excelInfo2(Integer srNo, String candidateNo, String name, String branch, String date, String techRoom, String regNo) {
        this.srNo = srNo;
        this.candidateNo = candidateNo;
        this.name = name;
        this.branch = branch;
        this.date = date;
        this.techRoom = techRoom;
        this.regNo = regNo;
    }

    public Integer getSrNo() {
        return srNo;
    }

    public void setSrNo(Integer srNo) {
        this.srNo = srNo;
    }

    public String getCandidateNo() {
        return candidateNo;
    }

    public void setCandidateNo(String candidateNo) {
        this.candidateNo = candidateNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTechRoom() {
        return techRoom;
    }

    public void setTechRoom(String techRoom) {
        this.techRoom = techRoom;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }
}
