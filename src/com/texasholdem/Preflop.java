package com.texasholdem;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Collections;

public class Preflop {
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


        double player1count = 0.0;
        double player2count = 0.0;
        double tieCount = 0.0;
        int totalCount = 0;
        int countError = 0;
        for (int i = 0; i < 1712304; i++) {
            FlopTurnRiver river = new FlopTurnRiver();

            Combine com1 = new Combine(cards1, river);
            Combine com2 = new Combine(cards2, river);

            if (contains(river, first) && contains(river, second) && contains(river, first2) && contains(river, second2)) {

                int compare = compareHands(com1, com2);
                if (compare == 1) {
//                    System.out.println("Player 1 wins");
                    player1count++;
                } else if (compare == 2) {
//                    System.out.println("Player 2 wins");
                    player2count++;
                } else {
//                    System.out.println("We chop here");
                    tieCount++;
                }
                totalCount++;
            } else {
                countError++;
            }
        }

        System.out.println("Player 1 odds: " + (player1count/totalCount)*100 + "%");
        System.out.println("Player 2 odds: " + (player2count/totalCount)*100 + "%");
        System.out.println("Chop odds: " + (tieCount/totalCount)*100 + "%");
//        System.out.println("error: " + countError);


    }



    public static int compareHands(Combine hand1, Combine hand2) {
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

//            System.out.println(cards1.toString());
//            System.out.println(cards2.toString());


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

    public static boolean contains(FlopTurnRiver river, Card card) {
        ArrayList<Card> list = river.getFive();
        for (int i = 0; i < list.size(); i++) {
            int rank = list.get(i).getRank();
            String suit = list.get(i).getSuit();

            if (rank == card.getRank() && suit.equals(card.getSuit())) return false;
        }
        return true;
    }




}
