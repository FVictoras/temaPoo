package com.tema1.main;

import com.tema1.goods.GoodsFactory;
import com.tema1.player.BasicPlayer;
import com.tema1.player.BribedPlayer;
import com.tema1.player.GreedyPlayer;
import com.tema1.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Round {
    ArrayList<Player> players;
    GoodsFactory Singletone = GoodsFactory.getInstance();
    int nPlayers;
    int nRounds;
    ArrayList<Integer> cards;
    ArrayList<String> names;
    ArrayList<Integer> safeCards;
    ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(21, 22, 23, 24, 21, 22, 22, 23, 24, 21));

    public Round(int np, int nr, ArrayList<Integer> c, ArrayList<String> s) {
        this.nPlayers = np;
        this.nRounds = nr;
        this.players = new ArrayList<Player>();
        this.names = new ArrayList<String>(s);
        this.cards = new ArrayList<Integer>(c);
        this.safeCards = new ArrayList<Integer>(c);
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals("basic")) {
                players.add(new BasicPlayer(a));
            }
            if (s.get(i).equals("greedy")) {
                players.add(new GreedyPlayer());
            }
            if (s.get(i).equals("bribed")) {
                players.add(new BribedPlayer());
            }
        }
    }

    public ArrayList<Integer> firstTen() {
        ArrayList<Integer> ret = new ArrayList<Integer>(10);
        for (int i = 0; i < 10; i++) {
            ret.add(cards.get(i));
        }
        Iterator itr = cards.iterator();

        for (int i = 0; i < 10; i++) {
            int x = (Integer) itr.next();
            itr.remove();
        }
        System.out.println(ret);
        return ret;
    }

    public void sellTaraba() {

        for (int i = 0; i < players.size(); i++) {
            for (int j = 0; j < players.get(i).getTaraba().size(); j++) {
                players.get(i).changeScore(Singletone.getGoodsById(players.get(i).getTaraba().get(j)).getProfit());
            }
        }
    }

    public void Game() {
        int stanga;
        int dreapta;
        for (int k = 1; k <= 2; k++) {
            System.out.println("Game started !@##$#@#@%#$^^#$#$");
            for (int i = 0; i < players.size(); i++) {
                players.get(i).setSheriff(true);


                // Tot iful dedicat sherifului bribed
                if (names.get(i).equals("bribed")) {
                    for (int j = 0; j < players.size(); j++) {
                        if (i != j) {
                            players.get(j).takeCards(firstTen());
                            players.get(j).buildPocket();
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
                        players.get(i).startSheriff(players.get(stanga).getPocket(), players.get(stanga));
                        players.get(i).startSheriff(players.get(dreapta).getPocket(), players.get(dreapta));

                        for (int j = 0; j < players.size(); j++) {
                            if (j == stanga || j == dreapta) {
                                players.get(j).addTaraba(players.get(j).getPocket());
                            } else {
                                players.get(i).checkBribe(players.get(j));
                                players.get(j).addTaraba(players.get(j).getPocket());
                            }
                        }
                    } else {
                        if (i == 0) {
                            System.out.println("Heii sunt  si am: packet" + players.get(1).getPocket());
                            players.get(0).startSheriff(players.get(1).getPocket(), players.get(1));
                            System.out.println("Heii sunt si am: packet" + players.get(1).getPocket());
                            players.get(1).addTaraba(players.get(1).getPocket());
                        } else {
                            players.get(1).startSheriff(players.get(0).getPocket(), players.get(0));
                            players.get(0).addTaraba(players.get(0).getPocket());
                        }
                    }
                } else {
                    // serif oricare altul
                    for (int j = 0; j < players.size(); j++) {
                        if (i != j) {
                            if (names.get(j).equals("basic")) {
                                players.get(j).takeCards(firstTen());
                                players.get(j).buildPocket();
                                players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                                players.get(j).addTaraba(players.get(j).getPocket());
                            }
                            if (names.get(j).equals("greedy")) {
                                players.get(j).takeCards(firstTen());
                                players.get(j).buildPocket(k);
                                players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                                players.get(j).addTaraba(players.get(j).getPocket());
                            }
                            if (names.get(j).equals("bribed")) {
                                players.get(j).takeCards(firstTen());
                                players.get(j).buildPocket();
                                players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                                players.get(j).addTaraba(players.get(j).getPocket());
                            }
                        }
                    }
                }
            }
        }
        // valorificare
        //
        System.out.println(players.get(0));
        System.out.println(players.get(1));
        Bonus.bonusIllegal(players);
        Bonus.bonusKingAndQueen(players);
        sellTaraba();
    }
}
