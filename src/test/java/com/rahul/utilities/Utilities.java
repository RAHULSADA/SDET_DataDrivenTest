package com.rahul.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class Utilities {

    public static Object[][] readExcel() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("StudentDetails.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        XSSFSheet worksheet = workbook.getSheetAt(0);
        int rowCount = worksheet.getPhysicalNumberOfRows();
        XSSFRow firstRow = worksheet.getRow(0);
        short colCount = firstRow.getLastCellNum();
        Object[][] testData = new Object[rowCount-1][colCount];
        DataFormatter dataFormatter = new DataFormatter();

        for (int i = 0; i < rowCount-1; i++) {
            for (int j = 0; j < colCount; j++)
                testData[i][j] = dataFormatter.formatCellValue(worksheet.getRow(i+1).getCell(j));
        }
        return testData;
    }
}
