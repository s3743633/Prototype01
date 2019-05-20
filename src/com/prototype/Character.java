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
    private boolean isAlive;
    public int questID;
    int weaponDmg;

    public Character(String name, int health, int defence, int damage, boolean isAlive, int questID,int weaponDmg) {
        this.name = name;
        this.health = health;
        this.defence = defence;
        this.damage = damage;
        this.isAlive = isAlive;
        this.questID = questID;
        this.weaponDmg= weaponDmg;
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
}

//Player class is a subclass of character, inheriting its attributes.
    class Player extends Character {
        int currPos = 2;
        int numOfPotions = 3;
        int potHealAmount = 20;
        String weapon = "";
        String armour = "";
        ArrayList<String> Equipment = new ArrayList<String>();

//constructor used to create enemies, NPCs, and player character.

        public Player(String name, int health, int defence, int damage, boolean isAlive, int questID, int weaponDmg) {

            super(name, health, defence, damage, isAlive, questID, 0);

        }

        //attack function, used to simplify the fight function

        //method parameters, a is the player, b is the object the player is versing.
        public void attack(Player a, Player b) {
            Random rand = new Random();
            //generates random damage value for both player and enemy.
            //math max, makes it so the damage cant be below 0, which would be possible since defence lowers damage
            int damage = Math.max(0, rand.nextInt(a.getDamage() + a.getWeaponDmg()) - b.getDefence());
            int monsDamage = Math.max(0, rand.nextInt(b.getDamage() + b.getWeaponDmg()) - a.getDefence());
            //sets it so health cant drop below 0
            int health = Math.max(0, b.getHealth() - damage);
            b.setHealth(health);
            System.out.println("you hit a " + damage);
            System.out.println(b.getName() + " hp is now:" + health);
            //validation check, to see if the player or enemy dies.
            if (!b.isAlive()) {
                System.out.println("You killed: " + b.getName());
                //100% potion drop chance.
                numOfPotions ++;
                System.out.println("Congrats! "+b.getName() + ", dropped a potion, and you picked it up!");
            } else {
                //the else is to prevent the enemy from dealing damage to the player if it dies in that turn.
                int yourHP = Math.max(0, a.getHealth() - monsDamage);
                a.setHealth(yourHP);
                System.out.println(b.getName() + " did " + monsDamage);
                System.out.println("your health is now: " + yourHP);
            }
        }


        public void fight(Player a, Player b) {
            Scanner input = new Scanner(System.in);

            do {
                System.out.println("what do you want to do?");
                System.out.println("attack, heal or runaway?");
                String choice = input.nextLine();

                if (choice.equalsIgnoreCase("attack")) {
                    attack(a, b);
                }
                    else if(choice.equalsIgnoreCase("run")){
                    System.out.println("you resolve yourself to try and beat the foe before you" + (b.getDamage() + 1));
                }
                else if (choice.equalsIgnoreCase("heal")){
                    System.out.println(+ numOfPotions + " potion(s) left.");
                    System.out.println("Would you like to use a potion?");
                    System.out.println("\tYes");
                    System.out.println("\tNo");
                    choice = input.nextLine();
                    int loop =0;
                        while (loop==0) {
                            if (choice.equalsIgnoreCase("Yes")) {
                                if (numOfPotions >= 1) {
                                    int yourHP = Math.min(100, a.getHealth() + potHealAmount);
                                    a.setHealth(yourHP);
                                    numOfPotions--;
                                    System.out.println("Your HP is now: " + a.getHealth());
                                    loop = 1;

                                }

                            } else if (numOfPotions == 0) {
                                System.out.println("Sorry, you are out of potions!");
                            } else if (choice.equalsIgnoreCase("no")) {
                                loop = 1;

                            } else {
                                System.out.println("Invalid input");
                                loop = 1;
                            }
                        }
                    }


                }
             while (a.isAlive() && b.isAlive());
            if (!a.isAlive()) {
                System.out.println("RIP Game Over!");
            }

        }

        public void menu(Player a) {
            int loop = 0;
            while (loop == 0) {
                Scanner input = new Scanner(System.in);
                System.out.println("Heal");
                System.out.println("Check Status");
                System.out.println("Exit");
                String menu = input.nextLine();
                loop = 1;

                while (loop == 1) {
                    if (menu.equalsIgnoreCase("heal")) {
                        System.out.println("You have " + numOfPotions + " potion(s) left.");
                        System.out.println("Would you like to use a potion?");
                        System.out.println("\tYes");
                        System.out.println("\tNo");
                        String choice = input.nextLine();
                        loop = 2;

                        while (loop == 2) {
                            if (choice.equalsIgnoreCase("Yes")) {
                                if (numOfPotions >= 1) {
                                    if (a.getHealth() < 100){
                                    int yourHP = Math.min(100, a.getHealth() + potHealAmount);
                                    a.setHealth(yourHP);
                                    numOfPotions--;
                                    System.out.println("Your current HP is now: " + a.getHealth());
                                    loop = 1;
                                    }
                                    else {
                                        System.out.println("Your HP is Full!");
                                        loop = 0;
                                    }

                                } else {
                                    System.out.println("Sorry, you are out of potions!");
                                    loop = 0;

                                }
                            } else if (choice.equalsIgnoreCase("No")) {
                                loop = 0;

                            } else {
                                System.out.println("Invalid input");
                                loop = 1;
                            }
                        }

                    } else if (menu.equalsIgnoreCase("check status")) {
                        System.out.println("Your current stats are: ");
                        System.out.println("Name: " + a.getName());
                        System.out.println("Health: " + a.getHealth());
                        System.out.println("Damage: " + a.getDamage());
                        System.out.println("Defence: " + a.getDefence());
                        System.out.println("Weapon damage: " + a.getWeaponDmg());

                    } else if (menu.equalsIgnoreCase("Exit")) {
                        break;

                    } else System.out.println("Invalid input, try again");
                    loop = 0;
                }
            }
        }

}

