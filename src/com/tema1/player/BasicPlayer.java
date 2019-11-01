package com.tema1.player;

import java.util.ArrayList;

public class BasicPlayer extends Player {
    private ArrayList<Integer> cards;
    public BasicPlayer(ArrayList<Integer> c) {
        super(c);
        this.cards = new ArrayList<Integer>(c);

    }

    @Override
    public String toString() {
        return "Basic Player are cartile: " + this.getCardsId() + " si este " + isSheriff() + " si are " + getScore() +
                " aur";
    }

    @Override
    public void takeCards(ArrayList<Integer> a) {
        this.cards = a;
    }


    public void buildPocket() {
        this.setPocket(BasicPlayerUtils.basicPocket(cards));
    }

}
