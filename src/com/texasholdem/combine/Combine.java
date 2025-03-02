package com.texasholdem.combine;

import com.texasholdem.evalutator.EvaluateHand;
import com.texasholdem.model.Card;
import com.texasholdem.model.Hand;
import com.texasholdem.model.HandRank;

import java.util.*;

public class Combine {
    private ArrayList<Card> combine;
    private Hand hand;
    private ArrayList<Card> communityCards;

    public Combine(Hand hand, ArrayList<Card> communityCards) {
        this.hand = hand;
        this.communityCards = communityCards;
        combine = new ArrayList<>(communityCards);
        combine.addAll(hand.getCards());
    }

    public ArrayList<Card> getCombine() {
        return combine;
    }

    public ArrayList<Integer> getCombinedIntegers() {
        ArrayList<Integer> list = new ArrayList<>();
        for (Card card : combine) {
            list.add(card.getRank());
        }
        return list;
    }

    public Hand getHand() {
        return hand;
    }

    public HandRank evaluateHand() {
        return EvaluateHand.evaluateHand(combine);
    }
}
