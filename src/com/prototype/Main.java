package com.prototype;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
Scanner input = new Scanner(System.in);
Player wolf = new Player("wolf", 50, 1, 20, true);
Player player1 = new Player("bob", 100, 100,20, true);
Inventory currInv = new Inventory();

        Armour rustyarmour = new Armour("Rusty Platebody", 5, 0, 1, false);

        Weapon rustysword = new Weapon("Rusty Sword", 0, 5, 1, false);

        Potion healing = new Potion("Healing Potion,", 0, 0, 5, true);


System.out.println("fight test");

 player1.fight(player1, wolf, currInv);

    }


}