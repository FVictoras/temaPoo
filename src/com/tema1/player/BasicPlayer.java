package com.tema1.player;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicPlayer extends Player {
    private ArrayList<Integer> cards;
    private int playerID;
    private int totalCost = 0;

    public BasicPlayer() {
    }

    public BasicPlayer(ArrayList<Integer> c) {
        super(c);


    }

    @Override
    public String toString() {
        return "Basic Player are cartile: " + this.getCardsId() + " si este " + isSheriff() + " si are " + getScore() +
                " aur";
    }

    @Override
    public void takeCards(ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
    }

    public void buildPocket() {
        this.setPocket(BasicPlayerUtils.basicPocket(cards));
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

    public void startSheriff(ArrayList<Integer> a) {
        int c = calculateCost(a);
        removeIllegal(a);
        System.out.println("Seriful are " + c + " bani dupa verificare");
    }

    //public void startSheriff(ArrayList<Integer> a) {System.out.println("playerb");}

}
