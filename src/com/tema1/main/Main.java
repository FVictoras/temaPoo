package com.tema1.main;

import com.tema1.goods.GoodsFactory;
import com.tema1.player.GreedyPlayer;
import com.tema1.player.Player;

import java.util.ArrayList;
import java.util.Arrays;

public final class Main {

    public static void main(final String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader("E:\\Java Development\\Tema1_2019_v1\\tests\\in\\test1.in", "E:\\Java Development\\Tema1_2019_v1\\tests\\ref\\exit.ref");
        GameInput gameInput = gameInputLoader.load();
//        System.out.println(gameInput.getTotalPlayers());

        // Singletone initializeaza si returneaza instanta la 'Goods' dorit.
        GoodsFactory Singletone = GoodsFactory.getInstance();
        // TODO: implement homework logic

        // Testing zone
//        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(21,22,23,24,21,22,22,23,24,21));
//        ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,3,9,9));
//
//        BasicPlayer b0 = new BasicPlayer(a);
//        BasicPlayer b1 = new BasicPlayer(a2);
//        System.out.println(b0);
//        b0.buildPocket();
//        System.out.println(b0.getPocket());
//
//        b1.takeCards(a2);
//        System.out.println(b1);
//        b1.buildPocket();
//        System.out.println(b1.getPocket());
//
//        System.out.println("SERIFF ------------");
//        BasicSheriff s1 = new BasicSheriff(1);
//        s1.startSheriff(b0.getPocket());
//        System.out.println(b0.getPocket());
//        s1.startSheriff(b1.getPocket());
//        System.out.println(b1.getPocket());

        ////////////////Testing for basic v basic///////////////////
//        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(4,24,23,24,0,23,21,3,20,24,4,1,4,20,22,0,3,3,4,23,23,9,8,8,9,6,2,24,6,22,2,7,3,5,4,4,1,20,21,6,20,7,22,24,20,24,2,3,22,1,1,4,8,24,8,21,8,9,9,22,0,3,1,21,24,22,22,9,22,24,6,24,22,1,23,3,2,4,9,3,5,24,5,7,7,5,7,1,23,23,24,2,3,8,3,8,4,22,9,9,9,23,2,22,24,8,1,4,21,7,9,0,7,9,24,7,6,0,7,21));
//        ArrayList<String> s = new ArrayList<String>(Arrays.asList("basic", "basic", "basic"));
//        System.out.println(s);
//        Round joc = new Round(2, 1, c, s);
//     //   System.out.println(joc.players);
//        joc.Game();
//        System.out.println(joc.players.get(0));
//        System.out.println(joc.players.get(1));
//        System.out.println(joc.players.get(2));
        /////////////////////////////////////////////////////////////
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(9, 8, 22, 23, 5, 5, 20, 4, 22, 5));
        Player g0 = new GreedyPlayer();
        g0.takeCards(a);
        System.out.println(g0);
        g0.buildPocket(1);
        System.out.println(g0);


    }
}
