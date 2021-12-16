package com.excel.exceltosql.controller;

import com.excel.exceltosql.entity.excelInfo;
import com.excel.exceltosql.entity.excelInfo2;
import com.excel.exceltosql.entity.excelInfo3;
import com.excel.exceltosql.helper.myExcelHelper2;
import com.excel.exceltosql.helper.myExcelHelper3;
import com.excel.exceltosql.helper.myexcelHelper;
import com.excel.exceltosql.service.serviceInfo;
import com.excel.exceltosql.service.serviceInfo2;
import com.excel.exceltosql.service.serviceInfo3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@RestController
@CrossOrigin("*")
public class Controller {

    @Autowired
    private serviceInfo servicedrive;
    @Autowired
    private serviceInfo2 servicecandidate;
    @Autowired
    private serviceInfo3 servicecustomer;

    @PostMapping("/driver-info/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws InterruptedException {
        Thread.sleep(5000);
        if(myexcelHelper.checkExcelFormat(file)){

            this.servicedrive.save(file);

            return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to DB"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLease upload excel file only");
    }

    @PostMapping("/candidate-info/upload")
    public ResponseEntity<?> upload2(@RequestParam("file")MultipartFile file) throws InterruptedException {
        Thread.sleep(5000);
        if(myExcelHelper2.checkExcelFormat(file)){

            this.servicecandidate.save(file);

            return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to DB"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLease upload excel file only");
    }

    @PostMapping("/customer-info/upload")
    public ResponseEntity<?> upload3(@RequestParam("file")MultipartFile file) throws InterruptedException {
        Thread.sleep(5000);
        if(myExcelHelper3.checkExcelFormat(file)){

            this.servicecustomer.save(file);

            return ResponseEntity.ok(Map.of("message","File is uploaded and data is saved to DB"));

        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("PLease upload excel file only");
    }

    @GetMapping("/driver-info")
    public Iterable<excelInfo> getAllInfo(){
        return this.servicedrive.getAllInfo();
    }

    @GetMapping("/cust-info")
    public Iterable<excelInfo3> getAllInfo3(){
        return this.servicecustomer.getAllInfo();
    }

    @GetMapping("/driver-info-byid/{empId}")
    public Optional<excelInfo> getEmpInfo(@PathVariable(name="empId") String empId){
        return this.servicedrive.getById(empId);
    }

    @GetMapping("/cust-info-byid/{custId}")
    public Optional<excelInfo3> getCustInfo(@PathVariable(name="custId") String custNo){
        return this.servicecustomer.getById(custNo);
    }

    @GetMapping("/candidate-info")
    public Iterable<excelInfo2> getAllInfo2(){
        return this.servicecandidate.getAllInfo();
    }

    @GetMapping("/candidate-info-byid/{candidateNo}")
    public Optional<excelInfo2> getCandidateInfo(@PathVariable(name="candidateNo") String candidateNo){
        return this.servicecandidate.getById(candidateNo);
    }
}
