package com.texasholdem.game;

import com.texasholdem.combine.Combine;
import com.texasholdem.deck.Deck;
import com.texasholdem.model.Card;
import com.texasholdem.model.Hand;
import com.texasholdem.model.HandRank;
import com.texasholdem.FlopTurnRiver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PokerGame {

    public static void main(String[] args) {
        // Create a new deck
        Deck deck = new Deck();
        Scanner scanner = new Scanner(System.in);

        // Player 1's cards
        System.out.println("Enter Player 1's first card (e.g., 2H for Two of Hearts): ");
        String player1Card1 = scanner.nextLine();
        Card playerCard1 = deck.drawCardByNotation(player1Card1);

        System.out.println("Enter Player 1's second card (e.g., 2H for Two of Hearts): ");
        String player1Card2 = scanner.nextLine();
        Card playerCard2 = deck.drawCardByNotation(player1Card2);

        Hand player1Hand = new Hand(playerCard1, playerCard2);

        // Player 2's cards
        System.out.println("Enter Player 2's first card (e.g., 2H for Two of Hearts): ");
        String player2Card1 = scanner.nextLine();
        Card player2Card1Obj = deck.drawCardByNotation(player2Card1);

        System.out.println("Enter Player 2's second card (e.g., 2H for Two of Hearts): ");
        String player2Card2 = scanner.nextLine();
        Card player2Card2Obj = deck.drawCardByNotation(player2Card2);

        Hand player2Hand = new Hand(player2Card1Obj, player2Card2Obj);

        // Draw flop cards
        Card flop1 = deck.drawCard();
        Card flop2 = deck.drawCard();
        Card flop3 = deck.drawCard();
        ArrayList<Card> flopCards = new ArrayList<>();
        flopCards.add(flop1);
        flopCards.add(flop2);
        flopCards.add(flop3);

        FlopTurnRiver flopTurnRiver = new FlopTurnRiver(flopCards);

        // Draw the turn and river cards
        Card turnCard = deck.drawCard();
        flopTurnRiver.addTurnCard(turnCard);

        Card riverCard = deck.drawCard();
        flopTurnRiver.addRiverCard(riverCard);

        // Combine Player 1's hand with the community cards and evaluate
        Combine combinePlayer1 = new Combine(player1Hand, (ArrayList<Card>) flopTurnRiver.getFive());
        HandRank handRankPlayer1 = combinePlayer1.evaluateHand();
        System.out.println("Player 1's Hand Rank: " + handRankPlayer1);

        // Combine Player 2's hand with the community cards and evaluate
        Combine combinePlayer2 = new Combine(player2Hand, (ArrayList<Card>) flopTurnRiver.getFive());
        HandRank handRankPlayer2 = combinePlayer2.evaluateHand();
        System.out.println("Player 2's Hand Rank: " + handRankPlayer2);

        // Determine the winner
        int comparison = handRankPlayer1.compareTo(handRankPlayer2);
        if (comparison > 0) {
            System.out.println("Player 1 wins!");
        } else if (comparison < 0) {
            System.out.println("Player 2 wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}
