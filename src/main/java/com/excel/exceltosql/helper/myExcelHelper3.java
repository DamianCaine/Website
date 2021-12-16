package com.excel.exceltosql.helper;

import com.excel.exceltosql.entity.excelInfo2;
import com.excel.exceltosql.entity.excelInfo3;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class myExcelHelper3 {
    public static boolean checkExcelFormat(MultipartFile file){

        String content=file.getContentType();

        if(content.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
            return true;
        else
            return false;
    }

    public static List<excelInfo3> convertExcelToList(InputStream is){
        List<excelInfo3> list=new ArrayList<>();

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
                excelInfo3 di = new excelInfo3();
                while(cells.hasNext()){
                    Cell cell=cells.next();
                    switch(cid){
                        case 0:
                            di.setCustNo(cell.getStringCellValue());
                            break;
                        case 1:
                            di.setCustName(cell.getStringCellValue());
                            break;
                        case 2:
                            di.setStreetAddress(cell.getStringCellValue());
                            break;
                        case 3:
                            di.setCity(cell.getStringCellValue());
                            break;
                        case 4:
                            di.setState(cell.getStringCellValue());
                            break;
                        case 5:
                            di.setZipCode(cell.getStringCellValue());
                            break;
                        case 6:
                            di.setCreditLimit(cell.getNumericCellValue());
                            break;
                        case 7:
                            di.setTaxId(cell.getStringCellValue());
                            break;
                        case 8:
                            di.setSalesRep(cell.getStringCellValue());
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
