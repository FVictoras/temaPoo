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
//        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(21, 21, 22, 23, 24, 24, 21, 22, 23, 21, 23, 20, 22, 23, 22, 20, 24, 21, 21, 24, 20, 24, 23, 24, 21, 21, 24, 23, 20, 20, 22, 22, 22, 22, 21, 20, 24, 24, 20, 23));
//        ArrayList<String> s = new ArrayList<String>(Arrays.asList("greedy", "basic"));
//        System.out.println(s);
//        Round joc = new Round(2, 1, c, s);
//        //   System.out.println(joc.players);
//        joc.Game();
//        System.out.println(joc.players.get(0));
//        System.out.println(joc.players.get(1));
        ///////////////////////////////////////////////////////////

//        ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(21, 22, 22, 3, 5, 7, 3, 8, 5, 2, 4, 7, 9, 1, 2, 0, 0, 0, 3, 4, 23, 24, 21, 20));
//        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(0, 0, 1, 2, 3, 4, 5, 6, 7, 8));
//        Player bribed = new BribedPlayer();
//        // System.out.println(PlayerUtils.sortedbyValueIndexhigh(b));
//        bribed.takeCards(a);
//        bribed.buildPocket();
        //////////////Testing for all///////////////////
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(21, 20, 24, 5, 8, 20, 1, 22, 5, 24, 7, 4, 4, 8, 6, 0, 21, 23, 6, 23, 0, 9, 8, 23, 9, 1, 24, 0, 23, 2, 23, 5, 7, 7, 6, 1, 0, 9, 0, 9, 3, 3, 21, 24, 3, 0, 20, 0, 6, 2, 7, 22, 1, 8, 7, 23, 7, 23, 21, 2, 4, 21, 21, 3, 6, 2, 21, 21, 6, 24, 8, 0, 4, 24, 4, 7, 2, 7, 22, 21, 5, 23, 5, 20, 8, 9, 1, 9, 3, 22, 3, 1, 3, 8, 22, 24, 24, 2, 21, 5, 4, 22, 0, 1, 6, 6, 4, 23, 22, 23, 5, 5, 1, 0, 6, 24, 4, 24, 0, 21, 2, 20, 2, 1, 22, 5, 23, 24, 23, 0, 1, 5, 1, 5, 21, 9, 1, 22, 6, 7, 6, 21, 4, 23, 7, 0, 3, 2, 8, 5, 8, 4, 7, 2, 5, 8, 24, 4, 23, 22, 0, 23, 3, 7, 4, 7, 22, 7, 24, 4, 6, 20, 6, 6, 21, 7, 23, 22, 7, 0, 0, 6, 20, 24, 8, 3, 1, 21, 9, 23, 3, 8, 20, 22, 22, 2, 20, 20, 3, 2, 21, 22, 8, 20, 1, 21, 24, 23, 1, 24, 5, 22, 7, 6, 4, 8, 6, 3, 4, 3, 9, 6, 20, 0, 4, 4, 0, 9, 24, 3, 21, 20, 7, 23, 0, 7, 9, 7, 21, 4
        ));
        ArrayList<String> s = new ArrayList<String>(Arrays.asList("basic", "greedy", "basic"));
        System.out.println(s);
        Round joc = new Round(2, 1, c, s);
        //   System.out.println(joc.players);
        joc.Game();
//        System.out.println(joc.players.get(0));
//        System.out.println(joc.players.get(1));
//        System.out.println(joc.players.get(2));
        ///////////////////////////////////////////////////////////


    }

}
