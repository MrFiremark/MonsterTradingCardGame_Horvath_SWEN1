package bif3.swen1.Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class User {

    private String username;
    private String password;
    private int coins;
    private int elo;
    private ArrayList<Card> stack;
    private Deck[] decks;

    public User(String username, String password, int coins, int elo, ArrayList<Card> stack, Deck[] decks) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
        this.stack = stack;
        this.decks = decks;
    }

    public String getUsername() {
        return username;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public ArrayList<Card> getStack() {
        return stack;
    }

    public void setStack(ArrayList<Card> stack) {
        this.stack.addAll(stack);
    }

    public Deck[] getDecks() {
        return decks;
    }

    public void setDecks(Deck[] decks) {
        this.decks = decks;
    }

    public void createDeck(int arrayIndexCounter){
        Deck newDeck = new Deck();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How do you want to name this Deck?:");
        newDeck.setDeckName(scanner.next());
        System.out.println("You have following Cards:");
        for(int i=0;i<=stack.size()-1;i++){
            System.out.println("\t" + (i+1) + " - " +stack.get(i).toString());
        }
        System.out.println("Witch card do you want to add to your Deck? (Choose 4 numbers listed above):");
        for (int i=0; i<=3;i++){
            newDeck.addCard(stack.get(scanner.nextInt()-1));
        }
        System.out.println("You created the Deck " + newDeck.getDeckName() + " with following Cards:");
        //for (int i=0; i<=3;i++){
            System.out.println("\t" + Arrays.toString(newDeck.getDeckCards()));
        //}
        this.decks[arrayIndexCounter] = newDeck;
    }
    public void editDeck(){}
    public void deleteDeck(){}
}
