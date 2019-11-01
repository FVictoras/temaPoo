package com.tema1.player;

import java.util.ArrayList;

public class BasicPlayerUtils {
    public static ArrayList<Integer> basicPocket(ArrayList<Integer> a) {
        ArrayList<Integer> aux = new ArrayList<Integer>();
        ArrayList<Integer> pocket = new ArrayList<Integer>();
        // Cazul toate ilegale, il alege pe cel mai profitabil.
        if (PlayerUtils.allIlegal(a)) {
//            System.out.println(PlayerUtils.mostValuable(a));
            pocket = PlayerUtils.mostValuable(a);
            return pocket;
        } else {
            // Daca exista cel putin o carte legala toate celelalte nu sunt luate in considerare
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < 10) {
                    aux.add(a.get(i));
                }
            }
            // Cazul unul singur cel mai frecvent
            if ((PlayerUtils.mostFrequent(aux)).size() == 1) {
                pocket = PlayerUtils.foundIn(aux, PlayerUtils.mostFrequent(aux).get(0));
//                System.out.println(pocket);
                return pocket;
            }
            // Cazul mai multe cu aceeasi frecventa maxima
            if ((PlayerUtils.mostFrequent(aux)).size() > 1) {
                // Cazul cu unul singur cel mai valoros
                if (PlayerUtils.mostValuable(PlayerUtils.mostFrequent(aux)).size() == 1) {
                    pocket = PlayerUtils.foundIn(aux, PlayerUtils.mostValuable(PlayerUtils.mostFrequent(aux)).get(0));
//                    System.out.println(pocket);
                    return pocket;
                    // Cazul cu mai multe, luand indexul cel mai mare
                } else {
                    pocket = PlayerUtils.foundIn(aux, PlayerUtils.highToLowSort(PlayerUtils.mostValuable(PlayerUtils.mostFrequent(aux))).get(0));
//                    System.out.println(pocket);
                    return pocket;
                }
            }
        }
        return null;
    }
}
