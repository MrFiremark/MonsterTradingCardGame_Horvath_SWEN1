package bif3.swen1.Classes;

import java.util.ArrayList;

public class User {

    private String username;
    private String password;
    private int coins;
    private int elo;
    private ArrayList<Card> stack;
    private ArrayList<Card> deck;

    public User(String username, String password, int coins, int elo, ArrayList<Card> stack, ArrayList<Card> deck) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
        this.stack = stack;
        this.deck = deck;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getElo() {
        return elo;
    }

    public void setElo(int elo) {
        this.elo = elo;
    }

    public ArrayList<Card> getStack() {
        return stack;
    }

    public void setStack(ArrayList<Card> stack) {
        this.stack = stack;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void createDeck(){}
    public void editDeck(){}
    public void deleteDeck(){}
}
