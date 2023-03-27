package com.example.readexcel.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

    public List<String> read() {
        List<String> data = new ArrayList<>();
        try {
            // 경로에 있는 파일을 읽기
            FileInputStream file = new FileInputStream("C:\\Users\\PC\\Desktop\\TestExcel\\Test.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            int rowNo = 0;
            int cellIndex = 0;

            XSSFSheet sheet = workbook.getSheetAt(0); // 0 번째 시트를 가져온다
            // 만약 시트가 여러개 인 경우 for 문을 이용하여 각각의 시트를 가져온다
            int rows = sheet.getPhysicalNumberOfRows(); // 사용자가 입력한 엑셀 Row수를 가져온다
            for(rowNo = 1; rowNo < rows; rowNo++) {
                XSSFRow row = sheet.getRow(rowNo);
                if (row != null) {
                    int cells = row.getPhysicalNumberOfCells(); // 해당 Row에 사용자가 입력한 셀의 수를 가져온다
                    for (cellIndex = 0; cellIndex <= cells; cellIndex++) {
                        XSSFCell cell = row.getCell(cellIndex); // 셀의 값을 가져온다
                        String value = "";
                        if (cell == null) { // 빈 셀 체크
                            continue;
                        } else {
                            // 타입 별로 내용을 읽는다
                            switch (cell.getCellType()) {
                                case FORMULA:
                                    value = cell.getCellFormula();
                                    break;
                                case NUMERIC:
                                    value = cell.getNumericCellValue() + "";
                                    break;
                                case STRING:
                                    value = cell.getStringCellValue() + "";
                                    break;
                                case BLANK:
                                    value = cell.getBooleanCellValue() + "";
                                    break;
                                case ERROR:
                                    value = cell.getErrorCellValue() + "";
                                    break;
                            }
                        }
                        System.out.println(rowNo + "번 행 : " + cellIndex + "번 열 값은: " + value);
                        data.add(value);
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
