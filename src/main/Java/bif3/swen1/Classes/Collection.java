package bif3.swen1.Classes;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

import bif3.swen1.Enum.Elements;
import bif3.swen1.Enum.Rarities;

public class Collection {

    ArrayList<Card> allCards = new ArrayList<>();

    public ArrayList<Card> getAllCards() {
        return allCards;
    }

    public void setAllCards(ArrayList<Card> allCards) {
        this.allCards = allCards;
    }

    public void loadCollection() throws IOException {
        String row;
        BufferedReader csvReader = new BufferedReader(new FileReader("Collection.csv"));
        while ((row = csvReader.readLine()) != null) {
            String[] data = row.split(";");
            //System.out.println(Arrays.toString(data));
            createCard(data[0],data[1],Elements.valueOf(data[3]),Rarities.valueOf(data[2].toUpperCase(Locale.ROOT)),Integer.parseInt(data[4]),data[5]);
        }
        csvReader.close();
    }

    public void createCard(String cardType, String name, Elements element, Rarities rarity, int damage, String monsterType){
        if(cardType.equals("Monster")){
            allCards.add(new Monster(name, element, rarity, damage, monsterType));
        }else if(cardType.equals("Spell")){
            allCards.add(new Spell(name, element, rarity, damage));
        }else{
            System.out.println("Wrong cardtype detected");
        }
    }
}
