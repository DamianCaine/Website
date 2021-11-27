package com.excel.exceltosql.helper;

import com.excel.exceltosql.entity.excelInfo;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myexcelHelper {

    public static boolean checkExcelFormat(MultipartFile file){

        String content=file.getContentType();

        if(content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            return true;
        else
            return false;
    }

    public static List<excelInfo> convertExcelToList(InputStream is){
        List<excelInfo> list=new ArrayList<>();

        try{

            XSSFWorkbook workbook=new XSSFWorkbook(is);
            XSSFSheet sheet=workbook.getSheet("data");

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
                excelInfo di = new excelInfo();
                while(cells.hasNext()){
                    Cell cell=cells.next();
                    switch(cid){
                        case 0:
                            di.setEmpId(cell.getStringCellValue());
                            break;
                        case 1:
                            di.setName(cell.getStringCellValue());
                            break;
                        case 2:
                            di.setAtc(cell.getStringCellValue());
                            break;
                        case 3:
                            di.setJoiningDate(cell.getStringCellValue());
                            break;
                        case 4:
                            di.setSalary((double)cell.getNumericCellValue());
                            break;
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
