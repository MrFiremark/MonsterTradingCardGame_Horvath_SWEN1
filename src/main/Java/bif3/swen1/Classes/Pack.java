package bif3.swen1.Classes;

import bif3.swen1.Enum.Rarities;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Pack {

    int cost = 5;
    Card[] packCards = new Card[5];

    public Card[] getPackCards() {
        return packCards;
    }

    public void getRandomCards() throws IOException {
        Collection collection = new Collection();
        collection.loadCollection();
        Random r = new Random();
        for(int i=0; i<=4; i++) {
            int chance = r.nextInt(100) + 1;
            if (chance <= 5) {
                List<Card> legendaryList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.LEGENDARY)
                        .collect(Collectors.toList());
                this.packCards[i] = legendaryList.get(r.nextInt(legendaryList.size()));
                System.out.println("You got Card: " + this.packCards[i].toString());
                //System.out.println(legendaryList);
            } else if (chance > 5 && chance <= 20) {
                List<Card> epicList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.EPIC)
                        .collect(Collectors.toList());
                this.packCards[i] = epicList.get(r.nextInt(epicList.size()));
                System.out.println("You got Card: " + this.packCards[i].toString());
            } else if (chance > 20 && chance <= 55) {
                List<Card> rareList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.RARE)
                        .collect(Collectors.toList());
                this.packCards[i] = rareList.get(r.nextInt(rareList.size()));
                System.out.println("You got Card: " + this.packCards[i].toString());
            } else {
                List<Card> commonList = collection.getAllCards()
                        .stream()
                        .filter(c -> c.getRarity() == Rarities.COMMON)
                        .collect(Collectors.toList());
                this.packCards[i] = commonList.get(r.nextInt(commonList.size()));
                System.out.println("You got Card: " + this.packCards[i].toString());
            }
        }
    }
}
