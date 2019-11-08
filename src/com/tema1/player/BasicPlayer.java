package com.tema1.player;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicPlayer extends Player {
    private ArrayList<Integer> cards;
    private int totalCost = 0;
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    public BasicPlayer(int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "BASIC " + getScore();
    }

    @Override
    public void takeCards(ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
    }

    public void buildPocket() {
        this.setPocket(BasicPlayerUtils.basicPocket(cards));
        if (this.getPocket().get(0) < 20)
            this.setDeclared(getPocket().get(0));
        else
            this.setDeclared(0);
    }


    public void buildPocket(int n) {
    }

    public int getTotalCost() {
        return this.totalCost;
    }

    public int calculateCost(ArrayList<Integer> a, int declared) {
        int cost = 0;

        if (PlayerUtils.minimumOneIlegal(a) == true) {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) != declared) {
                    if (a.get(i) < 10) {
                        cost = cost + 2;
                    } else {
                        cost = cost + 4;
                    }
                }
            }
        } else {
            for (int i = 0; i < a.size(); i++) {
                if (a.get(i) < 10) {
                    cost = cost - 2;
                } else {
                    cost = cost + 4;
                }
            }
        }
        this.totalCost = this.totalCost + cost;
        return cost;
    }

    public void removeIllegal(ArrayList<Integer> a, int declared) {
        Iterator itr = a.iterator();
        while (itr.hasNext()) {
            int x = (Integer) itr.next();
            if (x > 10 || x != declared)
                itr.remove();
        }
    }

    public void startSheriff(ArrayList<Integer> a, Player b) {
        int c = calculateCost(a, b.getDeclared());
        removeIllegal(a, b.getDeclared());
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


    @Override
    public void addIllegalBonusCard(int n) {
        this.taraba.add(n);
    }

    //public void startSheriff(ArrayList<Integer> a) {System.out.println("playerb");}

}
