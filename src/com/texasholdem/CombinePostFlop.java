package com.texasholdem;

import java.util.*;

public class CombinePostFlop {

    private ArrayList<Card> combine;

    private Hand hand;
    private TurnRiver turnRiver;
    public CombinePostFlop(Hand hand, TurnRiver turnRiver) {

        this.hand = hand;
        this.turnRiver = turnRiver;
        combine = new ArrayList<>();


        for (int i = 0; i < 5; i++) {
            combine.add(turnRiver.getFive().get(i));
        }

        combine.add(hand.getCards().get(0));
        combine.add(hand.getCards().get(1));
    }

    public ArrayList<Card> getCombine() {
        return combine;
    }

    public ArrayList<Integer> getCombinedIntegers() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < combine.size(); i++) {
            int val = combine.get(i).getRank();
            list.add(val);
        }
        return list;
    }

    public Hand getHand() {
        return hand;
    }

    public int Strength() {
        if (pairTripsHigh().equals("Quads")) {
            return 8;
        } else if (pairTripsHigh().equals("Full House")) {
            return 7;
        } else if (flush()) {
            return 6;
        } else if (straight()) {
            return 5;
        } else if (pairTripsHigh().equals("Trips")) {
            return 4;
        } else if (pairTripsHigh().equals("Two Pairs")) {
            return 3;
        } else if (pairTripsHigh().equals("One Pair")) {
            return 2;
        } else {
            return 1;
        }


    }



    public String pairTripsHigh() {
        Map<Integer, Integer> rankCount = new HashMap<>();

        for (Card card : combine) {
            rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
        }

        int pairs = 0;
        int trips = 0;
        boolean quads = false;

        for (int count : rankCount.values()) {
            if (count == 2) {
                pairs++;
            } else if (count == 3) {
                trips++;
            } else if (count == 4) {
                quads = true;
            }
        }


        if (quads) {
            return "Quads";
        } else if (trips > 0 && pairs > 0) {
            return "Full House";
        } else if (trips > 0) {
            return "Trips";
        } else if (pairs == 2) {
            return "Two Pairs";
        } else if (pairs == 1) {
            return "One Pair";
        } else {
            return "High Card";
        }
    }




    public boolean flush() {
        Map<String, Integer> suitCount = new HashMap<>();
        for (Card card : combine) {
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }
        for (int count : suitCount.values()) {
            if (count >= 5) return true;
        }
        return false;
    }




    public boolean straight() {
        Set<Integer> uniqueRanks = new HashSet<>();
        for (Card card : combine) {
            uniqueRanks.add(card.getRank());
        }

        List<Integer> sortedRanks = new ArrayList<>(uniqueRanks);
        Collections.sort(sortedRanks);

        int consecutive = 0;
        for (int i = 0; i < sortedRanks.size() - 1; i++) {
            if (sortedRanks.get(i + 1) - sortedRanks.get(i) == 1) {
                consecutive++;
                if (consecutive == 4) return true;
            } else {
                consecutive = 0;
            }
        }

        // Check for the low-Ace straight (A-2-3-4-5)
        return uniqueRanks.contains(14) && uniqueRanks.contains(2) && uniqueRanks.contains(3) && uniqueRanks.contains(4) && uniqueRanks.contains(5);
    }








}