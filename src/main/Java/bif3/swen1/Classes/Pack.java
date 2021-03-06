package bif3.swen1.Classes;

import bif3.swen1.Enum.Rarities;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Pack {

    private int cost = 5;
    private Card[] packCards = new Card[5];
    private int chance;
    private Random r = new Random();

    public Card[] getPackCards() {
        return packCards;
    }

    public Card getPackCard(int index) {
        return packCards[index];
    }

    public void setPackCard(Card card, int index) {
        this.packCards[index] = card;
    }

    public int getCost() {
        return cost;
    }

    public void getRandomCards() throws IOException {
        Collection collection = new Collection();
        collection.loadCollection();
        for(int i=0; i<=4; i++) {
            chance = r.nextInt(100) + 1; // globale variable + funktion für raritylist
            if (chance <= 3) {
                List<Card> legendaryList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.LEGENDARY)
                        .collect(Collectors.toList());
                this.packCards[i] = legendaryList.get(r.nextInt(legendaryList.size()));
                System.out.println("You got the Card: " + this.packCards[i].toString());
                //System.out.println(legendaryList);
            } else if (chance <= 13) {
                List<Card> epicList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.EPIC)
                        .collect(Collectors.toList());
                this.packCards[i] = epicList.get(r.nextInt(epicList.size()));
                System.out.println("You got the Card: " + this.packCards[i].toString());
            } else if (chance <= 65) {
                List<Card> rareList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.RARE)
                        .collect(Collectors.toList());
                this.packCards[i] = rareList.get(r.nextInt(rareList.size()));
                System.out.println("You got the Card: " + this.packCards[i].toString());
            } else {
                List<Card> commonList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.COMMON)
                        .collect(Collectors.toList());
                this.packCards[i] = commonList.get(r.nextInt(commonList.size()));
                System.out.println("You got the Card: " + this.packCards[i].toString());
            }
        }
    }
}
