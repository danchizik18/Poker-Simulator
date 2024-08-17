package com.texasholdem;

import java.util.ArrayList;

public class FlopTurnRiver {
        private ArrayList<Card> five;

        public FlopTurnRiver() {
            five = new ArrayList<>();
            Deck deck = new Deck();

            for (int i = 0; i < 5; i++) {
                five.add(deck.drawCard());
            }
        }

        public ArrayList<Card> getFive() {
            return five;
        }




}
