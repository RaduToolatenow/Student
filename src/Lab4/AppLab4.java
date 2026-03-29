package Lab4;

import java.util.HashMap;
import java.util.Map;

public class AppLab4 {

    static void main() {
        HashMap<String, Integer> varste = new HashMap<>();
        varste.put("Ioan", 21);
        varste.put("Maria", 22);
        varste.put("Victor", 20);
        varste.put("Simina", 20);
        varste.put("Marius", 21);
        varste.put("Mihai", 21);
        varste.put("Daniela", 23);
        Map<String, String> adrese = Map.of("Ioan", "Sibiu", "Maria", "Bucuresti", "Victor", "Cluj","Simina", "Alba-Iulia","Marius", "Medias", "Mihai", "Cisnadie","Daniela", "Sibiu");

        //a

        //Vlad și Iulia
        varste.put("Vlad", 19);
        varste.put("Iulia", 19);

        //Afisare varste
        System.out.println("Varste:");
        for (Map.Entry<String, Integer> entry : varste.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());

        }


        //c

        HashMap<String, Tanar> tineri = new HashMap<>();

        for (String nume : varste.keySet()) {
            int varsta = varste.get(nume);
            String adresa = adrese.getOrDefault(nume, "Necunoscut");

            Tanar tanar = new Tanar(nume, varsta, adresa);

            tineri.put(nume, tanar);
        }

        //d
        tineri.forEach((key, value) -> System.out.println(key + " -> " + value));

    }

}
