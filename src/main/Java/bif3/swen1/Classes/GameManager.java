package bif3.swen1.Classes;
import java.io.IOException;
import java.util.*;

public class GameManager {

    private User managingUser;
    private final Scanner inputHandler = new Scanner(System.in);

    public void register(String username, String password) throws IOException {
        ArrayList<Card> stack = new ArrayList<>();
        Deck[] decks = new Deck[5];
        this.managingUser = new User(username, password, 20, 100, stack, decks);
        System.out.println("I will remember it...");
        System.out.println("You are now one of the Mesiah, use your power wisely to save our world.");
        profilePage();
        //TODO: SQL-Insert into User_DB
        //TEMP: save credentials in csv
    }
    public void login(String username, String password){
        //TODO: SQL-Select from User_DB
    }

    public void battle(){}

    public void buyPack() throws IOException {
        if(managingUser.getCoins() >= 5){
            Marketplace marketplace = new Marketplace();
            ArrayList<Card> stack = new ArrayList<>();
            Collections.addAll(stack, marketplace.getPack());
            managingUser.setStack(stack);
            managingUser.setCoins(managingUser.getCoins() - marketplace.getPackCost());
            profilePage();
        }else {
            System.out.println("You don't have enough Mage Coins!");
            profilePage();
        }
    }

    public void manageDecks() throws IOException {
        int deckCounter = 0;
        for (int i = 0; i < managingUser.getDecks().length; i ++)
            if (managingUser.getDecks()[i] != null)
                deckCounter++;
        if(deckCounter == 0){
            System.out.println("You currently have no Decks:");
            System.out.println("You have to create a Deck to continue.");
            managingUser.createDeck(deckCounter);
            profilePage();
        }else{
            System.out.println("You have the following Decks (max 5 allowed):");
            //for(int i=0;i<managingUser.getDecks().length;i++){
                //System.out.println("\t"+(i+1)+" - "+ Arrays.toString(managingUser.getDecks()));
            //}
            System.out.println(Arrays.toString(managingUser.getDecks()));
            System.out.println("How do you want to manage your Decks?:");
            System.out.println("Create a new deck (C/c)");
            System.out.println("Edit one of your Decks (E/e and the Decknumber listed above)");
            System.out.println("Delete a Deck (D/d and the Decknumber listed above)");
            System.out.println("Go back (Q/q)");
            if (inputHandler.next().toLowerCase(Locale.ROOT).charAt(0) == 'c') { managingUser.createDeck(deckCounter);}
            else if (inputHandler.next().toLowerCase(Locale.ROOT).matches("e[1-5]{1}")) {managingUser.editDeck();}
            else if (inputHandler.next().toLowerCase(Locale.ROOT).matches("d[1-5]{1}")) {managingUser.deleteDeck();}
            else if (inputHandler.next().toLowerCase(Locale.ROOT).charAt(0) == 'q') {profilePage();}
            else {
                System.out.println("ungültige Eingabe");
                manageDecks();
            }
        }
    }
    public void seeScoreboard(){}
    public void editProfile(){}

    public void profilePage() throws IOException {
        System.out.println("\nHello " + managingUser.getUsername() + ". You have "+ managingUser.getCoins() + " Magic Coins and " + managingUser.getStack().size() + " total Cards.\n" +
                "How can I help you today?");
        System.out.println("BATTLE to save the world! (B/b)"); //battle()
        //System.out.println("Open a portal to the Marketplace (M/m)");
        System.out.println("Buy new POWERS (Cost: 5 Magic Coins) (P/p)"); // buyPack()
        System.out.println("Manage your BattleDECKS (D/d)"); // createDeck()
        System.out.println("SEE the list of all Mesiah (S/s)"); // seeScoreboard()
        System.out.println("Go to sleep (Q/q)"); // quit()
        System.out.println("What to you want to do?:");
        switch (inputHandler.next().charAt(0)){
            case 'B':
            case 'b':
                battle();
            case 'P':
            case 'p':
                buyPack();
            case 'D':
            case 'd':
                manageDecks();
            case 'S':
            case 's':
                seeScoreboard();
            case 'Q':
            case 'q':
                quit();
        }
    }
    public void quit(){}
}
