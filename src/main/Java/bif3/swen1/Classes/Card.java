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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Elements getElement() {
        return element;
    }

    public void setElement(Elements element) {
        this.element = element;
    }

    public Rarities getRarity() {
        return rarity;
    }

    public void setRarity(Rarities rarity) {
        this.rarity = rarity;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
