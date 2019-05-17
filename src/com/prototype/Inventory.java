package com.prototype;

import java.util.*;
import java.util.Arrays;
public class Inventory {

    public Items item = new Items("", 0, 0, 0);
    private ArrayList<Items> items = new ArrayList<Items>();
    String str = Arrays.toString(items.toArray());

    public Inventory() {
    }

    public void printInventory() {
        items.forEach(System.out::println);

    }

    public void createItem(String name, int damage, int defence, int itemid) {
        this.items.add(new Items(name, 0, 0, 0));

    }




}


// ArrayList<String> weapon = new ArrayList<String>();
//   ArrayList<String> armour = new ArrayList<String>();
//  int numOfPotions = 3;

//  weapon.set(0, "Rusty Sword");
//   weapon.set(1, "Bronze Sword");
//  weapon.set(2, "Steel Sword");
//  weapon.set(3, "Mithril Sword");
//  weapon.set(4, "Adamant Sword");
