package Lab8;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static Lab8.CitireExcel.readExcel;

public class MedieAverage {

    //gasire coloana
    private static String getColumnLetter(int column) {
        StringBuilder letter = new StringBuilder();

        while (column >= 0) {
            letter.insert(0, (char) ('A' + (column % 26)));
            column = column / 26 - 1;
        }

        return letter.toString();
    }

    public static void copysiAverage(String inputPath, String outputPath) {
        try (FileInputStream file = new FileInputStream(new File(inputPath));
             Workbook workbook = new XSSFWorkbook(file);
             Workbook newWorkbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.getSheetAt(0);
            Sheet newSheet = newWorkbook.createSheet("Result");

            int rowIndex = 0;

            for (Row row : sheet) {
                Row newRow = newSheet.createRow(rowIndex);

                int cellIndex = 0;

                // Copiere celule existente
                for (Cell cell : row) {
                    Cell newCell = newRow.createCell(cellIndex);

                    switch (cell.getCellType()) {
                        case NUMERIC:
                            newCell.setCellValue(cell.getNumericCellValue());
                            break;
                        case STRING:
                            newCell.setCellValue(cell.getStringCellValue());
                            break;
                        case BOOLEAN:
                            newCell.setCellValue(cell.getBooleanCellValue());
                            break;
                        default:
                            newCell.setCellValue("");
                    }

                    cellIndex++;
                }

                // formula de medie
                if (rowIndex != 0) { // evita header
                    int lastCol = cellIndex;


                    String formula = String.format(
                            "AVERAGE(%s%d:%s%d)",
                            getColumnLetter(lastCol - 3), rowIndex + 1,
                            getColumnLetter(lastCol - 1), rowIndex + 1
                    );

                    newRow.createCell(lastCol).setCellFormula(formula);
                } else {
                    newRow.createCell(cellIndex).setCellValue("Medie");
                }

                rowIndex++;
            }

            // Scriere in fișier
            FileOutputStream out = new FileOutputStream(new File(outputPath));
            newWorkbook.write(out);
            out.close();

            System.out.println("Fisier generat cu succes ");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        readExcel("src/Lab8/laborator8_input.xlsx");

        copysiAverage(
                "src/Lab8/laborator8_input.xlsx",
                "src/Lab8/laborator8_output3.xlsx"
        );
    }

}
