package com.excel.exceltosql.service;

import com.excel.exceltosql.entity.excelInfo2;
import com.excel.exceltosql.entity.excelInfo3;
import com.excel.exceltosql.helper.myExcelHelper2;
import com.excel.exceltosql.helper.myExcelHelper3;
import com.excel.exceltosql.repository.Repo2;
import com.excel.exceltosql.repository.Repo3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class serviceInfo3 {
    @Autowired
    private Repo3 repo;

    public void save(MultipartFile file){
        try {
            List<excelInfo3> excelInfos = myExcelHelper3.convertExcelToList(file.getInputStream());
            this.repo.saveAll(excelInfos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Iterable<excelInfo3> getAllInfo(){
        return this.repo.findAll();
    }
    public Optional<excelInfo3> getById(String candidateNo){
        return this.repo.findById(candidateNo);
    }
}
