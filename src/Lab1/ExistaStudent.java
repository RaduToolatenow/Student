package Lab1;
import java.util.HashMap;
import java.util.List;

public class ExistaStudent{
public static boolean ExistaStud(List<Student> lista, String prenume, String nume, String formatie) {
    for (Student s : lista) {

        if (s.getPrenume().equals(prenume) && s.getNume().equals(nume) && s.getFormatieDeStudiu().equals(formatie)) {
            return true;
        }
    }

    return false;
}


//metoda facuta pt tema4
    public static float gasesteNota(String prenume, String nume, HashMap<Integer, Student> studentiMap) {

        HashMap<String, Student> mapCautare = new HashMap<>();

        for (Student s : studentiMap.values()) {
            String key = s.getPrenume() + "-" + s.getNume();
            mapCautare.put(key, s);
        }

        String cautat = prenume + "-" + nume;

        Student rezultat = mapCautare.get(cautat);

        if (rezultat != null) {
            return (float) rezultat.getNota();
        }

        return 0.0f;
    }



}

