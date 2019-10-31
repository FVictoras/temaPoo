package com.tema1.main;

import com.tema1.goods.GoodsFactory;
import com.tema1.player.BasicPlayer;

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
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(21,22,23,24,21,22,22,23,24,21));
        BasicPlayer b0 = new BasicPlayer(a);
        System.out.println(b0);
        b0.buildPocket();
        System.out.println(b0);
        System.out.println(b0.getPocket());
        System.out.println("Salut");
        System.out.println("Salut2");
    }
}
