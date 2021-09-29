package bif3.swen1.Classes;

import java.io.IOException;

public class Marketplace {

    private Trade[] trades;

    public Card[] getPack() throws IOException {
        Pack pack = new Pack();
        pack.getRandomCards();
        return pack.getPackCards();
    }
    public int getPackCost(){
        Pack pack = new Pack();
        return pack.getCost();
    }
    public void createTade(){}
    public void buyTrade(User user){}

}
