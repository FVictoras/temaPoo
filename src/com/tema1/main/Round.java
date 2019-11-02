package com.tema1.main;

import com.tema1.goods.GoodsFactory;
import com.tema1.player.BasicPlayer;
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
    ArrayList<Integer> safeCards;
    ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(21, 22, 23, 24, 21, 22, 22, 23, 24, 21));

    public Round(int np, int nr, ArrayList<Integer> c, ArrayList<String> s) {
        this.nPlayers = np;
        this.nRounds = nr;
        this.players = new ArrayList<Player>();
        this.cards = new ArrayList<Integer>(c);
        this.safeCards = new ArrayList<Integer>(c);
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals("basic")) {
                players.add(new BasicPlayer(a));
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

        for (int i = 0; i<players.size(); i++) {
            for(int j=0; j<players.get(i).getTaraba().size(); j++) {
                players.get(i).changeScore(Singletone.getGoodsById(players.get(i).getTaraba().get(j)).getProfit());
            }
        }
    }

    public void Game() {
        for (int k = 0; k < 2; k++) {
            System.out.println("Game started !@##$#@#@%#$^^#$#$");
            for (int i = 0; i < players.size(); i++) {
                players.get(i).setSheriff(true);
                for (int j = 0; j < players.size(); j++) {
                    if (i != j) {
                        players.get(j).takeCards(firstTen());
                        players.get(j).buildPocket();
                        players.get(i).startSheriff(players.get(j).getPocket(), players.get(j));
                        players.get(j).addTaraba(players.get(j).getPocket());
                    }
                }
            }
        }
        // valorificare
        sellTaraba();
    }
}
