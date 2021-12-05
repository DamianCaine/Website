package com.excel.exceltosql.service;


import com.excel.exceltosql.entity.excelInfo2;
import com.excel.exceltosql.helper.myExcelHelper2;
import com.excel.exceltosql.helper.myexcelHelper;
import com.excel.exceltosql.repository.Repo;
import com.excel.exceltosql.repository.Repo2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class serviceInfo2 {

    @Autowired
    private Repo2 repo;

    public void save(MultipartFile file){
        try {
            List<excelInfo2> excelInfos = myExcelHelper2.convertExcelToList(file.getInputStream());
            this.repo.saveAll(excelInfos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterable<excelInfo2> getAllInfo(){
        return this.repo.findAll();
    }
    public Optional<excelInfo2> getById(String candidateNo){
        return this.repo.findById(candidateNo);
    }
}
