package com.apache.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;


public class Task13 {

	public static void main(String[] args) {
        // Create a new XLSX workbook
		
		try
		{
        XSSFWorkbook workbook = new XSSFWorkbook ("C:\\Users\\DELL\\eclipse-workspace\\tasksrepo\\src\\test\\resources\\Task13.xlsx");
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow firstRow = sheet.getRow(0);
        XSSFCell firstCell= firstRow.getCell(0);
        
       
        XSSFCell fourthCell = firstRow.createCell(4);
        fourthCell.setCellValue("ID");
        
        
        ///For Reading data in Excel

        
        DataFormatter dataFormatter = new DataFormatter();
        
        for (Row rowAll : sheet) {
            for (Cell cellAll : rowAll) {
                String cellValue = dataFormatter.formatCellValue(cellAll);

                System.out.print(cellValue + "\t");
            }
            System.out.println();
        }
        
        ///For Write data in Excel
        
        /*XSSFRow SixthRow = sheet.getRow(5);
        XSSFCell sixthRowFirstCell = SixthRow.getCell(0);
        sixthRowFirstCell.setCellValue("22");*/
      
		}
		
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
    }
	
	
	
	
	
	///For Write data in Excel
	public void writedata() {
		XSSFWorkbook book1= new XSSFWorkbook();
		XSSFSheet sheet2 = book1.createSheet("second sheet");
		
		Object [][] data = {
				{"Name","Age","Email ID"},
				{"John Doe","30","John@test.com"},
				{"Jane Doe","28","john@test.com"},
				{"Bob Smith","35","jacky@example.com"},
				{"Swapnil","37","joe@example.com"}
		};
		
		int rowCount =0;
		for(Object[] row1 :data) {
			XSSFRow row = sheet2.createRow(rowCount++);
			
			int columnCount =0;
			
			for(Object col: row1) {
				XSSFCell cell =row.createCell(columnCount++);
				if(col instanceof String) {
					cell.setCellValue((String)col);
				}
				else if (col instanceof Integer) {
					cell.setCellValue((Integer)col);
				}
					
					
					
					
					
				}
			}
		}
				
		}
				
	

	
		


	
