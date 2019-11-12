package com.tema1.player;

import com.tema1.common.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public final class GreedyPlayer extends Player {
    private int totalCost = 0;
    private ArrayList<Integer> cards = new ArrayList<Integer>();
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    public GreedyPlayer(final int id) {
        super(id);
    }

    public ArrayList<Integer> getTable() {
        return this.taraba;
    }

    @Override
    public String toString() {
        return "GREEDY " + super.getScore();
    }

    @Override
    public void takeCards(final ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
    }

    public void addTable(final ArrayList<Integer> a) {
        this.taraba.addAll(a);
    }

    @Override
    public void startSheriff(final ArrayList<Integer> a, final Player b) {
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

    public void buildPocket() {
        super.setPocket(BasicPlayerUtils.basicPocket(cards));
        if (this.getPocket().get(0) < Constants.START_ILLEGAL) {
            this.setDeclared(getPocket().get(0));
        } else {
            this.setDeclared(0);
        }
    }

    public void buildPocket(final int n) {
        super.setPocket(BasicPlayerUtils.basicPocket(cards));
        if (n % 2 == 1) {
            this.buildPocket();
        } else {
            this.buildPocket();
            PlayerUtils.removeCard(this.cards, this.getPocket());
            if (PlayerUtils.minimumOneIlegal(this.cards)) {
                super.addPocket(PlayerUtils.mostValuableIllegal(this.cards));
            }
        }
        if (this.getPocket().get(0) < Constants.START_ILLEGAL) {
            this.setDeclared(getPocket().get(0));
        } else {
            this.setDeclared(0);
        }
    }

    @Override
    public void addIllegalBonusCard(final int n) {
        this.taraba.add(n);
    }
}
