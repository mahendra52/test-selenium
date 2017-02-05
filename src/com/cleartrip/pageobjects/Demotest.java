package com.cleartrip.pageobjects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.cleartrip.constants.Constants;
import com.cleartrip.utilities.ExcelReusables;

public class Demotest {


	
	@Test
	
	public void strtTest() throws FileNotFoundException, IOException {
		 
	
		//	ExcelReusables excel=new ExcelReusables(Constants.flightBookingTestData);
		  XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(Constants.flightBookingTestData));
			String sheetName="flight";
			int rowID=1;
			int cellID=2;
			
			/*String browser=excel.excelReader(sheetName,1,0);
			String url=excel.excelReader("flight",1,1);
			System.out.println(browser+""+url);*/
				  String cellValue="";
				  try{ 
				  /* String sheet1=workbook.getSheetName(0);
				   System.out.println(sheet1);
				   XSSFSheet sheet=workbook.getSheet(sheetName);
				  XSSFRow row=sheet.getRow(1);
				  XSSFCell cell=row.getCell(0)*/;
				   
				   
				   
				   //System.out.println(workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getStringCellValue());
			
					 
				   if(workbook.getSheet(sheetName).
						   getRow(rowID).getCell(cellID)
						   .getCellType()==workbook.getSheet(sheetName)
						   .getRow(rowID).getCell(cellID).CELL_TYPE_NUMERIC){
					/* if(cell.getCellType()==cell.CELL_TYPE_STRING){
						 
						 cellValue=cell.getStringCellValue();}
						 else{
							 cellValue=String.valueOf((int)cell.getNumericCellValue()).trim();*/
		            
				   cellValue=String.valueOf((int)workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getNumericCellValue()).trim(); }
				   
				   else  if(workbook.getSheet(sheetName)
						   .getRow(rowID).getCell(cellID).
						   getCellType()==workbook.getSheet(sheetName).getRow(rowID)
						   .getCell(cellID).CELL_TYPE_STRING){
			    		   
					 cellValue=workbook.getSheet(sheetName).getRow(rowID).getCell(cellID).getStringCellValue().trim();
			    	
				 }
			   } catch(Exception e) {
				   System.out.println(e); 
			   }System.out.println(cellValue);
			   }	   
			   
			/*XSSFWorkbook workbook=new XSSFWorkbook(new FileInputStream(Constants.flightBookingTestData));
			XSSFSheet sheet=workbook.getSheet("flight");
			System.out.println(sheet.getLastRowNum());
			for(int i=0;i<=sheet.getLastRowNum();i++)
			{
				XSSFRow row=sheet.getRow(i);
				System.out.println(row.getLastCellNum());
				for(int j=0;j<row.getLastCellNum();j++)
				{
					System.out.println(row.getLastCellNum());
					XSSFCell cell=row.getCell(j);
					if(cell.getCellType()==cell.CELL_TYPE_STRING)
					{
					System.out.println(i+"hello"+j);
					System.out.println(cell.getStringCellValue());
					}else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)
					{
				 String value=String.valueOf((int)cell.getNumericCellValue()).trim();
					}
					
				}
			}*/
			
			
		/*} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}*/
}
