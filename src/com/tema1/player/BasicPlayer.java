package com.tema1.player;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicPlayer extends Player {
    private ArrayList<Integer> cards;
    private int playerID;
    private int totalCost = 0;
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    public BasicPlayer() {
    }

    public BasicPlayer(ArrayList<Integer> c) {
        super(c);


    }

    @Override
    public String toString() {
        return "cartile: " + getCardsId() + " taraba:" + getTaraba() + " aur:" + getScore();
    }

    @Override
    public void takeCards(ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
    }

    public void buildPocket() {
        this.setPocket(BasicPlayerUtils.basicPocket(cards));
    }

    public void buildPocket(int n) {
    }

    public int getTotalCost() {
        return this.totalCost;
    }

    public int calculateCost(ArrayList<Integer> a) {
        int cost = 0;
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) < 10) {
                cost = cost - 2;
            } else {
                cost = cost + 4;
            }
        }
        this.totalCost = this.totalCost + cost;
        return cost;
    }

    public void removeIllegal(ArrayList<Integer> a) {
        Iterator itr = a.iterator();
        while (itr.hasNext()) {
            int x = (Integer) itr.next();
            if (x > 10)
                itr.remove();
        }
    }

    public void startSheriff(ArrayList<Integer> a, Player b) {
        int c = calculateCost(a);
        removeIllegal(a);
        this.setScore(this.getScore()+c);
        b.setScore(b.getScore()-c);
    }

    public void addTaraba(ArrayList<Integer> a) {
        for (int i = 0; i<a.size(); i++) {
            this.taraba.add(a.get(i));
        }
    }

    public ArrayList<Integer> getTaraba() {
        return this.taraba;
    }


    //public void startSheriff(ArrayList<Integer> a) {System.out.println("playerb");}

}
