package bif3.swen1.Classes;
import java.io.IOException;
import java.util.*;

public class GameManager {

    private User managingUser;
    private Marketplace marketplace = new Marketplace();
    private final Scanner inputHandler = new Scanner(System.in);

    public void register(String username, String password) throws IOException {
        ArrayList<Card> stack = new ArrayList<>();
        LinkedList<Deck> decks = new LinkedList<>();
        this.managingUser = new User(username, password, 20, 100, stack, decks);
        System.out.println("I will remember it...");
        System.out.println("You are now one of the Messiah, use your power wisely to save our world.");
        profilePage();
        //TODO: SQL-Insert into User_DB
        //TEMP: save credentials in csv
    }
    public void login(String username, String password){
        //TODO: SQL-Select from User_DB
    }

    public void battle(){

    }

    public void buyPack() throws IOException {
        if(managingUser.getCoins() >= 5){
            ArrayList<Card> stack = new ArrayList<>();
            Collections.addAll(stack, marketplace.getPack(managingUser));
            managingUser.setStack(stack);
            managingUser.setCoins(managingUser.getCoins() - marketplace.getPackCost()); // Coins im marketplace abwickeln
        }else {
            System.out.println("You don't have enough Mage Coins!");
        }
        profilePage();
    }

    public void manageDecks() throws IOException {

        String input;

        if(managingUser.getDecks().size() < 1){
            System.out.println("You currently have no Decks:");
            System.out.println("You have to create a Deck to continue.");
            managingUser.createDeck();
            profilePage();
        }else{
            System.out.println("You have the following Decks (max 5 allowed):");

            System.out.println(managingUser.getDecks().toString());

            System.out.println("How do you want to manage your Decks?:");
            System.out.println("Create a new deck (C/c)");
            System.out.println("Edit one of your Decks (E/e and the Decknumber listed above)");
            System.out.println("Delete a Deck (D/d and the Decknumber listed above)");
            System.out.println("Go back (Q/q)");

            input = inputHandler.next().toLowerCase(Locale.ROOT);

            if (input.equals("c")) {
                if (managingUser.getDecks().size() >= 5){
                    System.out.println("You already have 5 Decks! Delete one before you create a new one!");
                    manageDecks(); //Funktion ruft sich selbst auf, muss angepasst werden
                }else {
                    managingUser.createDeck();
                    profilePage();
                }
            }
            else if (input.matches("e[1-5]{1}")) {
                managingUser.editDeck(Integer.parseInt(input.substring(1))-1);
                profilePage();
            }
            else if (input.matches("d[1-5]{1}")) {
                managingUser.deleteDeck(Integer.parseInt(input.substring(1))-1);
                profilePage();
            }
            else if (input.equals("q")) {
                profilePage();
            }
            else {
                System.out.println("ungültige Eingabe");
                manageDecks();
            }

        }
    }
    public void seeScoreboard(){}
    public void editProfile(){}

    public void profilePage() throws IOException {
        boolean quit = false;
        System.out.println("\nHello " + managingUser.getUsername() + ". You have "+ managingUser.getCoins() + " Magic Coins and " + managingUser.getStack().size() + " total Cards.\n" +
                "How can I help you today?");
        System.out.println("BATTLE to save the world! (B/b)"); //battle()
        System.out.println("Open a portal to the Marketplace (M/m)"); // trade()
        System.out.println("Buy new POWERS (Cost: 5 Magic Coins) (P/p)"); // buyPack()
        System.out.println("Manage your BattleDECKS (D/d)"); // manageDeck()
        System.out.println("SEE the list of all Messiah (S/s)"); // seeScoreboard()
        System.out.println("Go to sleep (Q/q)"); // quit()
        System.out.println("What to you want to do?:");
        String input = inputHandler.next().toLowerCase(Locale.ROOT);
            switch (input) {
                case "b":
                    battle();
                case "p":
                    buyPack();
                case "d":
                    manageDecks();
                case "s":
                    seeScoreboard();
                case "q":
                    System.out.println("Farewell " + managingUser.getUsername() + "! Please continue to be our Mesiah!");
                    inputHandler.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid Input!");
            }
    }
}
