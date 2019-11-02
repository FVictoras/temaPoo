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

        /////////////////////////////////////////////////////
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(3,2,2,8,0,7,8,9,0,2,8,2,2,9,9,4,4,8,6,8,3,9,2,5,5,7,5,9,7,8,0,2,2,5,5,6,1,4,5,9,6,2,4,0,1,2,7,4,9,0,7,6,6,8,1,5,6,9,7,2,3,8,3,2,3,2,8,1,3,3,5,7,3,3,1,5,0,2,1,1,9,9,7,6,6,8,2,2,9,9,7,9,3,3,3,2,9,7,1,4,0,2,0,3,7,9,5,1,5,4,6,0,6,1,8,1,5,0,1,3));
        ArrayList<String> s = new ArrayList<String>(Arrays.asList("basic", "basic", "basic"));
        System.out.println(s);
        Round joc = new Round(2, 1, c, s);
     //   System.out.println(joc.players);
        joc.Game();
        System.out.println(joc.players.get(0));
        System.out.println(joc.players.get(1));
        System.out.println(joc.players.get(2));
    }
}
