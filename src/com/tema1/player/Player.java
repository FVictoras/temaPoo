package com.tema1.player;

import java.util.ArrayList;

public abstract class Player {
    private ArrayList<Integer> CardsId = new ArrayList<Integer>(10);
    private int Score;
    private boolean isSheriff;
    private ArrayList<Integer> pocket = new ArrayList<Integer>(8);

    public Player() {
        this.setScore(80);
    }

    public Player(ArrayList<Integer> arr) {
        this.setCardsId(arr);
        this.setScore(80);
        this.setSheriff(false);
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
        System.out.println("player");
    }

    public abstract ArrayList<Integer> getTaraba();

    public abstract void addTaraba(ArrayList<Integer> a);

    public abstract void buildPocket();

    public abstract void buildPocket(int n);
}
