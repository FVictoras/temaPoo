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
        ArrayList<Integer> c = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 3, 9, 9, 21, 22, 23, 24, 4, 5, 22, 23, 24, 21));
        ArrayList<String> s = new ArrayList<String>(Arrays.asList("basic", "basic"));
        System.out.println(s);
        Round joc = new Round(2, 1, c, s);
        System.out.println(joc.players);
        joc.Game();
        System.out.println(joc.players);
    }
}
