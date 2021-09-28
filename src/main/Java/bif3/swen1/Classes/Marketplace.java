package bif3.swen1.Classes;

import java.io.IOException;

public class Marketplace {

    private Trade[] trades;

    public Card[] getPack() throws IOException {
        Pack pack = new Pack();
        pack.getRandomCards();
        return pack.getPackCards();
    }
    public void createTade(){}
    public void buyTrade(User user){}

}
