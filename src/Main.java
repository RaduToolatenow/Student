import Lab1.Litere;
import Lab1.Student;
import Lab2.Ap1;
import Lab3.FInSiOut;

import java.util.*;

import static Lab1.ExistaStudent.ExistaStud;
import static Lab2.Ap1.generareNumere;
import static Lab2.Ap1.Sort;
import static Lab3.FInSiOut.BagaInFisier;

public class Main{
    public static void main(String[] args) {

        //Laboratoare software
        Litere genereaza = new Litere();

        // afișăm alfabetul complet
        System.out.println("Alfabet: " + genereaza.getAlfabet());

        // creăm array-ul cu secțiuni între vocale
        String[] secvente = genereaza.splitVocale();

        // afișăm array-ul
        for (int i = 0; i < secvente.length; i++) {
            System.out.println("array[" + i + "] = " + secvente[i]);
        }
        System.out.println(" ");

        Student Radu = new Student(577, "Radu", "Dogaru", "ISM");

        System.out.println(Radu);

        System.out.println(" ");

        List<Integer> x = new ArrayList();
        List<Integer> y = new ArrayList();
        List<Integer> xPlusY = new ArrayList(); //a
        Set<Integer> zSet = new TreeSet(); //b
        List<Integer> xMinusY = new ArrayList();//c
        int p = 4;
        List<Integer> xPlusYLimitedByP = new ArrayList(); //d

        x=generareNumere(4,10);

        y=generareNumere(7,10);

        Sort(x);//da
        Sort(y);//da
        System.out.println(x);
        System.out.println(y);
        System.out.println(" ");

        //Ex 2.5.1
        //a
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Sort(xPlusY);
        System.out.println("xPlusY="+ xPlusY);
        System.out.println(" ");

        //b
        zSet.addAll(x);
        zSet.addAll(y);
        System.out.println("zSet= "+ zSet);
        System.out.println(" ");

        //c
        for (Integer numar : x) {
            if (!y.contains(numar)) {
                xMinusY.add(numar);
            }
        }

        System.out.println("xMinusY= " + xMinusY);
        System.out.println(" ");

        //d
        for (Integer numar : x) {
            if (numar <= p && !xPlusYLimitedByP.contains(numar)) {
                xPlusYLimitedByP.add(numar);
            }
        }

        for (Integer numar : y) {
            if (numar <= p && !xPlusYLimitedByP.contains(numar)) {
                xPlusYLimitedByP.add(numar);
            }
        }
        System.out.println("xPlusYLimitedByP " + xPlusYLimitedByP);
        System.out.println(" ");

        //Ex 2.5.2
        //a
        List<Student> lista = new ArrayList<>();

        //Studenti
        lista.add(new Student(120,"Valeriu","Popa","ISM21/2"));
        lista.add(new Student(111,"Ion","Mariciuc","ISM21/1"));
        lista.add(new Student(115,"Anca","Dcacov","ISM21/1"));

        System.out.println("Studenti:");
        System.out.println(" ");

        for(Student s : lista){
            System.out.println(s);
        }

        //b
        boolean student1 = ExistaStud(lista,"Alis","Popa","TI21/2");
        System.out.println("Alis Popa exista: " + student1);
        System.out.println(" ");

        //c
        boolean student2 = ExistaStud(lista,"Maria","Popa","TI21/1");
        System.out.println("Maria Popa exista: " + student2);
        System.out.println(" ");



        //Tema casa lab 2

        Set <Student> studenti = new HashSet <> ();

        studenti.add(new Student(120,"Alis","Popa","TI21/2"));
        studenti.add(new Student(111,"Ion","Popescu","TI21/1"));
        studenti.add(new Student(115,"Ana","Ionescu","TI21/3"));

        //b si c
        Student s1 = new Student(120,"Alis","Popa","TI21/2");
        Student s2 = new Student(112,"Maria","Popa","TI21/1");

        System.out.println("Student 1 exista: " + studenti.contains(s1));
        System.out.println(" ");
        System.out.println("Student 2 exista: " + studenti.contains(s2));
        System.out.println(" ");



        //Lab3

        //3.5.1
        String inputFile = "src/Lab3/in.txt";
        String outputFile = "src/Lab3/out.txt";

        // Citeste cu clasa
        List<String> lines = FInSiOut.readLines(inputFile);

        //a
        List<String> resA = new ArrayList<>();
        for (String line : lines) {
            resA.add(line + "\n");
        }

        //b
        List<String> resB = new ArrayList<>();
        for (String line : lines) {
            resB.add(line.replace(".", ".\n"));
        }

        //c

        // Combina sa salvezi
        List<String> Final = new ArrayList<>();

        Final.add("=== a) ===");
        Final.addAll(resA);

        Final.add("=== b) ===");
        Final.addAll(resB);

        //Scrie cu clasa
        FInSiOut.BagaInFisier(outputFile, Final);

        //Print sa vad ce da
        Final.forEach(System.out::println);



        System.out.println(" ");


        //3.5.2

        List<String> linieCuLinie = FInSiOut.readLines("src/Lab1/studenti_in.txt");

        List<Student> studentiDinFisier = new ArrayList<>();

        for (String line : linieCuLinie) {
            String[] parts = line.split(",");

            studentiDinFisier.add(new Student(
                    Integer.parseInt(parts[0]),
                    parts[1],
                    parts[2],
                    parts[3]
            ));
        }

        // Afisare
        System.out.println("Studenti: ");
        studentiDinFisier.forEach(System.out::println);

        // Sortare dupa nume
        studentiDinFisier.sort(Comparator.comparing(Student::getNume));

        // Scriere in fisier
        List<String> output = new ArrayList<>();

        for (Student s : studentiDinFisier) {
            output.add(s.getNumarMatricol() + ", " + s.getPrenume() + ", " + s.getNume() + ", " + s.getFormatieDeStudiu());
        }

        FInSiOut.BagaInFisier("src/Lab1/studenti_out.txt", output);

        System.out.println(" ");



        //Tema de casa lab 3

        // Sortare dupa: formatie, nume, prenume


        studentiDinFisier.sort(Comparator.comparing(Student::getFormatieDeStudiu).thenComparing(Student::getNume).thenComparing(Student::getPrenume));

        // Scriere fisier
        List<String> outputSorted = new ArrayList<>();

        for (Student s : studentiDinFisier) {
            outputSorted.add(
                    s.getNumarMatricol() + "," +
                            s.getPrenume() + "," +
                            s.getNume() + "," +
                            s.getFormatieDeStudiu()
            );
        }

        FInSiOut.BagaInFisier("src/Lab1/studenti_out_sorted.txt", outputSorted);
        System.out.println(" ");
    }

//d

}
