package bif3.swen1.Classes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Deck {

    private String deckName;
    private final int deckSize = 4;
    private final LinkedList<Card> deckCards = new LinkedList<>();
    private ArrayList<Card> remainingStackCards;

    public Deck(String deckName, ArrayList<Card> remainingStackCards) {
        this.deckName = deckName;
        this.remainingStackCards = new ArrayList<>(remainingStackCards);
    }

    public LinkedList<Card> getDeckCards() {
        return deckCards;
    }

    public String getDeckName() {
        return deckName;
    }

    public Card getDeckCard(int index){return deckCards.get(index); }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public void addCard(Card card){
        if(deckCards.size() < deckSize && remainingStackCards.contains(card)){
            deckCards.add(card);
            remainingStackCards.remove(card);
        }
        else{
            System.out.println("Card is already in your Deck!!");
        }
    }

    public void swapCards(int index, Card card){
        if(index < deckCards.size() && remainingStackCards.contains(card)){
            remainingStackCards.add(deckCards.get(index));
            deckCards.set(index, card);
            remainingStackCards.remove(card);
        }else{
            System.out.println("Card does not exist!");
        }
    }

    public void deleteCard(Card card){
        if(deckCards.size() > 0 && deckCards.contains(card)){
            deckCards.remove(card);
            remainingStackCards.add(card);
        }else if (deckCards.size() == 0){
            System.out.println("Deck is empty!");
        }else {
            System.out.println("Card does not exist in your Deck!");
        }
    }

    @Override
    public String toString() {
        return "Deck{" +
                "deckName='" + deckName + '\'' +
                '}';
    }
}
