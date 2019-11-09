package com.tema1.player;

import java.util.ArrayList;

public class BribedPlayerUtils {
    static public ArrayList<Integer> buildPocket(ArrayList<Integer> a, Player pl) {
        ArrayList<Integer> pocket = new ArrayList<Integer>();
        ArrayList<Integer> c;
        int money = pl.getScore();
        int nIllegal = 0;
        int cost = 0;
        //Daca tot ce are e legal
        if (PlayerUtils.allLegal(a) || money <= 5) {
            pl.setBribe(0);
            return BasicPlayerUtils.basicPocket(a);
        } else {
            c = new ArrayList<Integer>(PlayerUtils.sortedbyValueIndexhigh(a));
            int i = 0;
            while (pocket.size() < 8) {
                if (i > 9) {
                    break;
                }
                if (c.get(i) > 9 && money - cost - 4 > 0) {
                    cost = cost + 4;
                    pocket.add(c.get(i));
                    nIllegal++;
                }
                if (c.get(i) < 10 && money - cost - 2 > 0) {
                    cost = cost + 2;
                    pocket.add(c.get(i));
                }
                if (money - cost <= 2) {
                    break;
                }
                i++;
            }
//            System.out.println(money - cost);
            if (nIllegal > 2) {
                pl.setBribe(10);
            }
            if (nIllegal > 0 && nIllegal < 3) {
                pl.setBribe(5);
            }
            return pocket;
        }
    }

}
