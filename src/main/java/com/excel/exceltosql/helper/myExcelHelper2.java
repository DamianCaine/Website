package com.excel.exceltosql.helper;

import com.excel.exceltosql.entity.excelInfo;
import com.excel.exceltosql.entity.excelInfo2;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myExcelHelper2 {

    public static boolean checkExcelFormat(MultipartFile file){

        String content=file.getContentType();

        if(content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            return true;
        else
            return false;
    }

    public static List<excelInfo2> convertExcelToList(InputStream is){
        List<excelInfo2> list=new ArrayList<>();

        try{

            XSSFWorkbook workbook=new XSSFWorkbook(is);
            XSSFSheet sheet=workbook.getSheet("data2");

            int rowNo=0;
            Iterator<Row> it = sheet.iterator();

            while(it.hasNext()){
                Row row=it.next();
                if(rowNo==0){
                    rowNo++;
                    continue;
                }
                Iterator<Cell> cells=row.iterator();
                int cid=0;
                excelInfo2 di = new excelInfo2();
                while(cells.hasNext()){
                    Cell cell=cells.next();
                    switch(cid){
                        case 0:
                            di.setSrNo((int) cell.getNumericCellValue());
                            break;
                        case 1:
                            di.setCandidateNo(cell.getStringCellValue());
                            break;
                        case 2:
                            di.setName(cell.getStringCellValue());
                            break;
                        case 3:
                            di.setBranch(cell.getStringCellValue());
                            break;
                        case 4:
                            di.setDate(cell.getStringCellValue());
                            break;
                        case 5:
                            di.setTechRoom(cell.getStringCellValue());
                            break;
                        case 6:
                            di.setRegNo(cell.getStringCellValue());
                        default:
                            break;
                    }
                    cid++;
                }

                list.add(di);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
