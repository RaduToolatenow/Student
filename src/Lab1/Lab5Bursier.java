package Lab1;

import Lab3.FInSiOut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lab5Bursier {

    // Metoda statica de salvare, accepta orice lista de Student (sau subclase)
    public static void salveazaInFisier(String numeFisier, List<? extends Student> colectie) {
        List<String> linii = colectie.stream()
                .map(Student::toString)
                .collect(Collectors.toList());
        FInSiOut.BagaInFisier(numeFisier, linii);
    }

    public static void main(String[] args) {

        List<StudentBursier> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursier(1025, "Andrei",   "Popa",     "ISM141/2",  8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan",     "Mihalcea", "ISM141/1",  9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan",   "TI131/1",   8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca",   "Popescu",  "TI131/1,",  9.10, 780.80));

        // Afisare in consola
        bursieri.forEach(System.out::println);

        // Salvare in fisier
        salveazaInFisier("bursieri_out.txt", bursieri);

        System.out.println("\nLista salvata in bursieri_out.txt");
    }
}