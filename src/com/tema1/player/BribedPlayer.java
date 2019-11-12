package com.tema1.player;

import com.tema1.common.Constants;

import java.util.ArrayList;
import java.util.Iterator;

public final class BribedPlayer extends Player {

    private ArrayList<Integer> cards;
    private ArrayList<Integer> copycards;
    private int totalCost = 0;
    private ArrayList<Integer> taraba = new ArrayList<Integer>();

    public BribedPlayer(final int id) {
        super(id);
    }

    @Override
    public String toString() {
        return "BRIBED " + super.getScore();
    }

    public void takeCards(final ArrayList<Integer> a) {
        super.setCardsId(a);
        this.cards = new ArrayList<Integer>(a);
        this.copycards = new ArrayList<Integer>(a);
    }

    @Override
    public ArrayList<Integer> getTable() {
        return this.taraba;
    }

    @Override
    public void addTable(final ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            this.taraba.add(a.get(i));
        }
    }

    @Override
    public void startSheriff(final ArrayList<Integer> a, final Player b) {
        int c = calculateCost(a, b.getDeclared());
        removeIllegal(a, b.getDeclared());
        this.setScore(this.getScore() + c);
        b.setScore(b.getScore() - c);
    }

    public int calculateCost(final ArrayList<Integer> a, final int declared) {
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
    public void checkBribe(final Player a) {
        if (a.getBribe() > 0) {
            this.setScore(this.getScore() + a.getBribe());
            a.setScore(a.getScore() - a.getBribe());
            a.setBribe(0);
        }
    }

    @Override
    public void buildPocket(final int n) {
    }

    @Override
    public void buildPocket() {
        this.setPocket(BribedPlayerUtils.buildPocket(copycards, this));
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
