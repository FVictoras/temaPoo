package com.tema1.main;

import java.util.ArrayList;

public class GameInput {
    // DO NOT MODIFY
    private final ArrayList<Integer> mAssetOrder;
    private final ArrayList<String> mPlayersOrder;
    private int mRounds;

    GameInput() {
        mAssetOrder = null;
        mPlayersOrder = null;
        mRounds = -1;
    }

    public GameInput(final int rounds, final ArrayList<Integer> assets, final ArrayList<String> players) {
        mAssetOrder = assets;
        mPlayersOrder = players;
        mRounds = rounds;
    }

    public final ArrayList<Integer> getAssetIds() {
        return mAssetOrder;
    }

    public final ArrayList<String> getPlayerNames() {
        return mPlayersOrder;
    }

    public final int getRounds() {
        return mRounds;
    }

    public final int getTotalPlayers() {
        return mPlayersOrder.size();
    }

    public final boolean isValidInput() {
        boolean membersInstantiated = mAssetOrder != null && mPlayersOrder != null;
        boolean membersNotEmpty = mAssetOrder.size() > 0 && mPlayersOrder.size() > 0 && mRounds > 0;

        return membersInstantiated && membersNotEmpty;
    }
}
