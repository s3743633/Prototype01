package com.prototype;

import java.util.*;

public class Items {
    public String itemName;
    public int itemDefence;
    public int itemDamage;
    public int itemId;

    public Items(String name, int defence, int damage, int itemId){
        this.itemName = name;
        this.itemDefence = defence;
        this.itemDamage = damage;
        this.itemId = itemId;
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

  //  public void setEquipped(boolean equipped){this.equipped = equipped; }

    public int getItemDamage() {
        return this.itemDamage;
    }

    public int getItemDefence() {
        return this.itemDefence;
    }

    public String getItemName() {
        return this.itemName;
    }

   // public boolean equipped(){
     //   return equipped;
    //}


}



class Armour extends Items {
    public Armour(String name, int defence, int damage, int itemId) {

        super(name, defence, damage, itemId);

    }

}

class Weapon extends Items {
    public Weapon(String name, int defence, int damage,int itemId) {

        super(name, defence, damage, itemId);

    }
}

