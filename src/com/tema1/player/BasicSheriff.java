package com.tema1.player;

import com.tema1.goods.GoodsFactory;

import java.util.ArrayList;
import java.util.Iterator;

public class BasicSheriff {
    private int playerID;
    private int totalCost = 0;

    public BasicSheriff (int id) {
        this.playerID=id;
        GoodsFactory goods = GoodsFactory.getInstance();

    }

    public int getTotalCost() {
        return totalCost;
    }

    public int calculateCost(ArrayList<Integer> a) {
        int cost = 0;
        for (int i = 0; i<a.size(); i++) {
            if (a.get(i)<10) {
                cost=cost-2;
            } else {
                cost=cost+4;
            }
        }
        this.totalCost=this.totalCost+cost;
        return cost;
    }

    public void removeIllegal(ArrayList<Integer> a) {
        Iterator itr = a.iterator();
        while (itr.hasNext())
        {
            int x = (Integer)itr.next();
            if (x > 10)
                itr.remove();
        }
    }

    public void startSheriff(ArrayList<Integer> a) {
        int c = calculateCost(a);
        removeIllegal(a);
        System.out.println("Seriful are " + c +" bani dupa verificare");
    }

}
