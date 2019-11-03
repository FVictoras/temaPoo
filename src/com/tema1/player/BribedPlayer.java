package com.tema1.player;

import java.util.ArrayList;

public class BribedPlayer extends Player {

    private ArrayList<Integer> cards;
    private ArrayList<Integer> copycards;
    private int playerID;
    private int totalCost = 0;
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    @Override
    public String toString() {
        return "greedy: cartile: " + getCardsId() + " taraba:" + getTaraba() + " aur:" + super.getScore();
    }

    public void takeCards(ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
        this.copycards = new ArrayList<Integer>(a);
    }

    @Override
    public ArrayList<Integer> getTaraba() {
        return this.taraba;
    }

    @Override
    public void addTaraba(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            this.taraba.add(a.get(i));
        }
    }

    @Override
    public void buildPocket() {
        this.setPocket(BribedPlayerUtils.buildPocket(copycards, this));
        System.out.println("pocketul este:" + this.getPocket() + " are " + this.getBribe() + " monezi MITA si jucatorul are " + this.getScore() + "bani");

    }

    @Override
    public void buildPocket(int n) {

    }

}
