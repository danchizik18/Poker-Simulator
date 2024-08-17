package com.texasholdem;

import java.util.ArrayList;
import java.util.Collections;

public class Tester {
    public static void main(String[] args) {
        Hand hand = new Hand();
        Card c1 = new Card(4, "Clubs");
        Card c2 = new Card(2, "Spades");
        hand.addCard(c1);
        hand.addCard(c2);



        Hand hand2 = new Hand();
        Card c3 = new Card(4, "Hearts");
        Card c4 = new Card(2, "Diamonds");
        hand2.addCard(c3);
        hand2.addCard(c4);



        Card flop1 = new Card(5, "Diamonds");
        Card flop2 = new Card(7, "Spades");
        Card flop3 = new Card(3, "Hearts");
        TurnRiver set = new TurnRiver(flop1, flop2, flop3);

        CombinePostFlop com = new CombinePostFlop(hand, set);
        CombinePostFlop com2 = new CombinePostFlop(hand2, set);
        ArrayList<Integer> intVals = com.getCombinedIntegers();
        ArrayList<Integer> intVals2 = com2.getCombinedIntegers();

//        System.out.println("first player combo: " + intVals.toString());
//        System.out.println("second player combo: " + intVals2.toString());



//        System.out.println("first player hand: " + com.pairTripsHigh());
//        System.out.println("second player hand: " + com2.pairTripsHigh());

        System.out.println("Player " + compareHands(com, com2) + " wins");
//        System.out.println(com.Strength());
    }


    public static int compareHands(CombinePostFlop hand1, CombinePostFlop hand2) {
        int strength1 = hand1.Strength();
        System.out.println("Strength1: " + strength1);
        int strength2 = hand2.Strength();
        System.out.println("Strength2: " + strength2);


        if (strength1 > strength2) {
            return 1;
        } else if (strength2 > strength1) {
            return 2;
        } else {
            System.out.println("tie");
            ArrayList<Integer> cards1 = hand1.getCombinedIntegers();
            ArrayList<Integer> cards2 = hand2.getCombinedIntegers();

            cards1.sort(Collections.reverseOrder());
            cards2.sort(Collections.reverseOrder());

            System.out.println(cards1.toString());
            System.out.println(cards2.toString());


            for (int i = 0; i < cards1.size()-2; i++) {
                int card1 = cards1.get(i);
                int card2 = cards2.get(i);
                if (card1 > card2) {
                    return 1;
                } else if (card2 > card1) {
                    return 2;
                }
            }
            return 0; // If all cards are equal
        }
    }
}
