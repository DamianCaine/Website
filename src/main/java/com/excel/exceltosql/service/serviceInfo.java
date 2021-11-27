package com.excel.exceltosql.service;


import com.excel.exceltosql.entity.excelInfo;
import com.excel.exceltosql.helper.myexcelHelper;
import com.excel.exceltosql.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class serviceInfo {

    @Autowired
    private Repo repo;

    public void save(MultipartFile file){
        try {
            List<excelInfo> excelInfos =myexcelHelper.convertExcelToList(file.getInputStream());
            this.repo.saveAll(excelInfos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterable<excelInfo> getAllInfo(){
        return this.repo.findAll();
    }
    public Optional<excelInfo> getById(String empId){
        return this.repo.findById(empId);
    }
}
