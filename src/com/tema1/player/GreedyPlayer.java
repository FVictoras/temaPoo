package com.tema1.player;

import java.util.ArrayList;
import java.util.Iterator;

public class GreedyPlayer extends Player {
    private int totalCost = 0;
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    @Override
    public String toString() {
        return "greedy: " + " taraba:" + getTaraba() + " aur:" + super.getScore();
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
        if (this.getPocket().get(0) < 20)
            this.setDeclared(getPocket().get(0));
        else
            this.setDeclared(0);
    }

    public void startSheriff(ArrayList<Integer> a, Player b) {
        if (b.getBribe() > 0) {
            b.setScore(b.getScore() - b.getBribe());
            this.setScore(this.getScore() + b.getBribe());
        } else {
            int c = calculateCost(a, b.getDeclared());
            removeIllegal(a, b.getDeclared());
            this.setScore(this.getScore() + c);
            b.setScore(b.getScore() - c);
        }
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
        if (this.getPocket().get(0) < 20)
            this.setDeclared(getPocket().get(0));
        else
            this.setDeclared(0);
    }

}
