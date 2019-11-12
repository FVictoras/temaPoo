package com.tema1.player;

import com.tema1.common.Constants;
import com.tema1.goods.GoodsFactory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.HashMap;

public final class PlayerUtils {
    private static GoodsFactory myGoodsFactory = GoodsFactory.getInstance();

    private PlayerUtils() {
    }

    // cauta secventele cele mai frecvente
    public static ArrayList<Integer> mostFrequent(final ArrayList<Integer> a) {
        ArrayList<Integer> freqId = new ArrayList<Integer>();
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
        int maxCount = -1;
        for (Map.Entry<Integer, Integer> entry : hash.entrySet()) {
            if (entry.getValue() == maxCount) {
                freqId.add(entry.getKey());
            }
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                freqId.clear();
                freqId.add(entry.getKey());
            }
        }
        return freqId;
    }

    // verifica exista unui element intr-un arraylist
    public static boolean checkIf(final ArrayList<Integer> a, final int n) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == n) {
                return false;
            }
        }
        return true;
    }

    // returneaza id-ul cartii celei mai valoroase din lista celor mai frecvente
    public static ArrayList<Integer> mostValuable(final ArrayList<Integer> a) {
        int maxValue = -1;
        ArrayList<Integer> mostValueable = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (myGoodsFactory.getGoodsById(a.get(i)).getProfit() == maxValue && checkIf(mostValueable, a.get(i))) {
                mostValueable.add(a.get(i));
            }
            if (myGoodsFactory.getGoodsById(a.get(i)).getProfit() > maxValue) {
                maxValue = myGoodsFactory.getGoodsById(a.get(i)).getProfit();
//                System.out.println(maxValue);
                mostValueable.clear();
                mostValueable.add(a.get(i));
            }
        }
        return mostValueable;
    }

    public static int mostValuableIllegal(final ArrayList<Integer> a) {
        int maxValue = -1;
        int mostValueable = -1;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > Constants.END_LEGAL) {
                if (myGoodsFactory.getGoodsById(a.get(i)).getProfit() == maxValue) {
                    mostValueable = a.get(i);
                }
                if (myGoodsFactory.getGoodsById(a.get(i)).getProfit() > maxValue) {
                    maxValue = myGoodsFactory.getGoodsById(a.get(i)).getProfit();
//                System.out.println(maxValue);
                    mostValueable = a.get(i);
                }
            }
        }
        return mostValueable;
    }

    //Sorteaza descrescator
    public static ArrayList<Integer> highToLowSort(final ArrayList<Integer> a) {
        a.sort(null);
        Collections.reverse(a);
        return a;
    }

    //Verifica daca toate sunt legale
    public static boolean allIlegal(final ArrayList<Integer> a) {
        //            System.out.println("SUNT LEGALE Si/Sau ilegale");
        return (PlayerUtils.highToLowSort(a)).get(a.size() - 1) >= Constants.START_ILLEGAL;
//        System.out.println("SUNT DOAR ILEGALE");
    }

    public static void removeCard(final ArrayList<Integer> a, final ArrayList<Integer> n) {
        Iterator itr = a.iterator();
        while (itr.hasNext()) {
            int x = (Integer) itr.next();
            if (x == n.get((n.size() - 1))) {
                itr.remove();
                break;
            }
        }
    }

    public static boolean allLegal(final ArrayList<Integer> a) {
        return (PlayerUtils.highToLowSort(a)).get(0) < Constants.END_LEGAL;
    }

    public static boolean minimumOneIlegal(final ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > Constants.END_LEGAL) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Integer> sortedbyValueIndexhigh(final ArrayList<Integer> a) {
        ArrayList<Integer> c = new ArrayList<Integer>(a);
        com.tema1.player.PlayerUtils.highToLowSort(c);
        int aux;
        int[] v = new int[c.size()];
        for (int i = 0; i < c.size(); i++) {
            v[i] = c.get(i);
        }
        for (int j = 0; j < c.size(); j++) {
            for (int i = 0; i < c.size() - 1; i++) {
                if (myGoodsFactory.getGoodsById(v[i]).getProfit() < myGoodsFactory.getGoodsById(v[i + 1]).getProfit()) {
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
    public static ArrayList<Integer> foundIn(final ArrayList<Integer> a, final int n) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < a.size(); i++) {
            if (n == a.get(i)) {
                res.add(a.get(i));
            }
        }
        return res;
    }
}
