package com.texasholdem;

import java.util.ArrayList;

public class TurnRiver {
    private ArrayList<Card> five;

    public TurnRiver(Card one, Card two, Card three) {
        five = new ArrayList<>();
        five.add(one);
        five.add(two);
        five.add(three);
        Deck deck = new Deck();

        for (int i = 0; i < 2; i++) {
            five.add(deck.drawCard());
        }
    }

    public ArrayList<Card> getFive() {
        return five;
    }



}