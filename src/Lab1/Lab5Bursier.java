package Lab1;

import Lab3.FInSiOut;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lab5Bursier {



    public static void main(String[] args) {

        List<StudentBursier> bursieri = new ArrayList<>();

        bursieri.add(new StudentBursier(1025, "Andrei",   "Popa",     "ISM141/2",  8.70, 725.50));
        bursieri.add(new StudentBursier(1024, "Ioan",     "Mihalcea", "ISM141/1",  9.80, 801.10));
        bursieri.add(new StudentBursier(1026, "Anamaria", "Prodan",   "TI131/1",   8.90, 745.50));
        bursieri.add(new StudentBursier(1029, "Bianca",   "Popescu",  "TI131/1,",  9.10, 780.80));

        // Afisare in consola
        bursieri.forEach(System.out::println);

        /*for(StudentBursier i:bursieri){
            System.out.println(i);
        }

        for(int i=0;i<bursieri.size();i++){
            System.out.println(bursieri.get(i));
        }*/

        // 🔹 Transformare obiecte -> String
        List<String> linii = bursieri.stream()
                .map(StudentBursier::toString)
                .collect(Collectors.toList());

        // 🔹 Scriere in fisier
        FInSiOut.BagaInFisier("src/Lab1/bursieri.txt", linii);

        System.out.println("Datele au fost salvate in fisier!");

    }
}