package Lab1;

import java.util.ArrayList;

public class Litere {
    private String alfabet;


    // Constructor
    public Litere() {
        StringBuilder sb = new StringBuilder();
        for (char c = 'a'; c <= 'z'; c++) {
            sb.append(c);
        }
        alfabet = sb.toString();
    }

    public String getAlfabet() {
        return alfabet;
    }

    public String[] splitVocale() {
        ArrayList<String> lista = new ArrayList<>();

        String vocale = "aeiou";

        int start = -1;
        for (int i = 0; i < alfabet.length(); i++) {
            char c = alfabet.charAt(i);
            if (vocale.indexOf(c) >= 0) { // dacă e vocală
                if (start != -1) {

                    // adăugăm substring
                    lista.add(alfabet.substring(start, i));
                }
                start = i; // nou început la vocala curentă
            }
        }
        // adăugăm pana sfarsit
        if (start != -1 && start < alfabet.length()) {
            lista.add(alfabet.substring(start));
        }

        // transformăm ArrayList în array
        return lista.toArray(new String[0]);
    }
}
