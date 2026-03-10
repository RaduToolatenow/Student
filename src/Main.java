import Lab1.Student;
import Lab2.Ap1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
        xPlusY.addAll(x);
        xPlusY.addAll(y);
        Sort(xPlusY);
        System.out.println(xPlusY);
    }



}
