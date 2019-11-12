package com.tema1.main;

import com.tema1.common.Constants;
import com.tema1.goods.Goods;
import com.tema1.goods.GoodsFactory;
import com.tema1.goods.IllegalGoods;
import com.tema1.goods.LegalGoods;
import com.tema1.player.Player;
import com.tema1.player.PlayerUtils;

import java.util.ArrayList;
import java.util.Map;

final class Bonus {
    private static GoodsFactory myFactory = GoodsFactory.getInstance();

    private Bonus() {
    }

    static void bonusIllegal(final ArrayList<Player> p) {
        for (Player player : p) {
            if (player.getTable().size() > 0) {
                if (!PlayerUtils.allLegal(player.getTable())) {
                    for (int j = 0; j < player.getTable().size(); j++) {
                        if (player.getTable().get(j) > Constants.END_LEGAL) {
                            IllegalGoods igood = (IllegalGoods) myFactory.getGoodsById(player.getTable().get(j));
                            for (Map.Entry<Goods, Integer> entry : igood.getIllegalBonus().entrySet()) {
                                Goods key = entry.getKey();
                                int value = entry.getValue();
                                for (int k = 0; k < value; k++) {
                                    player.addIllegalBonusCard(key.getId());
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    static void bonusKingAndQueen(final ArrayList<Player> p) {
        int[][] table = new int[Constants.END_LEGAL][p.size()];
        for (int i = 0; i < p.size(); i++) {
            if (p.get(i).getTable().size() > 0) {
                for (int j = 0; j < p.get(i).getTable().size(); j++) {
                    if (p.get(i).getTable().get(j) < Constants.END_LEGAL) {
                        table[p.get(i).getTable().get(j)][i]++;
                    }
                }
            }
        }
        for (int i = 0; i < Constants.END_LEGAL; i++) {

            int first = 0;
            int second = 0;
            int firstId = -1;
            int secondId = -1;
            for (int j = 0; j < p.size(); j++) {
                if (table[i][j] > first) {
                    second = first;
                    secondId = firstId;
                    first = table[i][j];
                    firstId = j;
                } else if (table[i][j] > second) {
                    second = table[i][j];
                    secondId = j;
                }
            }
            LegalGoods good = (LegalGoods) myFactory.getGoodsById(i);
            if (firstId != -1) {
                p.get(firstId).setScore(p.get(firstId).getScore() + good.getKingBonus());
            }
            if (secondId != -1) {
                p.get(secondId).setScore(p.get(secondId).getScore() + good.getQueenBonus());
            }
        }


    }
}
