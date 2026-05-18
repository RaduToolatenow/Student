package Lab1;

import java.util.Arrays;
import java.util.List;

public class AplicatieCuStrategy {
    public static void main(String[] args) {

        // Popularea listei de studenți folosind datele din laborator
        List<Student> studenti = Arrays.asList(
                new Student(1025, "Andrei", "Popa", "ISMI41/2", 8.70),
                new Student(1024, "Ioan", "Mihalcea", "ISM141/1", 10.0),
                new Student(1026, "Anamaria", "Prodan", "TI131/1", 8.90),
                new Student(1029, "Bianca", "Popescu", "TI131/1", 10.0),
                new Student(1029, "Maria", "Pana", "TI131/2", 4.10),
                new Student(1029, "Gabriela", "Mohanu", "TI131/2", 7.33),
                new Student(1029, "Marius", "Nasta", "TI131/2", 3.20),
                new Student(1029, "Marius", "Nasta", "TI131/1", 5.12),
                new Student(1029, "Andrei", "Dobrescu", "TI131/2", 2.22)
        );

        //test
        Strategy.Exporter exporter = new Strategy.Exporter();

        // a)export consola
        Strategy.IStudentiExport strategyConsole = new Strategy.StudentiInConsola();
        exporter.startExport(strategyConsole, studenti);

        // b)export txt
        String fileNameTxt = "studentiStrategyText.txt";
        Strategy.IStudentiExport strategyFisierText = new Strategy.StudentiInFisierText(fileNameTxt);
        exporter.startExport(strategyFisierText, studenti);

        // c)export excel
        String fileNameXlsx = "studentiStrategyExcel.xlsx"; // Folosim extensie CSV pentru test
        Strategy.IStudentiExport strategyFisierExcel = new Strategy.StudentiInFisierXlsx(fileNameXlsx);
        exporter.startExport(strategyFisierExcel, studenti);


        //test import
        System.out.println("\nInitImport");
        Strategy.Importer importer = new Strategy.Importer();

        // d)import txt
        Strategy.IStudentiImport importTxt = new Strategy.StudentiDinFisierText(fileNameTxt);
        List<Student> studentiDinTxt = importer.startImport(importTxt);

        // e)import xcel
        Strategy.IStudentiImport importXlsx = new Strategy.StudentiDinFisierXlsx(fileNameXlsx);
    }
}