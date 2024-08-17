//package com.texasholdem;
//
//import java.util.ArrayList;
//
//public class Main {
//    public static void main(String[] args) {
//        Deck deck = new Deck();
//        Hand playerHand = new Hand();
//        Hand communityCards = new Hand();
//
//        playerHand.addCard(deck.drawCard());
//        playerHand.addCard(deck.drawCard());
//
//        for (int i = 0; i < 5; i++) {
//            communityCards.addCard(deck.drawCard());
//        }
//
//        System.out.println("Player's Hand: " + playerHand);
//        System.out.println("Community Cards: " + communityCards);
//
//        String handRank = PokerHandEvaluator.evaluateHand(playerHand.getCards());
//        System.out.println("Player's Hand Rank: " + handRank);
//
//        OddsCalculator.calculateOdds(playerHand.getCards(), communityCards.getCards());
//    }
//}
