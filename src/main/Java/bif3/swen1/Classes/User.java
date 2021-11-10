package bif3.swen1.Classes;

import java.util.*;

public class User {

    private final String username;
    private final String password;
    private int coins;
    private int elo;
    private  ArrayList<Card> stack;
    private final LinkedList<Deck> decks;

    public User(String username, String password, int coins, int elo, ArrayList<Card> stack, LinkedList<Deck> decks) {
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

    public LinkedList<Deck> getDecks() {
        return decks;
    }

    public void createDeck(){
        int[] cardChoice = new int[4];
        int cardNumber;
        Scanner scanner = new Scanner(System.in);
        System.out.println("How do you want to name this Deck?:");

        Deck newDeck = new Deck(scanner.next(), stack);

        System.out.println("You have following Cards:");
        for(int i=0;i<=stack.size()-1;i++){
            System.out.println("\t" + (i+1) + " - " + stack.get(i).toString());
        }
        System.out.println("Witch card do you want to add to your Deck? (Choose 4 numbers listed above):");
        while (newDeck.getDeckCards().size() < 4){
            cardNumber = scanner.nextInt();
            if (cardNumber < stack.size()){
                newDeck.addCard(stack.get(cardNumber-1));
            }else {
                System.out.println("Number invalid");
            }
        }
        System.out.println("You created the Deck " + newDeck.getDeckName() + " with following Cards:");
        for (int i=0; i<=newDeck.getDeckCards().size()-1;i++){
            System.out.println("\t" + (i+1) + " - " + newDeck.getDeckCards().get(i).toString());
        }

        this.decks.add(newDeck);
    }
    public void editDeck(int index){
        Scanner scanner = new Scanner(System.in);
        int deckindex;

        System.out.println("You have this Cards in your Deck:");
        for (int i=0; i<=decks.get(index).getDeckCards().size()-1;i++){
            System.out.println("\t" + (i+1) + " - " + decks.get(index).getDeckCards().get(i).toString());
        }
        System.out.println("Which Card do you want to replace? (choose a number listed above):");

        deckindex = scanner.nextInt();

        System.out.println("So you want to replace" + decks.get(index).getDeckCards().get(deckindex).toString() +"?");
        System.out.println("With what Card do you want to replace it with?:");
        for(int i=0;i<=stack.size()-1;i++){
            System.out.println("\t" + (i+1) + " - " + stack.get(i).toString());
        }
        System.out.println("Choose a number listed above:");

        decks.get(index).swapCards(deckindex, stack.get(scanner.nextInt()-1));

        System.out.println("Your new Deck is:");
        for (int i=0; i<=decks.get(index).getDeckCards().size()-1;i++){
            System.out.println("\t" + (i+1) + " - " + decks.get(index).getDeckCards().get(i).toString());
        }
    }
    public void deleteDeck(int index){
        if (index < decks.size()){
            decks.remove(index);
        }else {
            System.out.println("Wrong Index!");
        }
    }
}
