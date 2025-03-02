package com.texasholdem.deck;

import com.texasholdem.model.Card;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Deck {

    private List<Card> deck;

    public Deck() {
        // Initialize deck with all 52 cards
        deck = new ArrayList<>();
        String[] suits = {"H", "C", "D", "S"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        // Create all cards
        for (String suit : suits) {
            for (String rank : ranks) {
                int rankValue = convertRankToInt(rank);  // Convert rank to integer
                deck.add(new Card(rankValue, suit));  // Add card to deck
            }
        }

        // Shuffle the deck when it is created
        shuffle();
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    // Draw a card from the deck (removes the card from the deck and returns it)
    public Card drawCard() {
        if (deck.isEmpty()) {
            throw new IllegalStateException("The deck is empty, no cards to draw.");
        }
        return deck.remove(deck.size() - 1); // Removes the last card and returns it
    }

    public Card drawCardByNotation(String cardNotation) {
        String rankNotation = cardNotation.substring(0, cardNotation.length() - 1);
        String suitNotation = cardNotation.substring(cardNotation.length() - 1);

        int rank = convertRankToInt(rankNotation);

        return new Card(rank, suitNotation);
    }

    private int convertRankToInt(String rankNotation) {
        switch (rankNotation) {
            case "2": return 2;
            case "3": return 3;
            case "4": return 4;
            case "5": return 5;
            case "6": return 6;
            case "7": return 7;
            case "8": return 8;
            case "9": return 9;
            case "10": return 10;
            case "J": return 11;
            case "Q": return 12;
            case "K": return 13;
            case "A": return 14;
            default: throw new IllegalArgumentException("Invalid rank notation: " + rankNotation);
        }
    }

    public int getSize() {
        return deck.size();
    }
}
