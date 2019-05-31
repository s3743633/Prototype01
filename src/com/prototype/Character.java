/*
Intro to programming - Final Project
Created by Chris Jayawardena & Grant Cavanagh
RMIT semester 1 - June 2019

 */



package com.prototype;

import java.util.*;

//Superclass, makes it easier to create player objects and use the methods and attributes in the Map class.
//we can initiate any enemy object for fights or other items.
//There is a class for player, and utilities such as menus and inventory management.



public abstract class Character {

    public String name;
    public int health;
    public int defence;
    public int damage;
    public boolean isAlive;
    public int questID;
    int weaponDmg;
    public int gp;
    public int lives;
    Scanner inpu = new Scanner(System.in);

    public Character(String name, int health, int defence, int damage, boolean isAlive, int questID,int weaponDmg, int gp, int lives) {
        this.name = name;
        this.health = health;
        this.defence = defence;
        this.damage = damage;
        this.isAlive = isAlive;
        this.questID = questID;
        this.weaponDmg= weaponDmg;
        this.gp = gp;
        this.lives = lives;
    }

    //getters and setters so that we can change the value of the attributes for things such as healing items, weapons
    //and armour.
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setDefence(int defence) {
        this.defence = defence;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeaponDmg(int weaponDmg){
        this.weaponDmg = weaponDmg;
    }

    public void setgp(int gp){
        this.gp = gp;

    }

    public void setLives(int lives){
        this.lives = lives;
    }


    public void setAlive(boolean isAlive){this.isAlive = isAlive; }

    public int getDamage() {
        return damage;
    }

    public int getDefence() {
        return defence;
    }

    public int getHealth() {
        return health;
    }

    public String getName() {
        return name;
    }

    public boolean isAlive(){
        return health > 0;
    }

    public int getWeaponDmg(){
        return weaponDmg;
    }

    public int getgp(){
        return gp;
    }

    public int getLives(){
        return lives;
    }

}


//Player class is a subclass of character, inheriting its attributes.
    class Player extends Character {
        int numOfPotions = 3;
        int potHealAmount = 20;

    public void line(){
        for (int i = 0; i <40; i++){
            System.out.print("-");}
        System.out.println();
    }

//constructor used to create enemies, NPCs, and player character.

        public Player(String name, int health, int defence, int damage, boolean isAlive, int questID, int weaponDmg, int gp, int lives) {

            super(name, health, defence, damage, isAlive, questID, weaponDmg, gp, lives);

        }

        //attack function, used to simplify the fight function

        //method parameters, a is the player, b is the object the player is versing.
        public void attack(Player a, Player b) {
            Random rand = new Random();
            //generates random damage value for both player and enemy.
            //math max, makes it so the damage cant be below 0, which would be possible since defence lowers damage
            int damage = Math.max(0, rand.nextInt(a.getDamage() + a.getWeaponDmg()) - (rand.nextInt(b.getDefence())/2));
            int monsDamage = Math.max(0, rand.nextInt(b.getDamage() + b.getWeaponDmg()) - rand.nextInt(a.getDefence()));
            //sets it so health cant drop below 0
            int health = Math.max(0, b.getHealth() - damage);
            b.setHealth(health);
            line();
            System.out.println("you hit a " + damage);
            System.out.println(b.getName() + " hp is now:" + health);
            //validation check, to see if the player or enemy dies.
            if (!b.isAlive()) {
                b.setAlive(false);
                line();
                System.out.println("You killed: " + b.getName()+"!");
                //100% potion drop chance.
               randDrops();
                //numOfPotions++;
              // System.out.println("Congrats! "+b.getName() + ", dropped a potion, and you picked it up!");
            }
            else if (!a.isAlive()){
                a.setAlive(false);
            }

            else {
                //the else is to prevent the enemy from dealing damage to the player if it dies in that turn.
                int yourHP = Math.max(0, a.getHealth() - monsDamage);
                a.setHealth(yourHP);
                System.out.println(b.getName() + " did " + monsDamage);
                System.out.println("your health is now: " + yourHP);
            }
        }


        public void fight(Player a, Player b) {


            do {
                line();
                System.out.println("what do you want to do?");
                System.out.println("\tattack\n\theal\n\trun");
                String choice = inpu.nextLine();

                if (choice.equalsIgnoreCase("attack")) {
                    attack(a, b);
                } else if (choice.equalsIgnoreCase("run")) {
                    line();
                    System.out.println("you resolve yourself to try and beat the foe before you" + (b.getDamage() + 1));
                } else if (choice.equalsIgnoreCase("heal")) {
                    line();
                    int loop = 0;
                    while (loop == 0) {
                        System.out.println("You have " + numOfPotions + " potion(s) left.");
                        System.out.println("Would you like to use a potion?");
                        System.out.println("\tYes");
                        System.out.println("\tNo");
                        choice = inpu.nextLine();
                        loop = 1;
                        while (loop == 1) {

                            if (choice.equalsIgnoreCase("Yes")) {
                                if (numOfPotions >= 1) {
                                    if (a.getHealth() < 100) {
                                        int yourHP = Math.min(100, a.getHealth() + potHealAmount);
                                        a.setHealth(yourHP);
                                        numOfPotions--;
                                        line();
                                        System.out.println("You use a potion,\nYour current HP is now: " + a.getHealth());
                                        loop = 0;
                                    } else {
                                        line();
                                        System.out.println("Your HP is now Full!");
                                        loop = 2;
                                    }
                                } else {
                                    line();
                                    System.out.println("Sorry, you are out of potions!");
                                    loop = 2;

                                }

                            } else if (choice.equalsIgnoreCase("no")) {
                                break;

                            } else {
                                line();
                                System.out.println("Invalid input");
                                loop = 1;
                            }
                        }
                    }
                    }
                else{
                        line();
                        System.out.println("Invalid input");
                    }

            }
            while (a.isAlive() && b.isAlive());
            if (!a.isAlive()) {
                a.setHealth(50);
                a.setgp(a.getgp() - 100);
                a.setLives(a.getLives() - 1);


                if (a.getLives() >= 1) {
                    line();
                    System.out.println("You have " + (a.getLives()) + " lives lefts");
                    System.out.println("your health is now " + a.getHealth());
                    System.out.println("your gp is now " + a.getgp());
                    a.isAlive = true;

                } else{
                    line();
                    System.out.println("Do you want to buy more lives? Send $1 to HAPPY DUDE");
                    System.exit(0);
                }
            }
        }


