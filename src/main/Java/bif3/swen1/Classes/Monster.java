package bif3.swen1.Classes;

import bif3.swen1.Enum.Elements;
import bif3.swen1.Enum.Rarities;

public class Monster extends Card{

    private String type;

    public Monster(String name, Elements element, Rarities rarity, int damage, String type) {
        super(name, element, rarity, damage);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
