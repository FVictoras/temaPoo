package com.tema1.player;

import com.tema1.common.Constants;

import java.util.ArrayList;

public abstract class Player {
    private ArrayList<Integer> cardsId = new ArrayList<Integer>(Constants.MAX_CARDS);
    private int score;
    private boolean isSheriff;
    private int declared;
    private int bribe;
    private int playerId;
    private ArrayList<Integer> pocket = new ArrayList<Integer>(Constants.MAX_POCKETSIZE);

    public Player(final int id) {
        this.setScore(Constants.START_SCORE);
        this.playerId = id;
    }

    // Ce declara playerul ca ii contine pachetul
    final int getDeclared() {
        return this.declared;
    }

    // Obtine mita
    final int getBribe() {
        return bribe;
    }

    public final int getScore() {
        return score;
    }

    public final int getPlayerId() {
        return playerId;
    }

    // Pocketul este format din cartile date spre verificare
    public final ArrayList<Integer> getPocket() {
        return this.pocket;
    }

    // Table este 'taraba' cu cartile trecute de verificare
    public abstract ArrayList<Integer> getTable();

    final void setBribe(final int bribe) {
        this.bribe = bribe;
    }

    final void setDeclared(final int d) {
        this.declared = d;
    }

    final void setCardsId(final ArrayList<Integer> cardsId) {
        this.cardsId = cardsId;
    }

    public final void setSheriff(final boolean mood) {
        this.isSheriff = mood;
    }

    public final void setScore(final int score) {
        this.score = score;
    }

    final void setPocket(final ArrayList<Integer> pocket) {
        this.pocket = pocket;
    }

    /**
     * Functia face ca fiecare jucator sa traga carti.
     */
    public void takeCards(final ArrayList<Integer> a) {
        this.setCardsId(a);
    }

    // Facuta pentru Collections.sort
    public final int compareTo(final Player p) {
        int comparescore = p.getScore();
        if (comparescore - this.getScore() == 0 && p.getPlayerId() < this.playerId) {
            return this.getScore() - comparescore - 1;
        }
        return this.getScore() - comparescore;
    }

    // functia aduna/scade la scorul curent
    public final void changeScore(final int add) {
        this.setScore(this.getScore() + add);
    }

    // Adauga o carte 'a' la pachetul pentru serif
    final void addPocket(final int a) {
        this.pocket.add(a);
    }

    /**
     * Fiecare player face override in functie de cum implementeaza seriful.
     */
    public void startSheriff(final ArrayList<Integer> a, final Player b) {
    }

    // Adauga la taraba finala
    public abstract void addTable(ArrayList<Integer> a);

    public abstract void addIllegalBonusCard(int n);

    /**
     * Functia primeste jucatorul care-i mita ii este interogata.
     */
    public void checkBribe(final Player a) {
        if (a.getBribe() > 0) {
            this.setScore(this.getScore() + a.getBribe());
            a.setScore(a.getScore() - a.getBribe());
            a.setBribe(0);
        }
    }

    // Construieste PACHET in functie de runda
    public abstract void buildPocket(int n);

    // Construieste PACHET
    public abstract void buildPocket();

}
