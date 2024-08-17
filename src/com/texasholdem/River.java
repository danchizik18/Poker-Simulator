package com.texasholdem;

import java.util.ArrayList;

public class River {
    private ArrayList<Card> five;

    public River(Card one, Card two, Card three, Card four) {
        five = new ArrayList<>();
        five.add(one);
        five.add(two);
        five.add(three);
        five.add(four);
        Deck deck = new Deck();

        for (int i = 0; i < 1; i++) {
            five.add(deck.drawCard());
        }
    }

    public ArrayList<Card> getFive() {
        return five;
    }



}