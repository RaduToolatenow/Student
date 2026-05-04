package Lab1;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitireScriereStudent {

    //export
    public static void exportStudent(List<Student> studenti, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Studenti");

        // Header
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("NrMatricol");
        header.createCell(1).setCellValue("Prenume");
        header.createCell(2).setCellValue("Nume");
        header.createCell(3).setCellValue("Grupa");
        header.createCell(4).setCellValue("Nota");

        int rowIndex = 1;

        for (Student s : studenti) {
            Row row = sheet.createRow(rowIndex++);

            row.createCell(0).setCellValue(s.getNumarMatricol());
            row.createCell(1).setCellValue(s.getPrenume());
            row.createCell(2).setCellValue(s.getNume());
            row.createCell(3).setCellValue(s.getFormatieDeStudiu());
            row.createCell(4).setCellValue(s.getNota());
        }

        try (FileOutputStream out = new FileOutputStream(filePath)) {
            workbook.write(out);
            workbook.close();
            System.out.println("Export succes");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //import
    public static List<Student> readStudent(String filePath) {
        List<Student> lista = new ArrayList<>();

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(file)) {

            Sheet sheet = workbook.getSheetAt(0);

            boolean firstRow = true;

            for (Row row : sheet) {

                if (firstRow) { // sari peste header
                    firstRow = false;
                    continue;
                }

                int nr = (int) row.getCell(0).getNumericCellValue();
                String prenume = row.getCell(1).getStringCellValue();
                String nume = row.getCell(2).getStringCellValue();
                String grupa = row.getCell(3).getStringCellValue();
                double nota = row.getCell(4).getNumericCellValue();

                Student s = new Student(nr, prenume, nume, grupa, nota);
                lista.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

}