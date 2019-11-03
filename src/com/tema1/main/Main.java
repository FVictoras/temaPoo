package com.tema1.main;

import com.tema1.goods.GoodsFactory;

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
//        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(9, 8, 22, 23, 5, 5, 20, 4, 22, 5));
//        Player g0 = new GreedyPlayer();
//        g0.takeCards(a);
//        System.out.println(g0);
//        g0.buildPocket(1);
//        System.out.println(g0);
        //////////////Testing for basic v greedy///////////////////
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(24, 4, 23, 6, 21, 1, 21, 5, 21, 2, 7, 9, 23, 5, 9, 23, 6, 9, 1, 21, 0, 24, 8, 1, 9, 8, 21, 9, 1, 0, 22, 0, 21, 22, 2, 9, 7, 23, 23, 5, 21, 22, 6, 3, 21, 3, 7, 1, 4, 4, 1, 1, 4, 4, 24, 1, 9, 0, 24, 9, 24, 23, 23, 6, 6, 2, 7, 3, 22, 20, 5, 4, 23, 8, 20, 24, 1, 3, 2, 1, 3, 6, 20, 0, 0, 22, 5, 4, 1, 5, 6, 4, 6, 21, 5, 6, 24, 21, 2, 24, 2, 23, 9, 0, 8, 4, 22, 20, 23, 21, 3, 1, 8, 0, 6, 4, 6, 2, 1, 5, 22, 5, 1, 23, 6, 7, 7, 2, 7, 6, 3, 23, 1, 3, 0, 1, 0, 2, 23, 8, 8, 3, 1, 9, 8, 2, 7, 2, 8, 4, 23, 7, 22, 4, 23, 20, 8, 22, 5, 7, 23, 2, 2, 23, 23, 21, 4, 24, 21, 22, 1, 7, 8, 6, 2, 22, 2, 2, 6, 22, 24, 21, 21, 20, 22, 8, 4, 4, 2, 24, 1, 2, 3, 21, 24, 20, 3, 1, 2, 1, 8, 8, 3, 0, 4, 20, 20, 20, 2, 4, 7, 8, 5, 3, 0, 22, 8, 2, 24, 22, 9, 0, 8, 5, 1, 3, 8, 3, 0, 5, 9, 22, 5, 1, 4, 0, 8, 23, 0, 24, 21, 22, 20, 2, 24, 23, 0, 1, 21, 9, 3, 5, 0, 4, 0, 22, 2, 0, 24, 7, 23, 4, 3, 7, 24, 24, 8, 5, 2, 24, 21, 23, 20, 8, 24, 0, 2, 21, 9, 23, 20, 20, 22, 0, 3, 22, 7, 6, 9, 5, 6, 4, 1, 7, 24, 8, 23, 21, 23, 5, 5, 21, 9, 4, 5, 4, 0, 23, 1, 9, 20, 0, 22, 6, 8, 2, 22, 22, 21, 4, 5, 0, 22, 21, 24, 1, 23, 7, 9, 20, 4, 9, 2, 1, 24, 9, 8, 2, 4, 23, 0, 9, 1, 7, 7, 2, 2, 24, 24, 1, 9, 1, 20, 8, 3, 22, 23, 21, 3, 2, 21, 4, 6, 5, 22, 8, 3, 2, 8, 3, 6, 0, 23, 7, 22, 6, 24, 1, 20, 1, 9, 5, 8, 24, 7, 2, 2, 2, 5, 20, 20, 2, 3, 8, 8, 6, 2, 9, 20, 24, 2, 6, 8, 24, 23, 2, 3, 2, 5, 6, 7, 1, 1, 5, 5, 1, 1, 23, 7, 2, 24, 9, 5, 1, 23, 4, 0, 21, 6, 7, 8, 1, 9, 7, 2, 9, 9, 20, 21, 24, 4, 22, 2, 20, 7, 7, 23, 8, 8, 20, 9, 5, 20, 1, 5, 8, 6, 22, 7, 8, 22, 4, 1, 6, 0, 0, 6, 7, 9, 1, 22, 23, 6, 7, 7, 8, 23, 2, 7, 24, 5, 3, 3, 7, 7, 8, 7, 5, 24, 8, 23, 3, 0, 7, 6, 23, 23, 24, 0, 20, 7, 7, 3, 23, 4, 24, 23, 9, 4, 20, 21, 9, 0, 4, 3, 7, 22, 0, 0, 23, 21, 3, 22, 8, 0, 22, 5, 22, 0, 2, 9, 7, 22, 0, 6, 8, 23, 6, 1, 20, 0, 4, 2, 6, 4, 6, 7, 8, 20, 5, 21, 5, 1, 0, 21, 22, 21, 21, 21, 23, 1, 4, 9, 24, 9, 7, 23, 21, 0, 24, 20, 0, 2, 23, 8, 4, 0, 3, 1, 6, 6, 5, 22, 7, 8, 20, 21, 20, 22, 22, 5, 0, 3, 20, 0, 6, 4, 4, 24, 5, 2, 7, 20, 9, 1, 5, 22, 3, 21, 2, 24, 3, 4, 5, 21, 20, 7, 8, 1, 7, 0, 4, 9, 2, 22, 9, 24, 2, 2, 22, 8, 23, 9, 7, 20, 23, 4, 1, 23, 4, 5, 3, 6, 22, 21, 7, 3, 1, 9, 6, 20, 22, 21, 0, 24, 22, 3, 9, 1, 20, 2, 21, 9, 3, 8, 6, 8, 7, 5, 9, 23, 1, 2, 8, 24, 9, 7, 24, 7, 24, 22, 5, 6, 9, 23, 7, 24, 7, 3, 4, 7, 1, 1, 2, 3, 24, 24, 5, 3, 20, 4, 6, 24, 8, 22, 5, 24, 6, 0, 5, 22, 5, 4, 2, 3, 3, 4, 2, 8, 8, 4, 20, 7, 7, 9, 24, 9, 1, 7, 3, 4, 5, 1, 1, 22, 22, 6, 21, 7, 6, 1, 8, 22, 21, 23, 22, 7, 0, 1, 20, 22, 2, 23, 21, 7, 20, 8, 1, 24, 3, 21, 23, 23, 24, 20, 21, 0, 7, 20, 9, 2, 6, 21, 2, 22, 8, 21, 1, 24, 5, 20, 4, 9, 21, 6, 20, 3, 8, 7, 2, 20, 7, 9, 0, 9, 22, 24, 22, 23, 7
        ));
        ArrayList<String> s = new ArrayList<String>(Arrays.asList("greedy", "basic", "basic", "basic", "basic"));
        System.out.println(s);
        Round joc = new Round(2, 1, c, s);
        //   System.out.println(joc.players);
        joc.Game();
        System.out.println(joc.players.get(0));
        System.out.println(joc.players.get(1));
        System.out.println(joc.players.get(2));
        System.out.println(joc.players.get(3));
        System.out.println(joc.players.get(4));
        ///////////////////////////////////////////////////////////


    }

}
