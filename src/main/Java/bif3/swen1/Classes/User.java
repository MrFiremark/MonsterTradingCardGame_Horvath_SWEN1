package bif3.swen1.Classes;

public class User {

    private String username;
    private String password;
    private int coins;
    private int elo;
    private Card[] stack;
    private Card[] deck;

    public User(String username, String password, int coins, int elo) {
        this.username = username;
        this.password = password;
        this.coins = coins;
        this.elo = elo;
    }

    public void createDeck(){}
    public void editDeck(){}
    public void deleteDeck(){}
}
