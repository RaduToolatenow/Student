package Lab9;

import java.util.*;
import java.util.stream.*;

public class ListaDeCuvinte {
    public static void main(String[] args) {

        //Text initial
        String text = "Acesta este un program scris in java pentru expresii lambda";

        //Lista
        List<String> cuvinte = Arrays.asList(text.split(" "));

        System.out.println("Lista initiala:");
        System.out.println(cuvinte);

        // a)lungime >= 5
        List<String> listaFiltrata = cuvinte.stream()
                .filter(cuvant -> cuvant.length() >= 5)
                .collect(Collectors.toList());

        System.out.println("\nCuvinte lungime >= 5:");
        System.out.println(listaFiltrata);

        //cate snt
        long numar = listaFiltrata.size();

        System.out.println("Numar cuvinte: " + numar);

        // b) Sortare lista noua
        List<String> listaSortata = listaFiltrata.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println("\nLista sortata:");
        System.out.println(listaSortata);

        // c)element incepe cu 'p'
        Optional<String> cuvantP = cuvinte.stream()
                .filter(cuvant -> cuvant.startsWith("p"))
                .findFirst();

        System.out.println("\nCuvant care incepe cu 'p':");

        if (cuvantP.isPresent()) {
            System.out.println(cuvantP.get());
        } else {
            System.out.println("Nu exista.");
        }
    }
}