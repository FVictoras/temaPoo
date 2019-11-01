package com.tema1.main;

import com.tema1.player.BasicPlayer;
import com.tema1.player.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Round {
    ArrayList<Player> players;
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

    public void Game() {
//        for (int j = 0; j<nRounds; j++) {
//
//        }
        for (int i = 0; i < players.size(); i++) {
            (players.get(i)).takeCards(firstTen());
            (players.get(i)).buildPocket();
            System.out.println(players.get(i).getPocket());

        }
        (players.get(0)).startSheriff(players.get(1).getPocket());
    }
}
