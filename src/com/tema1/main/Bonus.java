package com.tema1.main;

import com.tema1.goods.Goods;
import com.tema1.goods.GoodsFactory;
import com.tema1.goods.IllegalGoods;
import com.tema1.goods.LegalGoods;
import com.tema1.player.Player;
import com.tema1.player.PlayerUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Bonus {
    static GoodsFactory Singletone = GoodsFactory.getInstance();
    static ArrayList<Player> myPlayers;
    static Map<Integer, Player> map = new HashMap<Integer, Player>();

    public static int getRecurente(ArrayList<Integer> a, int n) {
        int k = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) == n) {
                k++;
            }
        }
        return k;
    }

    public static void bonusIllegal(ArrayList<Player> p) {
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getTaraba().size() > 0) {
                if (PlayerUtils.allLegal(p.get(i).getTaraba()) == false) {
                    for (int j = 0; j < p.get(i).getTaraba().size(); j++) {
                        if (p.get(i).getTaraba().get(j) > 10) {
                            IllegalGoods igood = (IllegalGoods) Singletone.getGoodsById(p.get(i).getTaraba().get(j));
//                            Map.Entry<Goods, Integer> entry = igood.getIllegalBonus().entrySet().iterator().next();
                            Iterator<Map.Entry<Goods, Integer>> itr = igood.getIllegalBonus().entrySet().iterator();
                            while (itr.hasNext()) {
                                Map.Entry<Goods, Integer> entry = itr.next();
                                Goods key = entry.getKey();
                                int value = entry.getValue();
                                for (int k = 0; k < value; k++) {
                                    p.get(i).addIllegalBonusCard(key.getId());
                                }
                            }
                        }
                    }
                }
            }
        }

    }


    public static void bonusKingAndQueen(ArrayList<Player> p) {
        GoodsFactory Singletone = GoodsFactory.getInstance();
        int[][] table = new int[10][p.size()];
        for (int i = 0; i < p.size(); i++) {
//            myPlayers.add(p.get(i));
            if (p.get(i).getTaraba().size() > 0) {
                for (int j = 0; j < p.get(i).getTaraba().size(); j++) {
                    if (p.get(i).getTaraba().get(j) < 10)
                        table[p.get(i).getTaraba().get(j)][i]++;
                }
            }
        }
        for (int i = 0; i < 10; i++) {

            int first = 0;
            int second = 0;
            int first_id = -1;
            int second_id = -1;
            for (int j = 0; j < p.size(); j++) {
                if (table[i][j] > first) {
                    second = first;
                    second_id = first_id;
                    first = table[i][j];
                    first_id = j;
                } else if (table[i][j] > second) {
                    second = table[i][j];
                    second_id = j;
                }
            }
            LegalGoods good = (LegalGoods) Singletone.getGoodsById(i);
            if (first_id != -1) {
                p.get(first_id).setScore(p.get(first_id).getScore() + good.getKingBonus());
            }
            if (second_id != -1) {
                p.get(second_id).setScore(p.get(second_id).getScore() + good.getQueenBonus());
            }
        }


    }


    // todo de implementat
}
