package com.tema1.player;

import java.util.ArrayList;

public abstract class Player {
    private ArrayList<Integer> CardsId = new ArrayList<Integer>(10);
    private int Score;
    private boolean isSheriff;
    private int declared;
    private int bribe;
    private int playerID;
    private ArrayList<Integer> pocket = new ArrayList<Integer>(8);

    public Player(int id) {
        this.setScore(80);
        this.playerID = id;
    }

    public int getDeclared() {
        return this.declared;
    }

    public int getBribe() {
        return bribe;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setBribe(int bribe) {
        this.bribe = bribe;
    }

    public int compareTo(Player p) {
        int comparescore = ((Player) p).getScore();
        /* For Ascending order*/
        if (comparescore - this.getScore() == 0 && p.getPlayerID() < this.playerID)
            return this.getScore() - comparescore - 1;
        return this.getScore() - comparescore;
        /* For Descending order do like this */
        //return compareage-this.studentage;
    }


    public void setDeclared(int d) {
        this.declared = d;
    }
    public void changeScore(int add) {
        this.setScore(this.getScore() + add);
    }

    public ArrayList<Integer> getCardsId() {
        return this.CardsId;
    }

    public int getScore() {
        return Score;
    }

    public void setCardsId(ArrayList<Integer> cardsId) {
        this.CardsId = cardsId;
    }

    public void setSheriff(boolean mood) {
        this.isSheriff = mood;
    }

    public void setScore(int score) {
        Score = score;
    }

    public boolean isSheriff() {
        return isSheriff;
    }

    public void takeCards(ArrayList<Integer> a) {
        this.setCardsId(a);
    }

    public ArrayList<Integer> getPocket() {
        return this.pocket;
    }

    public void setPocket(ArrayList<Integer> pocket) {
        this.pocket = pocket;
    }

    public void addPocket(int a) {
        this.pocket.add(a);
    }

    public void startSheriff(ArrayList<Integer> a, Player b) {
//        System.out.println("player");
    }

    public abstract ArrayList<Integer> getTaraba();

    public abstract void addTaraba(ArrayList<Integer> a);

    public abstract void addIllegalBonusCard(int n);

    public void arataTotMuistulePachet() {
        System.out.println("id:" + playerID + "am pachetul" + getPocket() + "am banii:" + getScore());
    }

    public void arataTotMuistuleTaraba() {
        System.out.println("id:" + playerID + "am taraba" + getTaraba() + "am banii:" + getScore());
    }

    public abstract void buildPocket();

    public void checkBribe(Player a) {
        if (a.getBribe() > 0) {
            this.setScore(this.getScore() + a.getBribe());
            a.setScore(a.getScore() - a.getBribe());
            a.setBribe(0);
        }
    }

    public abstract void buildPocket(int n);
}
