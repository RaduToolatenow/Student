import Lab1.Student;
import Lab2.Ap1;

import java.util.*;

import static Lab1.ExistaStudent.ExistaStud;
import static Lab2.Ap1.generareNumere;
import static Lab2.Ap1.Sort;


public class Main{
    public static void main(String[] args) {

        Student Radu = new Student(577, "Radu", "Dogaru", "ISM");

        System.out.println(Radu);




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

        //Ex 2.5.1
        //a
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Sort(xPlusY);
        System.out.println("xPlusY="+ xPlusY);

        //b
        zSet.addAll(x);
        zSet.addAll(y);
        System.out.println("zSet= "+ zSet);

        //c
        for (Integer numar : x) {
            if (!y.contains(numar)) {
                xMinusY.add(numar);
            }
        }

        System.out.println("xMinusY= " + xMinusY);

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

        //Ex 2.5.2
        //a
        List<Student> lista = new ArrayList<>();

        //Studenti
        lista.add(new Student(120,"Valeriu","Popa","ISM21/2"));
        lista.add(new Student(111,"Ion","Mariciuc","ISM21/1"));
        lista.add(new Student(115,"Anca","Dcacov","ISM21/1"));

        System.out.println("Studenti:");

        for(Student s : lista){
            System.out.println(s);
        }
        //b
        boolean student1 = ExistaStud(lista,"Alis","Popa","TI21/2");
        System.out.println("Alis Popa exista: " + student1);

        //c
        boolean student2 = ExistaStud(lista,"Maria","Popa","TI21/1");
        System.out.println("Maria Popa exista: " + student2);




        //Tema casa
        Set <Student> studenti = new HashSet <> ();

        studenti.add(new Student(120,"Alis","Popa","TI21/2"));
        studenti.add(new Student(111,"Ion","Popescu","TI21/1"));
        studenti.add(new Student(115,"Ana","Ionescu","TI21/3"));

        //b si c
        Student s1 = new Student(120,"Alis","Popa","TI21/2");
        Student s2 = new Student(112,"Maria","Popa","TI21/1");

        System.out.println("Student 1 exista: " + studenti.contains(s1));
        System.out.println("Student 2 exista: " + studenti.contains(s2));
    }



}
