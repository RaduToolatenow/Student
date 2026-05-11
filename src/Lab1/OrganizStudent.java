package Lab1;

import java.util.*;
import java.util.stream.Collectors;

public class OrganizStudent {
    public static void main(String[] args) {

        List<Student> studentiCuNote = Arrays.asList(
                new Student(1025,"Andrei","Popa","ISM141/2", 8.70),
                new Student(1024,"Ioan","Mihalcea","ISM141/1", 10),
                new Student(1026,"Anamaria","Prodan","TI131/1", 8.90),
                new Student(1029,"Bianca","Popescu","TI131/1", 10),
                new Student(1030,"Maria","Pana","TI131/2", 4.10),
                new Student(1031,"Gabriela","Mohanu","TI131/2", 7.33),
                new Student(1032,"Marius","Nasta","TI131/2", 3.20),
                new Student(1033,"Marius","Nasta","TI131/1", 5.12),
                new Student(1034,"Andrei","Dobrescu","TI131/2", 2.22)
        );

        // a) Studenti nota 10
        System.out.println("Studenti cu nota 10: ");

        studentiCuNote.stream()
                .filter(student -> student.getNota() == 10)
                .forEach(System.out::println);

        // b) Studenti nota sub 5
        System.out.println("\nStudenti cu nota sub 5: ");

        studentiCuNote.stream()
                .filter(student -> student.getNota() < 5)
                .forEach(System.out::println);

        // c) Studentii nota < 4; = 4
        System.out.println("\nLista modificata:");

        List<Student> listaModificata = studentiCuNote.stream()
                .map(student -> {
                    if (student.getNota() < 4) {
                        return new Student(
                                student.getNumarMatricol(),
                                student.getPrenume(),
                                student.getNume(),
                                student.getFormatieDeStudiu(),
                                4
                        );
                    }
                    return student;
                })
                .collect(Collectors.toList());

        listaModificata.forEach(System.out::println);

        // d) Suma notelor
        double suma = studentiCuNote.stream()
                .map(Student::getNota)
                .reduce(0.0, Double::sum);

        System.out.println("\nSuma notelor: " + suma);

        // e) Media notelor
        double media = suma / studentiCuNote.size();

        System.out.println("Media notelor: " + media);
    }
}