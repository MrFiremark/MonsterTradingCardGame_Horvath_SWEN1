package bif3.swen1.Classes;

import java.io.IOException;
import java.util.ArrayList;

public class Marketplace {

    private ArrayList<Trade> trades;

    public Card[] getPack(User user) throws IOException {
        //Pack pack = new Pack();
        //pack.getRandomCards();
        //return pack.getPackCard();

        //TODO: Coins hier in der DB abwickeln

        Factory factory = new Factory();
        return factory.generatePack().getPackCards();
    }
    public int getPackCost(){
        Pack pack = new Pack();
        return pack.getCost();
    }
    public void createTade(){}
    public void buyTrade(User user){}

}
