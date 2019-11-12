package com.tema1.player;

import com.tema1.common.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public final class BasicPlayer extends Player {
    private ArrayList<Integer> cards;
    private int totalCost = 0;
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    public BasicPlayer(final int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "BASIC " + getScore();
    }

    @Override
    public void takeCards(final ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
    }

    public void buildPocket() {
        this.setPocket(BasicPlayerUtils.basicPocket(cards));
        if (this.getPocket().get(0) < Constants.START_ILLEGAL) {
            this.setDeclared(getPocket().get(0));
        } else {
            this.setDeclared(0);
        }
    }

    public void buildPocket(final int n) {
    }

    private int calculateCost(final ArrayList<Integer> a, final int declared) {
        int cost = 0;
        if (PlayerUtils.minimumOneIlegal(a)) {
            for (Integer integer : a) {
                if (integer != declared) {
                    if (integer < Constants.END_LEGAL) {
                        cost = cost + Constants.PENALTY_LEGAL;
                    } else {
                        cost = cost + Constants.PENALTY_ILLEGAL;
                    }
                }
            }
        } else {
            for (Integer integer : a) {
                if (integer < Constants.END_LEGAL) {
                    cost = cost - Constants.PENALTY_LEGAL;
                } else {
                    cost = cost + Constants.PENALTY_ILLEGAL;
                }
            }
        }
        this.totalCost = this.totalCost + cost;
        return cost;
    }

    private void removeIllegal(final ArrayList<Integer> a, final int declared) {
        Iterator itr = a.iterator();
        while (itr.hasNext()) {
            int x = (Integer) itr.next();
            if (x > Constants.END_LEGAL || x != declared) {
                itr.remove();
            }
        }
    }

    @Override
    public void startSheriff(final ArrayList<Integer> a, final Player b) {
        int c = calculateCost(a, b.getDeclared());
        removeIllegal(a, b.getDeclared());
        this.setScore(this.getScore() + c);
        b.setScore(b.getScore() - c);
    }

    public void addTable(final ArrayList<Integer> a) {
        this.taraba.addAll(a);
    }

    public ArrayList<Integer> getTable() {
        return this.taraba;
    }

    @Override
    public void addIllegalBonusCard(final int n) {
        this.taraba.add(n);
    }

    //public void startSheriff(ArrayList<Integer> a) {System.out.println("playerb");}

}
