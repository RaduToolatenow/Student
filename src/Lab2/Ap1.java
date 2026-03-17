package Lab2;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;




public class Ap1 {
    public static List<Integer> generareNumere(int cate, int maxim) {
        Random rand = new Random();
        List<Integer> lista = new ArrayList<>();

        for (int i = 0; i < cate; i++) {
            int numar = rand.nextInt(maxim) + 1;
            lista.add(numar);
        }

        return lista;
    }

    public static void Sort(List <Integer> list) {
        int n = list.size();

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (list.get(j) > list.get(j + 1)) {

                    int temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }


}
