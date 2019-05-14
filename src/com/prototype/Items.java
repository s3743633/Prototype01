package com.prototype;

import java.util.*;

public class Items {
    private String itemName;
    public int itemDefence;
    public int itemDamage;
    public int itemAmount;
    public boolean equipped;

    public Items(String name, int defence, int damage, int amount, boolean equipped) {
        this.itemName = name;
        this.itemDefence = defence;
        this.itemDamage = damage;
        this.itemAmount = amount;
        this.equipped = equipped;
    }

    public void setItemName(String name) {
        this.itemName = name;
    }

    public void setDefence(int defence) {
        this.itemDefence = defence;
    }

    public void setDamage(int damage) {
        this.itemDamage = damage;
    }

    public void setItemAmount(int amount) {
        this.itemAmount = amount;
    }

    public void setEquipped(boolean equipped){this.equipped = equipped; }

    public int getItemDamage() {
        return itemDamage;
    }

    public int getItemDefence() {
        return itemDefence;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public boolean equipped(){
        return equipped;
    }


    }



class Armour extends Items {
    public Armour(String name, int defence, int damage, int amount, boolean equipped) {

        super(name, defence, damage, amount, equipped);

    }

}

class Weapon extends Items {
    public Weapon(String name, int defence, int damage, int amount, boolean equipped) {

        super(name, defence, damage, amount, equipped);

    }

}

class Potion extends Items {

    public Potion(String name, int defence, int damage, int amount, boolean equipped) {

        super(name, defence, damage, amount, equipped);

    }


}