            public void menu (Player a){
                int loop = 0;
                while (loop == 0) {
                    Scanner input = new Scanner(System.in);
                    line();
                    System.out.println("\tHeal");
                    System.out.println("\tCheck Status");
                    System.out.println("\tExit");
                    System.out.println("\tQuit the game");
                    String menu = input.nextLine();
                    loop = 1;

                    while (loop == 1) {
                        if (menu.equalsIgnoreCase("heal")) {
                            line();
                            System.out.println("You have " + numOfPotions + " potion(s) left.");
                            System.out.println("Would you like to use 1 potion?");
                            System.out.println("\tYes");
                            System.out.println("\tNo");
                            String choice = input.nextLine();
                            loop = 2;

                            while (loop == 2) {
                                if (choice.equalsIgnoreCase("Yes")) {
                                    if (numOfPotions >= 1) {
                                        if (a.getHealth() < 100) {
                                            int yourHP = Math.min(100, a.getHealth() + potHealAmount);
                                            a.setHealth(yourHP);
                                            numOfPotions--;
                                            line();
                                            System.out.println("Your current HP is now: " + a.getHealth());
                                            loop = 1;
                                        } else {
                                            System.out.println("\nYour HP is Full!");
                                            loop = 0;
                                        }

                                    } else {
                                        line();
                                        System.out.println("Sorry, you are out of potions!");
                                        loop = 0;

                                    }
                                } else if (choice.equalsIgnoreCase("No")) {
                                    loop = 0;

                                } else {
                                    line();
                                    System.out.println("Invalid input");
                                    loop = 1;
                                }
                            }

                        } else if (menu.equalsIgnoreCase("check status")) {
                            line();
                            System.out.println("Your current stats are: ");
                            System.out.println("Name: " + a.getName());
                            System.out.println("Health: " + a.getHealth());
                            System.out.println("Damage: " + a.getDamage());
                            System.out.println("Defence: " + a.getDefence());
                            System.out.println("Weapon damage: " + a.getWeaponDmg());
                            System.out.println("Money: " + a.getgp());
                            loop = 0;

                        } else if (menu.equalsIgnoreCase("Exit")) {
                            break;

                        }else if(menu.equalsIgnoreCase("quit") || menu.equalsIgnoreCase("quit the game")) {
                            System.exit(0);
                        }else {
                            line();
                            System.out.println("Invalid input, try again");
                            loop = 0;
                        }
                    }
                }
            }

            public void randDrops(){
            Random drops = new Random();
            int [] money = {10,20,40,60,80,100,150,200};
            if(drops.nextInt(100) > 70){
                numOfPotions++;
                System.out.println("the enemy dropped a health potion!");
            }else if(drops.nextInt(100) < 70){
                //selects a random element to determine amount of money dropped. This is so the value of money is set and you wont get drops of 0 or 1
                int x = randomElement(money);
                System.out.println("the enemy dropped " + x + " coins!");
                setgp(getgp() + x);
            }else{
                System.out.println("the enemy didnt drop anything");
            }

            }

            public static int randomElement(int[] array){
        //generate a random element in an array
                int rnd = new Random().nextInt(array.length);
                return array[rnd];
            }

            public void portShop(Player a){
        int loop = 0;

        while (loop == 0) {
            loop = 1;
                    while (loop == 1) {
                if (numOfPotions>=20){
                    System.out.println("Sorry, your inventory is full to buy anymore potions");
                    break;
                }
                else if (a.getgp() <=19) {
                            System.out.println("Sorry, you don't have enough gp!");
                            break;
                        }
                else {
            line();
            System.out.println("Current gp is: "+a.getgp());
            System.out.println("A potion costs 20gp each, how many potions do you want to buy?");
            System.out.println("\t1\n\t3\n\t5\t\nExit");
            String choice = inpu.nextLine();


            if (choice.equalsIgnoreCase("1")) {
                line();
                numOfPotions++;
                a.setgp(Math.max(0, a.getgp() - 20));
                System.out.println("You now have: " + a.getgp() + "gp left");
                System.out.println("You now have: " + numOfPotions + " potions.");
                loop = 0;
            } else if (choice.equalsIgnoreCase("3")) {
                line();
                numOfPotions += 3;
                a.setgp(Math.max(0, a.getgp() - 20 * 3));
                System.out.println("You now have: " + a.getgp() + "gp left");
                System.out.println("You now have: " + numOfPotions + " potions.");
                loop = 0;
            } else if (choice.equalsIgnoreCase("5")) {
                line();
                numOfPotions += 5;
                a.setgp(Math.max(0, a.getgp() - 20 * 5));
                System.out.println("You now have: " + a.getgp() + "gp left");
                System.out.println("You now have: " + numOfPotions + " potions.");
                loop = 0;
            } else if (choice.equalsIgnoreCase("exit")) {
                break;

            } else {
                System.out.println("Invalid Input");
                loop = 0;
            }

            }
                }
                    }



            }
        }






