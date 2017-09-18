package com.java.parse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelWrite {
	public static void writeToExcel(List<Data> data, String fileName) {
		
		//Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Accelerometer Data");
        int rowNum = 0;
        for(Data d:data) {
        	Row row = sheet.createRow(rowNum++);
        	Cell firstCell = row.createCell(0);
        	firstCell.setCellValue(d.getX());
        	Cell secondCell = row.createCell(1);
        	secondCell.setCellValue(d.getY());
        	Cell thirdCell = row.createCell(2);
        	thirdCell.setCellValue(d.getZ());
        	Cell fourthCell = row.createCell(3);
        	fourthCell.setCellValue(d.getDateString());
        }
        try{
        	FileOutputStream outputExcel = new FileOutputStream(new File(fileName));
        	workbook.write(outputExcel);
        	outputExcel.close();
        	workbook.close();
        }
        catch(IOException e){
        	e.printStackTrace();
        }
	}
}
