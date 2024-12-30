package com.compass.stepdefinitions;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    public static Map<String, String> readScenarioDetails(String filePath, String scenarioName) throws IOException {
        Map<String, String> scenarioData = new HashMap<>();
        FileInputStream fis = new FileInputStream(filePath);
        Workbook workbook = new XSSFWorkbook(fis);
        Sheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet

        for (Row row : sheet) {
            Cell nameCell = row.getCell(1); // Scenario Name is in column 1 (index 1)
            if (nameCell != null && nameCell.getStringCellValue().equalsIgnoreCase(scenarioName)) {
                scenarioData.put("Node IP", row.getCell(0).getStringCellValue()); // Column 0
                scenarioData.put("Browser Tag", row.getCell(2).getStringCellValue()); // Column 2
                break;
            }
        }
        workbook.close();
        return scenarioData;
    }
}

