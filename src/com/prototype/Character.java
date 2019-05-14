package com.prototype;

import java.util.*;

public abstract class Character {
    private String name;
    public int health;
    private int defence;
    private int damage;
    private boolean isAlive;
    public int questID;


    public Character(String name, int health, int defence, int damage, boolean isAlive, int questID) {
        this.name = name;
        this.health = health;
        this.defence = defence;
        this.damage = damage;
        this.isAlive = isAlive;
        this.questID = questID;
    }

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
}


    class Player extends Character {

        int numOfPotions = 3;
        int potHealAmount = 20;
        String weapon = "";
        String armour = "";


        public Player(String name, int health, int defence, int damage, boolean isAlive, int questID) {

            super(name, health, defence, damage, isAlive, questID);

        }

        public void attack(Player a, Player b) {
            Random rand = new Random();
            int damage = Math.max(0, rand.nextInt(a.getDamage()) - b.getDefence());
            int monsDamage = Math.max(0, rand.nextInt(b.getDamage()) - a.getDefence());
            int health = Math.max(0, b.getHealth() - damage);
            b.setHealth(health);
            System.out.println("you hit a " + damage);
            System.out.println(b.getName() + " hp is now:" + health);
            if (!b.isAlive()) {
                System.out.println("You killed: " + b.getName());
                numOfPotions ++;
                System.out.println("Congrats! "+b.getName() + ", dropped a potion, and you picked it up!");
            } else {
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
                else if (choice.equalsIgnoreCase("heal")){
                    System.out.println(+ numOfPotions + " potion(s) left.");
                    System.out.println("Would you like to use a potion?");
                    System.out.println("\tYes");
                    System.out.println("\tNo");
                    String yn = input.nextLine();
                        if (yn.equalsIgnoreCase("Yes")) {
                            if (numOfPotions >= 1) {
                                int yourHP = Math.min(100, a.getHealth() + potHealAmount);
                                a.setHealth(yourHP);
                                numOfPotions--;
                                System.out.println("Your HP is now: " + a.getHealth());

                            } else if (numOfPotions == 0) {
                                System.out.println("Sorry, you are out of potions!");

                            }
                         else if (yn.equalsIgnoreCase("No")) {
                            break;

                        } else {
                            System.out.println("Invalid input");
                        }
                    }


                }
            } while (a.isAlive() && b.isAlive());
            if (!a.isAlive()) {
                System.out.println("RIP Game Over!");
            }

        }

        public void menu(Player a) {
            int loop = 0;
            while (loop == 0) {
                Scanner input = new Scanner(System.in);
                System.out.println("Equip item");
                System.out.println("Use Potion");
                System.out.println("Check Status");
                System.out.println("Exit");
                String menu = input.nextLine();
                loop = 1;

                while (loop == 1) {
                    if (menu.equalsIgnoreCase("equip item")) {
                        System.out.println("what do you want to equip?");
                        loop = 0;

                    } else if (menu.equalsIgnoreCase("use potion")) {
                        System.out.println("You have " + numOfPotions + "potion(s) left.");
                        System.out.println("Would you like to use a potion?");
                        System.out.println("\tYes");
                        System.out.println("\tNo");
                        String choice = input.nextLine();
                        loop = 2;

                        while (loop == 2) {
                            if (choice.equalsIgnoreCase("Yes")) {
                                if (numOfPotions >= 1) {
                                    int yourHP = Math.min(100, a.getHealth() + potHealAmount);
                                    a.setHealth(yourHP);
                                    numOfPotions--;
                                    System.out.println("Your current HP is now: " + a.getHealth());
                                    loop = 1;

                                } else if (numOfPotions == 0) {
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
                        System.out.println("Name = " + a.getName());
                        System.out.println("Health = " + a.getHealth());
                        System.out.println("Damage = " + a.getDamage());
                        System.out.println("Defence = " + a.getDefence());
                        loop = 0;

                    } else if (menu.equalsIgnoreCase("Exit")){
                      break;
                    }
                    else {
                        System.out.println("Invalid input, try again");
                        loop = 0 ;
                    }
                }
            }
        }
    }