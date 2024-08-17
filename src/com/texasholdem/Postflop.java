package com.texasholdem;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Collections;

public class Postflop {
    public static void main(String[] args) {
        Hand cards1 = new Hand();

        int rank1 = Integer.parseInt(JOptionPane.showInputDialog("Player 1, What's the rank of your first card?"));
        String suit1 = JOptionPane.showInputDialog("Player 1, What's the suit of your first card?");
        int rank2 = Integer.parseInt(JOptionPane.showInputDialog("Player 1, What's the rank of your second card?"));
        String suit2 = JOptionPane.showInputDialog("Player 1, What's the suit of your second card?");

        Card first = new Card(rank1, suit1);
        Card second = new Card(rank2, suit2);

        cards1.addCard(first);
        cards1.addCard(second);



        Hand cards2 = new Hand();

        int rank3 = Integer.parseInt(JOptionPane.showInputDialog("Player 2, What's the rank of your first card?"));
        String suit3 = JOptionPane.showInputDialog("Player 2, What's the suit of your first card?");
        int rank4 = Integer.parseInt(JOptionPane.showInputDialog("Player 2, What's the rank of your second card?"));
        String suit4 = JOptionPane.showInputDialog("Player 2, What's the suit of your second card?");

        Card first2 = new Card(rank3, suit3);
        Card second2 = new Card(rank4, suit4);

        cards2.addCard(first2);
        cards2.addCard(second2);


        int card1FLop = Integer.parseInt(JOptionPane.showInputDialog("What's the rank of the first card on the flop?"));
        String card1FLopSuit = JOptionPane.showInputDialog("What's the suit of the first card on the flop?");
        int card2FLop = Integer.parseInt(JOptionPane.showInputDialog("What's the rank of second card on the flop?"));
        String card2FLopSuit = JOptionPane.showInputDialog("What's the suit of the second card on the flop?");
        int card3FLop = Integer.parseInt(JOptionPane.showInputDialog("What's the rank third card on the flop?"));
        String card3FLopSuit = JOptionPane.showInputDialog("What's the suit of the third card on the flop?");

        Card firstFlopCard = new Card(card1FLop, card1FLopSuit);
        Card secondFlopCard = new Card(card2FLop, card2FLopSuit);
        Card thirdFlopCard = new Card(card3FLop, card3FLopSuit);

        double player1count = 0.0;
        double player2count = 0.0;
        double tieCount = 0.0;
        int totalCount = 0;
        for (int i = 0; i < 1000; i++) {
            TurnRiver turnRiver = new TurnRiver(firstFlopCard, secondFlopCard, thirdFlopCard);


            CombinePostFlop com1 = new CombinePostFlop(cards1, turnRiver);
            System.out.println("combined 1: " + com1.getCombinedIntegers().toString());
            CombinePostFlop com2 = new CombinePostFlop(cards2, turnRiver);
            System.out.println("combined 2: " + com2.getCombinedIntegers().toString());


            if (contains(turnRiver, first) && contains(turnRiver, second) && contains(turnRiver, first2) && contains(turnRiver, second2)) {
                int compare = compareHands(com1, com2);
                System.out.println(compare);
                if (compare ==1) {
                    player1count++;
                } else if (compare == 2) {
                    player2count++;
                } else {
                    tieCount++;
                }

//                System.out.println(player1count);
                totalCount ++;
            }

        }

        System.out.println("Player 1 odds: " + (player1count/totalCount)*100 + "%");
        System.out.println("Player 2 odds: " + (player2count/totalCount)*100 + "%");
        System.out.println("Chop odds: " + (tieCount/totalCount)*100 + "%");


    }




    public static int compareHands(CombinePostFlop hand1, CombinePostFlop hand2) {
        int strength1 = hand1.Strength();
        int strength2 = hand2.Strength();

        if (strength1 > strength2) {
            return 1;
        } else if (strength2 > strength1) {
            return 2;
        } else {
            ArrayList<Integer> cards1 = hand1.getCombinedIntegers();
            ArrayList<Integer> cards2 = hand2.getCombinedIntegers();

            cards1.sort(Collections.reverseOrder());
            cards2.sort(Collections.reverseOrder());

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
        }    }

    public static boolean contains(TurnRiver river, Card card) {
        ArrayList<Card> list = river.getFive();
        for (int i = 0; i < list.size(); i++) {
            int rank = list.get(i).getRank();
            String suit = list.get(i).getSuit();

            if (rank == card.getRank() && suit.equals(card.getSuit())) return false;
        }
        return true;
    }

}