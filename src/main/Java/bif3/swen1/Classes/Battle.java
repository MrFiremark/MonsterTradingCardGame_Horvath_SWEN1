package bif3.swen1.Classes;

import bif3.swen1.Enum.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Battle {

    private LinkedList<User> contestants;
    private LinkedList<Deck> battleDecks;
    private int turnCounter = 0;
    private int maxTurns = 100;
    private final Random r = new Random();
    private String[] log;

    public User generateBot() throws IOException {
        Collection collection = new Collection();
        collection.loadCollection();
        ArrayList<Card> stack = new ArrayList<>(collection.getAllCards());
        Deck deck = new Deck("DummyDeck", stack);
        deck.addCard(stack.get(0));
        deck.addCard(stack.get(1));
        deck.addCard(stack.get(23));
        deck.addCard(stack.get(24));
        LinkedList<Deck> decks = new LinkedList<>();
        decks.add(deck);

        User bot = new User("Dummy", "", 0, 100, collection.getAllCards(), decks);

        return bot;
    }

    public void getContestants(User user, int deckIndex) throws IOException {
        /*while (contestants.size() < 1){
            contestants.add(user);
            battleDecks.add(user.getBattleDeck(deckIndex));
        }*/

        contestants.add(user);
        battleDecks.add(user.getBattleDeck(deckIndex));

        contestants.add(generateBot());
        battleDecks.add(contestants.get(1).getBattleDeck(0));

        fight();
    }

    public void fight(){

        while ((battleDecks.get(0).getDeckCards().size() > 1 && battleDecks.get(1).getDeckCards().size() > 1) || maxTurns == turnCounter){
            log[turnCounter] = cardBattle(battleDecks.get(0).getDeckCard(r.nextInt(4)), battleDecks.get(1).getDeckCard(r.nextInt(4)));

            turnCounter++;
        }

    }

    public String cardBattle(Card card1, Card card2){

        String turn = "";

        if(card1 instanceof Spell && card2 instanceof Spell){

        }else{

        }

        return turn;
    }

    public void effectiveness(Elements element1, Elements element2){

    }
    public void eloCalc(User won, User lost){}
}
