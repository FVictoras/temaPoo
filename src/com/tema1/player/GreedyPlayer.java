package com.tema1.player;

import java.util.ArrayList;

public class GreedyPlayer extends Player {

    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    @Override
    public String toString() {
        return "greedy: cartile: " + getCardsId() + " taraba:" + getTaraba() + " aur:" + super.getScore()
                + "pachet:" + getPocket();
    }

    public void takeCards(ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
    }

    public ArrayList<Integer> getTaraba() {
        return this.taraba;
    }

    public void addTaraba(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            this.taraba.add(a.get(i));
        }
    }

    public void buildPocket() {
        super.setPocket(BasicPlayerUtils.basicPocket(cards));
    }

    public void buildPocket(int n) {
        super.setPocket(BasicPlayerUtils.basicPocket(cards));
        if (n % 2 == 1) {
            this.buildPocket();
        } else {
            this.buildPocket();
            if (PlayerUtils.minimumOneIlegal(this.cards)) {
                super.addPocket(PlayerUtils.mostValuableIllegal(this.cards));
            }
        }
    }

}
