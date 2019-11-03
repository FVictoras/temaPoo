package com.tema1.player;

import com.tema1.goods.GoodsFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PlayerUtils {
    // Singletone al goodsfactory
    public static GoodsFactory Singletone = GoodsFactory.getInstance();

    // cauta secventele cele mai frecvente
    public static ArrayList<Integer> mostFrequent(ArrayList<Integer> a) {
        ArrayList<Integer> FreqId = new ArrayList<Integer>();
        Map<Integer, Integer> hash = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            int key = a.get(i);
            if (hash.containsKey(key)) {
                int freq = hash.get(key);
                freq++;
                hash.put(key, freq);
            } else {
                hash.put(key, 1);
            }
        }
        int max_count = -1;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() == max_count) {
                FreqId.add(entry.getKey());
            }
            if (entry.getValue() > max_count) {
                max_count = entry.getValue();
                FreqId.clear();
                FreqId.add(entry.getKey());
            }
        }
        return FreqId;
    }

    // verifica exista unui element intr-un arraylist
    public static boolean checkIf(ArrayList<Integer> a, int n) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == n) {
                return false;
            }
        }
        return true;
    }

    // returneaza id-ul cartii celei mai valoroase din lista celor mai frecvente
    public static ArrayList<Integer> mostValuable(ArrayList<Integer> a) {
        int max_value = -1;
        ArrayList<Integer> mostValueable = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (Singletone.getGoodsById(a.get(i)).getProfit() == max_value && checkIf(mostValueable, a.get(i))) {
                mostValueable.add(a.get(i));
            }
            if (Singletone.getGoodsById(a.get(i)).getProfit() > max_value) {
                max_value = Singletone.getGoodsById(a.get(i)).getProfit();
//                System.out.println(max_value);
                mostValueable.clear();
                mostValueable.add(a.get(i));
            }
        }
        return mostValueable;
    }

    public static int mostValuableIllegal(ArrayList<Integer> a) {
        int max_value = -1;
        int mostValueable = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > 10) {
                if (Singletone.getGoodsById(a.get(i)).getProfit() == max_value) {
                    mostValueable = a.get(i);
                }
                if (Singletone.getGoodsById(a.get(i)).getProfit() > max_value) {
                    max_value = Singletone.getGoodsById(a.get(i)).getProfit();
//                System.out.println(max_value);
                    mostValueable = a.get(i);
                }
            }
        }
        return mostValueable;
    }

    //Sorteaza descrescator
    public static ArrayList<Integer> highToLowSort(ArrayList<Integer> a) {
        a.sort(null);
        Collections.reverse(a);
        return a;
    }

    //Verifica daca toate sunt legale
    public static boolean allIlegal(ArrayList<Integer> a) {
        if ((PlayerUtils.highToLowSort(a)).get(a.size() - 1) < 19) {
//            System.out.println("SUNT LEGALE Si/Sau ilegale");
            return false;
        }
//        System.out.println("SUNT DOAR ILEGALE");

        return true;
    }

    public static boolean allLegal(ArrayList<Integer> a) {
        if ((PlayerUtils.highToLowSort(a)).get(0) < 10) {
            return true;
        }
        return false;
    }

    public static boolean minimumOneIlegal(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > 10) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> sortedbyValueIndexhigh(ArrayList<Integer> a) {
        ArrayList<Integer> c = new ArrayList<Integer>(a);
        PlayerUtils.highToLowSort(c);
        int aux;
        int[] v = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            v[i] = c.get(i);
        }
        for (int j = 0; j < c.size(); j++) {
            for (int i = 0; i < c.size() - 1; i++) {
                if (Singletone.getGoodsById(v[i]).getProfit() < Singletone.getGoodsById(v[i + 1]).getProfit()) {
                    aux = v[i];
                    v[i] = v[i + 1];
                    v[i + 1] = aux;
                }
            }
        }
        aux = c.size();
        c.clear();
        for (int i = 0; i < aux; i++) {
            c.add(v[i]);
        }
        return c;
    }
    //Returneaza un sir plin cu n lung de frecventa aparitiei lui n in a.
    public static ArrayList<Integer> foundIn(ArrayList<Integer> a, int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (n == a.get(i)) {
                res.add(a.get(i));
            }
        }
        return res;
    }
}
