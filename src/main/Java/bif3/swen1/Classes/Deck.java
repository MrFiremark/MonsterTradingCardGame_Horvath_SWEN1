package bif3.swen1.Classes;

import java.util.ArrayList;

public class Deck {

    private String deckName;
    private Card[] deckCards = new Card[4];
    private ArrayList<Card> remainingStackCards;

    public Card[] getDeckCards() {
        return deckCards;
    }

    public void setDeckCards(Card[] deckCards) {
        this.deckCards = deckCards;
    }

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public void loadDeck(ArrayList<Card> stack){
    }
    public void addCard(Card card){
        //if (deckCards.length <= 4) {
        int cardCounter = 0;
        for (Card deckCard : deckCards)
            if (deckCard != null)
                cardCounter++;
            deckCards[cardCounter] = card;
        //}else{
         //   System.out.println("The Deck is full!");
        //}
    }
    public void orderCards(){}
    public void deleteCard(){}

    @Override
    public String toString() {
        return "Deck{" +
                "deckName='" + deckName + '\'' +
                '}';
    }
}
