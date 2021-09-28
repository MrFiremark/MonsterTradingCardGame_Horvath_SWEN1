package bif3.swen1.Classes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GameManager {

    private User managingUser;
    private Scanner inputHandler = new Scanner(System.in);

    public void register(String username, String password) throws IOException {
        ArrayList<Card> stack = new ArrayList<>();
        ArrayList<Card> decks = new ArrayList<>();
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
    public void buyPack() throws IOException {
        Marketplace marketplace = new Marketplace();
        ArrayList<Card> stack = new ArrayList<>();
        Collections.addAll(stack, marketplace.getPack());
        managingUser.setStack(stack);
    }
    public void battle(){}
    public void seeScoreboard(){}
    public void editProfile(){}

    public void profilePage() throws IOException {
        System.out.println("Hello " + managingUser.getUsername() + ". You have "+ managingUser.getCoins() + " Coins available.\n" +
                "How can I help you today?");
        System.out.println("BATTLE to save the world! (B/b)"); //battle()
        //System.out.println("Open a portal to the Marketplace (M/m)");
        System.out.println("Buy new POWERS (P/p)"); // buyPack()
        System.out.println("CREATE your new BattleDECK (C/c)"); // createDeck()
        System.out.println("SEE the list of all Mesiah (S/s)"); // seeScoreboard()
        System.out.println("Go to sleep (Q/q)"); // quit()
        System.out.println("What to you want to do?:\n");
        switch (inputHandler.next().charAt(0)){
            case 'B':
            case 'b':
                battle();
            case 'P':
            case 'p':
                buyPack();
            case 'C':
            case 'c':
                managingUser.createDeck();
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
