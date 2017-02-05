package com.cleartrip.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReusables {
	
	   XSSFWorkbook workbook;
	   String excelFilePath;
	   public ExcelReusables(String excelFilePath) throws IOException {
		   this.excelFilePath=excelFilePath;    
		   String fileType=excelFilePath.substring(excelFilePath.indexOf('.')); 
		   if(fileType.contains(".xls")){			   
		   HSSFWorkbook hssfworkbook=new HSSFWorkbook(new FileInputStream(excelFilePath));
		   }
		   else 
		    workbook=new XSSFWorkbook(new FileInputStream(excelFilePath)); 
		   }
	
	   public String excelReader(String sheetName,int rowID,int cellID){
		   String cellValue="";
		 try{ 
			 
		   if(workbook.getSheet(sheetName).
				   getRow(rowID).getCell(cellID)
				   .getCellType()==workbook.getSheet(sheetName)
				   .getRow(rowID).getCell(cellID).CELL_TYPE_NUMERIC){
				 
		   cellValue=String.valueOf((int)workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getNumericCellValue()).trim(); }
		   
		   else  if(workbook.getSheet(sheetName)
				   .getRow(rowID).getCell(cellID).
				   getCellType()==workbook.getSheet(sheetName).getRow(rowID)
				   .getCell(cellID).CELL_TYPE_STRING){
	    		   
			 cellValue=workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getStringCellValue().trim();
	   
		 }else
		   if(HSSFDateUtil.isCellDateFormatted(workbook.getSheet(sheetName).getRow(rowID).getCell(cellID))){
			   DateFormat df=new SimpleDateFormat("dd/MM/yy");
			   Date date= workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getDateCellValue();
			   cellValue=df.format(date); }
		   
		  // else return workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getBooleanCellValue();
			   

		   
	   } catch(Exception e) {
		   return cellValue;
	   }return cellValue;
	   }	   
	   
	   public void setStringCellValue(String sheetName,int rowID,int cellID,String cellValue) throws FileNotFoundException, IOException{
		   
		   workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).setCellValue(cellValue);
		   workbook.write(new FileOutputStream(new File(excelFilePath))) ;
			   
		   }
	   
       public void setNumericCellValue(String sheetName,int rowID,int cellID,int cellValue) throws FileNotFoundException, IOException{
		   
		   workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).setCellValue(cellValue);
		   workbook.write(new FileOutputStream(new File(excelFilePath))) ;
			   
		   }
       
       public int getRowCount(String sheetName)
       {
    	   int rowCount=workbook.getSheet(sheetName).getLastRowNum()+1;
    	   return rowCount;
       }
	   
}
	   


