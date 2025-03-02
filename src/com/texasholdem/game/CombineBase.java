package com.texasholdem.game;

import com.texasholdem.model.Card;
import com.texasholdem.model.Hand;
import com.texasholdem.model.HandRank;

import java.util.ArrayList;
import java.util.List;

public abstract class CombineBase {
    protected List<Card> combine;
    protected Hand hand;
    protected List<Card> communityCards;

    public CombineBase(Hand hand, List<Card> communityCards) {
        this.hand = hand;
        this.communityCards = communityCards;
        this.combine = new ArrayList<>(communityCards);
        this.combine.addAll(hand.getCards());
    }

    public abstract HandRank evaluateHand();
}
