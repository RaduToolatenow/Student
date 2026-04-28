package Lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class CitireExcel {
    public static void readExcel(String filePath) {
        try (FileInputStream file = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            Iterator<Row> coloanai = sheet.iterator();

            while (coloanai.hasNext()) {
                Row row = coloanai.next();

                Iterator<Cell> i = row.iterator();

                while (i.hasNext()) {
                    Cell cell = i.next();

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        case BLANK:
                            System.out.print(" \t");
                            break;
                        default:
                            System.out.print("?\t");
                            break;
                    }
                }
                System.out.println();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Example main method to run it
    public static void main(String[] args) {
        readExcel("src/Lab8/laborator8_input.xlsx");
    }
}
