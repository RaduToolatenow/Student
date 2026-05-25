package Lab1;

import java.util.Arrays;
import java.util.List;

public class PtLab11 {
    public static void main(String[] args) {

        List<Student> studenti = Arrays.asList(
                new Student(1, "Ana", "Maria", "ISM1.1", 9.5),
                new Student(2, "Ion", "Barabas", "ISM2.1", 8.7)
        );

        Strategy.Exporter exporter = new Strategy.Exporter();

// export normal
        Strategy.IStudentiExport exportTxt =
                new Strategy.StudentiInFisierText("studenti.txt");

// decorare cu timer
        exportTxt = new Strategy.ExportTimeDecorator(exportTxt);

// apel export
        exporter.startExport(exportTxt, studenti);



        Strategy.IStudentiExport exportExcel =
                new Strategy.StudentiInFisierXlsx("studenti.xlsx");

        exportExcel =
                new Strategy.ExportTimeDecorator(exportExcel);

        exporter.startExport(exportExcel, studenti);

    }

    }
