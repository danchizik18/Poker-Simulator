package com.texasholdem;

import com.texasholdem.model.Card;

import java.util.ArrayList;
import java.util.List;

public class FlopTurnRiver {
    private List<Card> flopCards;
    private Card turnCard;
    private Card riverCard;

    // Initialize the flop only
    public FlopTurnRiver(List<Card> flopCards) {
        this.flopCards = flopCards;
    }

    // Add the turn card
    public void addTurnCard(Card turnCard) {
        this.turnCard = turnCard;
    }

    // Add the river card
    public void addRiverCard(Card riverCard) {
        this.riverCard = riverCard;
    }

    // Return flop, turn, and river (all 5 cards)
    public List<Card> getFive() {
        List<Card> fiveCards = new ArrayList<>(flopCards);
        if (turnCard != null) {
            fiveCards.add(turnCard);
        }
        if (riverCard != null) {
            fiveCards.add(riverCard);
        }
        return fiveCards;
    }
}
