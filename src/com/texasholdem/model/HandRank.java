package com.texasholdem.model;

public enum HandRank {
    HIGH_CARD(1),
    ONE_PAIR(2),
    TWO_PAIR(3),
    TRIPS(4), // This is Trips
    STRAIGHT(5),
    FLUSH(6),
    FULL_HOUSE(7),
    QUADS(8), // This is Quads
    STRAIGHT_FLUSH(9),
    ROYAL_FLUSH(10);

    private final int value;

    HandRank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
