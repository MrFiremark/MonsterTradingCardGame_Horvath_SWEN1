package bif3.swen1.Classes;
import bif3.swen1.Enum.Elements;
import bif3.swen1.Enum.Rarities;

public abstract class Card {

    private String name;
    private Elements element;
    private Rarities rarity;
    private int damage;

    public Card(String name, Elements element, Rarities rarity, int damage) {
        this.name = name;
        this.element = element;
        this.rarity = rarity;
        this.damage = damage;
    }

    public Rarities getRarity() {
        return rarity;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", element=" + element +
                ", rarity=" + rarity +
                ", damage=" + damage +
                ']';
    }
}
