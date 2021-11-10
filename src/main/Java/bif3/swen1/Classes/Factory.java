package bif3.swen1.Classes;

import bif3.swen1.Enum.Rarities;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Factory {

    private final Pack finishedPack = new Pack();
    private final Random r = new Random();
    private final Collection collection = new Collection();

    public Factory() throws IOException {
        collection.loadCollection();
    }

    public Pack generatePack () {
        for (int i = 0; i <= 4; i++) {
            int chance = r.nextInt(100) + 1;
            if (chance <= 3) {
                rarityList(Rarities.LEGENDARY, i);
            } else if (chance <= 13) {
                rarityList(Rarities.EPIC, i);
            } else if (chance <= 65) {
                rarityList(Rarities.RARE, i);
            } else {
                rarityList(Rarities.COMMON, i);
            }
        }
        return finishedPack;
    }

    public void rarityList(Enum<Rarities> raritiesEnum, int index){
        List<Card> rarityList = collection.getAllCards()
                .stream()
                .filter(c -> c.getRarity() == raritiesEnum)
                .collect(Collectors.toList());
        finishedPack.setPackCard(rarityList.get(r.nextInt(rarityList.size())), index);
        System.out.println("You got the Card: " + finishedPack.getPackCard(index).toString());
    }
}
