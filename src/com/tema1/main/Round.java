package com.tema1.main;

import com.tema1.common.Constants;
import com.tema1.goods.GoodsFactory;
import com.tema1.player.BasicPlayer;
import com.tema1.player.BribedPlayer;
import com.tema1.player.GreedyPlayer;
import com.tema1.player.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class Round {
    private ArrayList<Player> players;
    private GoodsFactory myFactory = GoodsFactory.getInstance();
    private int nRounds;
    private ArrayList<Integer> cards;
    private ArrayList<String> names;

    public Round(final int nr, final ArrayList<Integer> c, final ArrayList<String> s) {
        this.nRounds = nr;
        this.players = new ArrayList<Player>();
        this.names = new ArrayList<String>(s);
        this.cards = new ArrayList<Integer>(c);
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals("basic")) {
                players.add(new BasicPlayer(i));
            }
            if (s.get(i).equals("greedy")) {
                players.add(new GreedyPlayer(i));
            }
            if (s.get(i).equals("bribed")) {
                players.add(new BribedPlayer(i));
            }
        }
    }

    // Functie pentru 'scos' primele 10 carti din pachet
    private ArrayList<Integer> firstTen() {
        ArrayList<Integer> ret = new ArrayList<Integer>(Constants.MAX_CARDS);
        for (int i = 0; i < Constants.MAX_CARDS; i++) {
            ret.add(cards.get(i));
        }
        Iterator itr = cards.iterator();

        for (int i = 0; i < Constants.MAX_CARDS; i++) {
            int x = (Integer) itr.next();
            itr.remove();
        }
        return ret;
    }

    // Obtine bani pentru bunurile de la final
    private void sellTable() {

        for (Player player : players) {
            for (int j = 0; j < player.getTable().size(); j++) {
                player.changeScore(myFactory.getGoodsById(player.getTable().get(j)).getProfit());
            }
        }
    }

    // Verifica scor >16
    private boolean checkOver16(final Player obj) {
        return obj.getScore() >= Constants.MIN_SHSCORE;
    }

    // Afiseaza scoreboardul
    private void printScoreboard() {
        players.sort(new Comparator<Player>() {
            @Override
            public int compare(final Player o1, final Player o2) {
                return o1.compareTo(o2);
            }
        });
        Collections.reverse(players);
        for (Player player : players) {
            System.out.println(player.getPlayerId() + " " + player);
        }


    }

    void startGame() {
        int stanga;
        int dreapta;
        for (int k = 1; k <= nRounds; k++) {
            for (int i = 0; i < players.size(); i++) {
                if (names.get(i).equals("bribed")) {
                    for (int j = 0; j < players.size(); j++) {
                        if (i != j) {
                            players.get(j).takeCards(firstTen());
                            if (names.get(j).equals("greedy")) {
                                players.get(j).buildPocket(k);
                            } else {
                                players.get(j).buildPocket();
                            }
                        }
                    }
                    if (players.size() > 2) {
                        stanga = i + 1;
                        dreapta = i - 1;
                        if (i == players.size() - 1) {
                            stanga = 0;
                            dreapta = i - 1;
                        }
                        if (i == 0) {
                            stanga = players.size() - 1;
                            dreapta = i + 1;
                        }
                        if (this.checkOver16(players.get(i))) {
                            players.get(i).startSheriff(players.get(dreapta).getPocket(), players.get(dreapta));
                        }
                        if (this.checkOver16(players.get(i))) {
                            players.get(i).startSheriff(players.get(stanga).getPocket(), players.get(stanga));
                        }

                        for (int j = 0; j < players.size(); j++) {
                            if (i != j) {
                                if (j == stanga || j == dreapta) {
                                    players.get(j).addTable(players.get(j).getPocket());
                                } else {
                                    players.get(i).checkBribe(players.get(j));
                                    players.get(j).addTable(players.get(j).getPocket());
                                }
                            }
                        }
                    } else {
                        if (i == 0) {
                            if (this.checkOver16(players.get(0))) {
                                players.get(0).startSheriff(players.get(1).getPocket(), players.get(1));
                            }
                            players.get(1).addTable(players.get(1).getPocket());
                        } else {
                            if (this.checkOver16(players.get(1))) {
                                players.get(1).startSheriff(players.get(0).getPocket(), players.get(0));
                            }
                            players.get(0).addTable(players.get(0).getPocket());
                        }
                    }
                } else {
                    for (int j = 0; j < players.size(); j++) {
                        if (i != j) {
                            if (names.get(j).equals("basic")) {
                                players.get(j).takeCards(firstTen());
                                players.get(j).buildPocket();
                                if (this.checkOver16(players.get(i))) {
                                    players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                                }
                                players.get(j).addTable(players.get(j).getPocket());
                            }
                            if (names.get(j).equals("greedy")) {
                                players.get(j).takeCards(firstTen());
                                players.get(j).buildPocket(k);
                                if (this.checkOver16(players.get(i))) {
                                    players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                                }
                                players.get(j).addTable(players.get(j).getPocket());
                            }
                            if (names.get(j).equals("bribed")) {
                                players.get(j).takeCards(firstTen());
                                players.get(j).buildPocket();
                                if (this.checkOver16(players.get(i))) {
                                    players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                                }
                                players.get(j).addTable(players.get(j).getPocket());
                            }
                        }
                    }
                }
            }
        }
        Bonus.bonusIllegal(players);
        Bonus.bonusKingAndQueen(players);
        sellTable();
        printScoreboard();
    }
}
