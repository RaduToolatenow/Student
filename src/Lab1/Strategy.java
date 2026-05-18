package Lab1;

import java.io.*;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class Strategy {

//Strategy pt export:

    // Interfața comuna export
    public interface IStudentiExport {
        void doExport(List<Student> studenti);
    }

    // clasa de export
    public static class Exporter {
        public void startExport(IStudentiExport strategyInstance, List<Student> students) {
            strategyInstance.doExport(students);
        }
    }

// Strategy import:

    // Interfața citire:
    public interface IStudentiImport {
        List<Student> doImport();
    }

    // Clasa Context pentru citire
    public static class Importer {
        public List<Student> startImport(IStudentiImport strategyInstance) {
            return strategyInstance.doImport();
        }
    }





    // a) afisare consola
    public static class StudentiInConsola implements IStudentiExport {
        @Override
        public void doExport(List<Student> studenti) {
            System.out.println("--- Afisare Studenti (Consola) ---");
            for (Student s : studenti) {
                System.out.println(s.toString());
            }
        }
    }

    // b) export in txt
    public static class StudentiInFisierText implements IStudentiExport {
        private String fileName;

        public StudentiInFisierText(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void doExport(List<Student> studenti) {
            try (FileWriter writer = new FileWriter(fileName)) {
                for (Student s : studenti) {
                    writer.write(s.toString() + "\n");
                }
                System.out.println("Datele au fost exportate in: " + fileName);
            } catch (IOException e) {
                System.err.println("Eroare scriere in .text: " + e.getMessage());
            }
        }
    }

    // c)export xlsx
    public static class StudentiInFisierXlsx implements IStudentiExport {
        private String fileName;

        public StudentiInFisierXlsx(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void doExport(List<Student> studenti) {

            try (Workbook workbook = new XSSFWorkbook()) {

                Sheet sheet = workbook.createSheet("Studenti");

                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("NumarMatricol");
                headerRow.createCell(1).setCellValue("Prenume");
                headerRow.createCell(2).setCellValue("Nume");
                headerRow.createCell(3).setCellValue("Formatie");
                headerRow.createCell(4).setCellValue("Nota");

                int rowNum = 1;
                for (Student s : studenti) {
                    Row row = sheet.createRow(rowNum++);

                    row.createCell(0).setCellValue(s.getNumarMatricol());
                    row.createCell(1).setCellValue(s.getPrenume());
                    row.createCell(2).setCellValue(s.getNume());
                    row.createCell(3).setCellValue(s.getFormatieDeStudiu());
                    row.createCell(4).setCellValue(s.getNota());
                }

                try (FileOutputStream fileOut = new FileOutputStream(fileName)) {
                    workbook.write(fileOut);
                    System.out.println("A mers, le gasesti la: " + fileName);
                }

            } catch (IOException e) {
                System.err.println("Nu a mers " + e.getMessage());
            }
        }
    }



    //d) citire .txt
    public static class StudentiDinFisierText implements IStudentiImport {
        private String fileName;

        public StudentiDinFisierText(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public List<Student> doImport() {
            List<Student> studenti = new ArrayList<>();
            System.out.println("Se citesc datele din .txt: " + fileName);

            try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.trim().isEmpty()) continue; // Ignora rand gol

                    try {

                        String[] parts = line.split(" ");
                        if (parts.length >= 5) {
                            // extrage valori cu etichete
                            int numarMatricol = Integer.parseInt(parts[0].replace("ID:", ""));
                            String prenume = parts[1];
                            String nume = parts[2];
                            String formatie = parts[3].replace("grupa:", "");
                            double nota = Double.parseDouble(parts[4].replace("nota:", ""));

                            studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
                        }
                    } catch (Exception ex) {
                        System.err.println("Eroare la parsarea liniei: '" + line + "' -> " + ex.getMessage());
                    }
                }
                System.out.println("Import text, s-au adaugat " + studenti.size() + " studenti");
            } catch (IOException e) {
                System.err.println("Eroare la citire din text: " + e.getMessage());
            }

            return studenti;
        }
    }

    // e) Strategy pentru citire din fișier XLSX
    public static class StudentiDinFisierXlsx implements IStudentiImport {
        private String fileName;

        public StudentiDinFisierXlsx(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public List<Student> doImport() {
            List<Student> studenti = new ArrayList<>();
            System.out.println("Se citesc date: " + fileName);

            try (FileInputStream fis = new FileInputStream(fileName);
                 Workbook workbook = new XSSFWorkbook(fis)) {

                Sheet sheet = workbook.getSheetAt(0);
                boolean isFirstRow = true;

                for (Row row : sheet) {
                    if (isFirstRow) {
                        isFirstRow = false;
                        continue;
                    }
                    if (row.getCell(0) == null) continue;

                    try {
                        int numarMatricol = (int) row.getCell(0).getNumericCellValue();
                        String prenume = row.getCell(1).getStringCellValue();
                        String nume = row.getCell(2).getStringCellValue();
                        String formatie = row.getCell(3).getStringCellValue();
                        double nota = row.getCell(4).getNumericCellValue();

                        studenti.add(new Student(numarMatricol, prenume, nume, formatie, nota));
                    } catch (Exception ex) {
                        System.err.println("Eroare la parsarea rand " + row.getRowNum() + ": " + ex.getMessage());
                    }
                }
                System.out.println("Import Excel, so bagat: " + studenti.size() + " studenti");

            } catch (IOException e) {
                System.err.println("Eroare la XLSX: " + e.getMessage());
            }

            return studenti;
        }
    }







}




