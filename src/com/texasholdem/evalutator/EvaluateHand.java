package com.texasholdem.evalutator;

import com.texasholdem.model.Card;
import com.texasholdem.model.HandRank;

import java.util.*;

public class EvaluateHand {

    public static boolean isFlush(List<Card> cards) {
        Map<String, Integer> suitCount = new HashMap<>();
        for (Card card : cards) {
            suitCount.put(card.getSuit(), suitCount.getOrDefault(card.getSuit(), 0) + 1);
        }
        return suitCount.values().stream().anyMatch(count -> count >= 5);
    }

    public static boolean isStraight(List<Card> cards) {
        Set<Integer> uniqueRanks = new HashSet<>();
        for (Card card : cards) {
            uniqueRanks.add(card.getRank());
        }

        List<Integer> sortedRanks = new ArrayList<>(uniqueRanks);
        Collections.sort(sortedRanks);

        if (sortedRanks.size() < 5) return false;

        if (uniqueRanks.contains(14) && uniqueRanks.contains(2) && uniqueRanks.contains(3) && uniqueRanks.contains(4) && uniqueRanks.contains(5)) {
            return true;
        }

        for (int i = 0; i < sortedRanks.size() - 1; i++) {
            if (sortedRanks.get(i + 1) - sortedRanks.get(i) != 1) {
                return false;
            }
        }
        return true;
    }

    public static HandRank evaluateHand(List<Card> cards) {
        if (isFlush(cards)) {
            return HandRank.FLUSH;
        } else if (isStraight(cards)) {
            return HandRank.STRAIGHT;
        } else {
            Map<Integer, Integer> rankCount = new HashMap<>();
            for (Card card : cards) {
                rankCount.put(card.getRank(), rankCount.getOrDefault(card.getRank(), 0) + 1);
            }

            int pairs = 0, trips = 0, quads = 0;
            for (int count : rankCount.values()) {
                if (count == 2) pairs++;
                if (count == 3) trips++;
                if (count == 4) quads++;
            }

            if (quads > 0) return HandRank.QUADS;
            if (trips > 0 && pairs > 0) return HandRank.FULL_HOUSE;
            if (trips > 0) return HandRank.TRIPS;
            if (pairs == 2) return HandRank.TWO_PAIR;
            if (pairs == 1) return HandRank.ONE_PAIR;
            return HandRank.HIGH_CARD;
        }
    }
}
