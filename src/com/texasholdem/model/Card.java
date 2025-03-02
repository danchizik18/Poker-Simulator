package com.texasholdem.model;

public class Card {

    private int rank;  // Numeric value for the card (2-14)
    private String suit;

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public int getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        String rankString;
        switch (rank) {
            case 11:
                rankString = "J";
                break;
            case 12:
                rankString = "Q";
                break;
            case 13:
                rankString = "K";
                break;
            case 14:
                rankString = "A";
                break;
            default:
                rankString = Integer.toString(rank);
        }
        return rankString + suit.charAt(0);  // ex.) 10H for 10 of hearts
    }
}
