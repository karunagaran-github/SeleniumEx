package com.apache.excel;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;


public class Task13 {

	public static void main(String[] args) {
        // Create a new XLSX workbook
        Workbook workbook = new XSSFWorkbook();
        
        // Create a new sheet named "DataSheet"
        Sheet sheet = workbook.createSheet("DataSheet");
        
        try {
            // Write data to 5 rows and 5 columns
            for (int row = 0; row < 5; row++) {
                Row currentRow = sheet.createRow(row);
                for (int col = 0; col < 5; col++) {
                    Cell cell = currentRow.createCell(col);
                    cell.setCellValue("Data at Row " + (row + 1) + ", Column " + (col + 1));
                }
            }

            // Save the workbook to a file
            try (FileOutputStream fileOut = new FileOutputStream("output.xlsx")) {
                workbook.write(fileOut);
            }

            System.out.println("Data has been written to the Excel sheet.");

        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the workbook
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

	
