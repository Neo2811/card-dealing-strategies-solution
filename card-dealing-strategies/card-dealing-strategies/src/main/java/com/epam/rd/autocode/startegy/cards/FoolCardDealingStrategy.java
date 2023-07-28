package com.epam.rd.autocode.startegy.cards;

import java.util.*;

public class FoolCardDealingStrategy implements CardDealingStrategy {

    @Override
    public Map<String, List<Card>> dealStacks(Deck deck, int players) {
        Map<String, List<Card>> stacks = new HashMap<>();
        for (int i = 1; i <= players; i++) {
            stacks.put("Player " + i, dealCards(deck, 1));
        }

        stacks = new TreeMap<>(stacks);

        for (int i = 0; i < 5; i++) {
            for (Map.Entry<String, List<Card>> entry : stacks.entrySet()) {
                entry.getValue().add(deck.dealCard());
            }
        }

        stacks.put("Trump card", dealCards(deck, 1));
        stacks.put("Remaining", deck.restCards());

        return stacks;
    }

    private List<Card> dealCards(Deck deck, int count) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Card card = deck.dealCard();
            if (card != null) {
                cards.add(card);
            }
        }
        return cards;
    }
}

