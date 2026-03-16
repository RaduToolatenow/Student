package Lab1;
import java.util.ArrayList;
import java.util.List;

public class ExistaStudent{
public static boolean ExistaStud(List<Student> lista, String prenume, String nume, String formatie) {
    for (Student s : lista) {

        if (s.getPrenume().equals(prenume) &&
                s.getNume().equals(nume) &&
                s.getFormatieDeStudiu().equals(formatie)) {

            return true;
        }
    }

    return false;
}
}

