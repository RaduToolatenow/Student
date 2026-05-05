package Lab9;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class ListaNumere {
    public static void main(String[] args) {

        //fct random
        Random rand = new Random();
        List<Integer> lista = rand.ints(10, 5, 26) // 26 pentru ca limita superioara e exclusiva
                .boxed()
                .collect(Collectors.toList());

        System.out.println("Lista initiala: " + lista);

        // a) Suma elemente
        int suma = lista.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Suma: " + suma);

        // b) Maxim si minim
        int max = lista.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow();

        int min = lista.stream()
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow();

        System.out.println("Maxim: " + max);
        System.out.println("Minim: " + min);

        // c) Lista intre 10 si 20
        List<Integer> filtrata = lista.stream()
                .filter(x -> x >= 10 && x <= 20)
                .collect(Collectors.toList());

        System.out.println("Lista intre 10 si 20: " + filtrata);

        // d) Mapare la Double
        List<Double> listaDouble = lista.stream()
                .map(x -> x.doubleValue())
                .collect(Collectors.toList());

        System.out.println("Lista Double: " + listaDouble);

        // e) Verifica daca exista 12
        boolean exista12 = lista.stream()
                .anyMatch(x -> x == 12);

        System.out.println("Este 12: " + exista12);
    }

}
