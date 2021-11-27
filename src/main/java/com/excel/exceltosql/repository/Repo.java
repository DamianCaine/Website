package com.excel.exceltosql.repository;

import com.excel.exceltosql.entity.excelInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface Repo extends CrudRepository<excelInfo,String> {

}
