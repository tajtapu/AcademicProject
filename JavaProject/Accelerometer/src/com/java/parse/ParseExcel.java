package com.java.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ParseExcel {
	public static List<Data> parseExcel(String fileName){
		List<Data> data = new ArrayList<Data>();
		try {
			FileInputStream file = new FileInputStream(new File(fileName));
			
			 //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
 
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                List<String> item = new ArrayList<String>();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    switch(cell.getCellType()){
                    	case Cell.CELL_TYPE_NUMERIC:
                    		item.add(""+cell.getNumericCellValue());
                    		break;
                    	case Cell.CELL_TYPE_STRING:
                    		item.add(cell.getStringCellValue());
                    		break;
                    }
                }
                data.add(new Data(Double.parseDouble(item.get(0)), Double.parseDouble(item.get(1)), Double.parseDouble(item.get(2)),item.get(3)));
            }
            workbook.close();
            file.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
	}

}
