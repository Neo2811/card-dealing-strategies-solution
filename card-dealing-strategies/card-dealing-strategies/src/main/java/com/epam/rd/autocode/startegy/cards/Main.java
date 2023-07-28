package com.epam.rd.autocode.startegy.cards;

import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        final CardDealingStrategy strategy = CardDealingStrategies.texasHoldemCardDealingStrategy();
        testCase(strategy,52,3);


    }
    private static void testCase(final CardDealingStrategy strategy, final int deckSize, final int players) {
        final Deck deck = new DeckImpl(deckSize);
        System.out.println(new TreeMap<>(strategy.dealStacks(deck, players)).toString());
    }
}
