package bif3.swen1.Classes;

public class GameManager {

    private User managingUser;
    //private String inputHandler;

    public void register(String username, String password){
        this.managingUser = new User(username, password, 20, 100);
        //TODO: SQL-Insert into User_DB
        //TEMP: save credentials in csv
    }
    public void login(String username, String password){
        //TODO: SQL-Select from User_DB
    }
    public void buyPack(){}
    public void battle(){}
    public void seeScoreboard(){}
    public void editProfile(){}
    public void quit(){}
}
