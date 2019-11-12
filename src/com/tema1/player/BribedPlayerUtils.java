package com.tema1.player;

import com.tema1.common.Constants;

import java.util.ArrayList;

final class BribedPlayerUtils {
    private BribedPlayerUtils() {
    }

    static ArrayList<Integer> buildPocket(final ArrayList<Integer> a, final Player pl) {
        ArrayList<Integer> pocket = new ArrayList<Integer>();
        ArrayList<Integer> c;
        int money = pl.getScore();
        int nIllegal = 0;
        int cost = 0;
        //Daca tot ce are e legal
        if (PlayerUtils.allLegal(a) || money <= Constants.MIN_BRIBE) {
            pl.setBribe(0);
            return BasicPlayerUtils.basicPocket(a);
        } else {
            c = new ArrayList<Integer>(PlayerUtils.sortedbyValueIndexhigh(a));
            int i = 0;
            while (pocket.size() < Constants.MAX_POCKETSIZE) {
                if (i > Constants.MAX_POCKETSIZE + 1) {
                    break;
                }
                if (c.get(i) > Constants.END_LEGAL && money - cost - Constants.PENALTY_ILLEGAL > 0) {
                    cost = cost + Constants.PENALTY_ILLEGAL;
                    pocket.add(c.get(i));
                    nIllegal++;
                }
                if (c.get(i) < Constants.END_LEGAL && money - cost - Constants.PENALTY_LEGAL > 0) {
                    cost = cost + Constants.PENALTY_LEGAL;
                    pocket.add(c.get(i));
                }
                if (money - cost <= Constants.PENALTY_LEGAL) {
                    break;
                }
                i++;
            }
//            System.out.println(money - cost);
            if (nIllegal > Constants.PENALTY_LEGAL) {
                pl.setBribe(Constants.MAX_BRIBE);
            }
            if (nIllegal > 0 && nIllegal <= Constants.PENALTY_LEGAL) {
                pl.setBribe(Constants.MIN_BRIBE);
            }
            return pocket;
        }
    }

}
